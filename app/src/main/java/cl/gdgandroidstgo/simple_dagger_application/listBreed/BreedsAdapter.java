package cl.gdgandroidstgo.simple_dagger_application.listBreed;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import cl.gdgandroidstgo.simple_dagger_application.commons.BaseViewHolder;

public class BreedsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_ONLY_BREED = 1;
    public static final int VIEW_TYPE_BREED_WITH_SUB_BREED = 2;

    List<BreedViewModel> breeds;

    @Inject
    Map<Integer, BreedViewHolderProvider> providerMap;

    @Inject
    public BreedsAdapter() {
        breeds = Collections.emptyList();
    }

    public void setBreeds(List<BreedViewModel> breeds) {
        this.breeds = breeds;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return providerMap.get(viewType).get(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(breeds.get(position));
    }

    @Override
    public int getItemCount() {
        return breeds.size();
    }


    @Override
    public int getItemViewType(int position) {
        return breeds.get(position).getSubBreeds().isEmpty() ?
                VIEW_TYPE_ONLY_BREED : VIEW_TYPE_BREED_WITH_SUB_BREED;
    }
}
