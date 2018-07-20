package cl.gdgandroidstgo.simple_dagger_application.api.response;

import java.util.List;
import java.util.Map;

public class ListBreedResponse extends BaseResponse<Map<String, List<String>>> {

    public ListBreedResponse(String status, Map<String, List<String>> message) {
        super(status, message);
    }
}
