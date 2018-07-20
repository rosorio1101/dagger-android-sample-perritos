package cl.gdgandroidstgo.simple_dagger_application.listBreed;

import java.util.Collections;
import java.util.List;

public class Breed {
    private String name;
    private List<Breed> subBreed;
    private String randomImage;

    public Breed(String name) {
        this.name = name;
        subBreed = Collections.emptyList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Breed> getSubBreed() {
        return subBreed;
    }

    public void setSubBreed(List<Breed> subBreed) {
        this.subBreed = subBreed;
    }


    public String getRandomImage() {
        return randomImage;
    }

    public void setRandomImage(String randomImage) {
        this.randomImage = randomImage;
    }

}
