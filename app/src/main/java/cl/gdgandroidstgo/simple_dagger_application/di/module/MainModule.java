package cl.gdgandroidstgo.simple_dagger_application.di.module;

import cl.gdgandroidstgo.simple_dagger_application.api.DogsApi;
import cl.gdgandroidstgo.simple_dagger_application.listBreed.BreedViewHolder;
import cl.gdgandroidstgo.simple_dagger_application.listBreed.BreedViewHolderProvider;
import cl.gdgandroidstgo.simple_dagger_application.listBreed.BreedWithSubBreedViewHolder;
import cl.gdgandroidstgo.simple_dagger_application.listBreed.ListBreedContract;
import cl.gdgandroidstgo.simple_dagger_application.listBreed.ListBreedPresenter;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import retrofit2.Retrofit;

import static cl.gdgandroidstgo.simple_dagger_application.listBreed.BreedsAdapter.VIEW_TYPE_BREED_WITH_SUB_BREED;
import static cl.gdgandroidstgo.simple_dagger_application.listBreed.BreedsAdapter.VIEW_TYPE_ONLY_BREED;

@Module
public class MainModule {

    @Provides
    public DogsApi provideDogsApi(Retrofit retrofit) {
        return retrofit.create(DogsApi.class);
    }

    @Provides
    public ListBreedContract.Presenter providePrresenter(DogsApi api) {
        return new ListBreedPresenter(api);
    }

    @Provides
    @IntoMap
    @IntKey(VIEW_TYPE_ONLY_BREED)
    public BreedViewHolderProvider provideViewHolderProvider() {
        return BreedViewHolder::new;
    }

    @Provides
    @IntoMap
    @IntKey(VIEW_TYPE_BREED_WITH_SUB_BREED)
    public BreedViewHolderProvider provideVViewHolderProvierOther() {
        return BreedWithSubBreedViewHolder::new;
    }
}
