package cl.gdgandroidstgo.simple_dagger_application.listBreed;

import android.view.ViewGroup;

import cl.gdgandroidstgo.simple_dagger_application.commons.BaseViewHolder;

public interface BreedViewHolderProvider {
    BaseViewHolder get(ViewGroup viewGroup);
}
