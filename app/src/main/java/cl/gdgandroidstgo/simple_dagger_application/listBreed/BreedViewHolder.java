package cl.gdgandroidstgo.simple_dagger_application.listBreed;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import cl.gdgandroidstgo.simple_dagger_application.R;
import cl.gdgandroidstgo.simple_dagger_application.commons.BaseViewHolder;

public class BreedViewHolder extends BaseViewHolder<BreedViewModel> {

    @BindView(R.id.breed_name)
    TextView breedName;

    @BindView(R.id.breed_image)
    ImageView imageView;

    public BreedViewHolder(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_breed, viewGroup, false));
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(BreedViewModel data) {
        breedName.setText(data.getName());

        if (!data.getRandomImage().isEmpty()) {
            Picasso.get().load(data.getRandomImage()).into(imageView);
        }
    }
}
