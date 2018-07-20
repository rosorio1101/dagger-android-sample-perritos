package cl.gdgandroidstgo.simple_dagger_application.api;

import cl.gdgandroidstgo.simple_dagger_application.api.response.BreedImageResponse;
import cl.gdgandroidstgo.simple_dagger_application.api.response.BreedImagesResponse;
import cl.gdgandroidstgo.simple_dagger_application.api.response.ListBreedResponse;
import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DogsApi {
    @GET("breeds/list/all")
    Call<ListBreedResponse> getListBreed();

    @GET("breeds/list/all")
    Single<ListBreedResponse> getListBreedRx();

    @GET("breed/{breed}/images/random")
    Single<BreedImageResponse> getImageBreedRandomRx(@Path("breed") String breed);

    @GET("breed/{breed}/images")
    Call<BreedImagesResponse> getImageBreed(@Path("breed") String breed);
}
