package cl.gdgandroidstgo.simple_dagger_application.listBreed;

import android.support.annotation.IntDef;
import android.view.ViewGroup;

import cl.gdgandroidstgo.simple_dagger_application.commons.BaseViewHolder;
import dagger.MapKey;

public interface BreedViewHolderProvider {
    BaseViewHolder get(ViewGroup viewGroup);


    @MapKey
    @interface ProviderKey {
        @ViewHolderKey int value();
    }

    @IntDef({BreedsAdapter.VIEW_TYPE_ONLY_BREED, BreedsAdapter.VIEW_TYPE_BREED_WITH_SUB_BREED})
    @interface ViewHolderKey {

    }
}
