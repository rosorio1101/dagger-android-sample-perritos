package cl.gdgandroidstgo.simple_dagger_application.listBreed;

import java.util.ArrayList;
import java.util.List;

import cl.gdgandroidstgo.simple_dagger_application.commons.mapper.BaseMapper;

public class BreedToViewModelMapper extends BaseMapper<Breed, BreedViewModel> {

    @Override
    public BreedViewModel map(Breed input) {
        BreedViewModel viewModel = new BreedViewModel(input.getName());
        viewModel.setRandomImage(input.getRandomImage());
        List<String> subBreeds = new ArrayList<>(input.getSubBreed().size());
        if (input.getSubBreed() != null && !input.getSubBreed().isEmpty()) {
            for (Breed subBreed : input.getSubBreed()) {
                subBreeds.add(subBreed.getName());
            }
        }
        viewModel.setSubBreeds(subBreeds);
        return viewModel;
    }
}
