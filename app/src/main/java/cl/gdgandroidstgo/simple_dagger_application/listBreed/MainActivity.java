package cl.gdgandroidstgo.simple_dagger_application.listBreed;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.style.DoubleBounce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cl.gdgandroidstgo.simple_dagger_application.R;
import cl.gdgandroidstgo.simple_dagger_application.api.DogsApi;
import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MainActivity extends AppCompatActivity implements ListBreedContract.View {

    private final static String TAG = MainActivity.class.getSimpleName();

    public static final String ARG_BREEDS = "ARG_BREEDS";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.breeds_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.spin_kit)
    SpinKitView progressBar;

    Unbinder unbinder;

    @Inject
    BreedsAdapter adapter;

    @Inject
    ListBreedContract.Presenter presenter;


    private ArrayList<BreedViewModel> breedViewModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        adapter.setBreeds(breedViewModels);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        presenter.attachView(this);

        if (savedInstanceState != null) {
            breedViewModels = savedInstanceState.getParcelableArrayList(ARG_BREEDS);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (breedViewModels != null && !breedViewModels.isEmpty()) {
            hideLoading();
            adapter.setBreeds(breedViewModels);
        } else {
            presenter.getBreeds();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(ARG_BREEDS, breedViewModels);
    }

    @Override
    public void showBreedList(List<BreedViewModel> breeds) {
        this.breedViewModels = (ArrayList<BreedViewModel>) breeds;
        adapter.setBreeds(breedViewModels);
    }

    @Override
    public void showLoading() {
        runOnUiThread(() -> {
            recyclerView.animate().alpha(0).start();
            progressBar.animate().alpha(1).start();
        });
    }

    @Override
    public void hideLoading() {
        runOnUiThread(() -> {
            progressBar.animate().alpha(0).setDuration(500).withEndAction(() -> {
                recyclerView.animate().alpha(1).setDuration(500).start();
            }).start();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        presenter.detachView();
    }

}
