package cl.gdgandroidstgo.simple_dagger_application.listBreed;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cl.gdgandroidstgo.simple_dagger_application.R;
import cl.gdgandroidstgo.simple_dagger_application.commons.BaseViewHolder;

public class BreedWithSubBreedViewHolder extends BaseViewHolder<BreedViewModel> {

    @BindView(R.id.breed_name)
    TextView breedName;

    @BindView(R.id.subbreed_names)
    LinearLayout subBreedNames;

    public BreedWithSubBreedViewHolder(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_breed_with_sub_breed, viewGroup, false));
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(BreedViewModel data) {
        breedName.setText(data.getName());

        subBreedNames.removeAllViews();
        for (String subBreed : data.getSubBreeds()) {
            TextView subBreedName = new TextView(itemView.getContext());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                subBreedName.setTextAppearance(R.style.TextAppearance_AppCompat_Body1);
            } else {
                subBreedName.setTextAppearance(itemView.getContext(),
                        R.style.TextAppearance_AppCompat_Body1);
            }
            subBreedName.setText(String.format("- %s", subBreed));
            subBreedNames.addView(
                    subBreedName
            );
        }
    }
}
