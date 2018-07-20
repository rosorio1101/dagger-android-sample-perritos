package cl.gdgandroidstgo.simple_dagger_application.listBreed;

import android.annotation.SuppressLint;
import android.util.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

import cl.gdgandroidstgo.simple_dagger_application.api.DogsApi;
import cl.gdgandroidstgo.simple_dagger_application.api.response.BreedImageResponse;
import cl.gdgandroidstgo.simple_dagger_application.commons.BaseAbstractPresenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListBreedPresenter extends BaseAbstractPresenter<ListBreedContract.View> implements ListBreedContract.Presenter {
    private static final String TAG = ListBreedPresenter.class.getSimpleName();

    private DogsApi api;
    private MapEntryBreedToBreedMapper toBreedMapper;
    private BreedToViewModelMapper toViewModelMapper;
    private Disposable disposable;

    public ListBreedPresenter(DogsApi api) {
        this.api = api;
        this.toBreedMapper = new MapEntryBreedToBreedMapper();
        this.toViewModelMapper = new BreedToViewModelMapper();
    }

    @SuppressLint("CheckResult")
    @Override
    public void getBreeds() {
        getView().showLoading();
        disposable = api.getListBreedRx()
                .cache()
                .doOnSuccess(listBreedResponse -> Log.d("Response Status %s", listBreedResponse.getStatus()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(listBreedResponse -> toBreedMapper.mapAll(listBreedResponse.getMessage().entrySet()))
                .flatMapObservable(Observable::fromIterable)
                .concatMap(breed -> Observable.just(breed).delay(400, TimeUnit.MILLISECONDS))
                .flatMapSingle((Breed breed) -> api.getImageBreedRandomRx(breed.getName())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .cache()
                        .map((BreedImageResponse breedImageResponse) -> {
                            if (breedImageResponse != null) {
                                breed.setRandomImage(breedImageResponse.getMessage());
                            }
                            return breed;
                        })).toList().subscribe(this::onSuccess, this::onError);
    }

    private void onSuccess(List<Breed> breeds) {
        Log.d(TAG, String.format("Total Breed %d", breeds.size()));
        getView().hideLoading();
        getView().showBreedList(toViewModelMapper.mapAll(breeds));
    }

    private void onError(Throwable error) {
        Log.d(TAG, String.format("Error %s", error.getMessage()));
        getBreeds();
    }

    @Override
    public void stop() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
