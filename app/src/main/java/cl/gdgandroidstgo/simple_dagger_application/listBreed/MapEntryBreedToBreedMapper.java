package cl.gdgandroidstgo.simple_dagger_application.listBreed;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import cl.gdgandroidstgo.simple_dagger_application.commons.mapper.BaseMapper;

public class MapEntryBreedToBreedMapper extends BaseMapper<Map.Entry<String, List<String>>, Breed> {

    @Override
    public Breed map(Map.Entry<String, List<String>> input) {
        Breed breed = new Breed(input.getKey());
        if (!input.getValue().isEmpty()) {
            List<Breed> subBreeds = new ArrayList<>(input.getValue().size());
            for (String subBreedName : input.getValue()) {
                subBreeds.add(new Breed(subBreedName));
            }
            breed.setSubBreed(subBreeds);
        }
        return breed;
    }
}
