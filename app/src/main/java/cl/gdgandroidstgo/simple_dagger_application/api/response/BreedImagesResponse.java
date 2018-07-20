package cl.gdgandroidstgo.simple_dagger_application.api.response;

import java.util.List;

public class BreedImagesResponse extends BaseResponse<List<String>> {
    public BreedImagesResponse(String status, List<String> message) {
        super(status, message);
    }
}
