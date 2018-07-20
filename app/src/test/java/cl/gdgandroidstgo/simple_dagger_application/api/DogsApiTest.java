package cl.gdgandroidstgo.simple_dagger_application.api;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cl.gdgandroidstgo.simple_dagger_application.api.response.ListBreedResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

import static org.junit.Assert.*;

public class DogsApiTest {

    DogsApi dogsApi;

    @Before
    public void setUp() throws Exception {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/")
                .addConverterFactory(MoshiConverterFactory.create()).build();
        
        dogsApi = builder.create(DogsApi.class);
    }

    @Test
    public void getListBreed() throws IOException {
        Response<ListBreedResponse> response = dogsApi.getListBreed().execute();
        assertNotNull(response.body().getMessage());
    }
}