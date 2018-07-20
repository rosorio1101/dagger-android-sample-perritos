package cl.gdgandroidstgo.simple_dagger_application.listBreed;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class BreedViewModel implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        @Override
        public Object createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public Object[] newArray(int size) {
            return new Object[0];
        }
    };

    private String name;
    private String randomImage;
    private List<String> subBreeds;

    public BreedViewModel(String name) {
        this.name = name;
    }

    protected BreedViewModel(Parcel in) {
        this.name = in.readString();
        this.randomImage = in.readString();
        this.subBreeds = new ArrayList<>();
        in.readStringList(subBreeds);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRandomImage() {
        return randomImage;
    }

    public void setRandomImage(String randomImage) {
        this.randomImage = randomImage;
    }

    public List<String> getSubBreeds() {
        return subBreeds;
    }

    public void setSubBreeds(List<String> subBreeds) {
        this.subBreeds = subBreeds;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.randomImage);
        dest.writeStringList(subBreeds);
    }
}
