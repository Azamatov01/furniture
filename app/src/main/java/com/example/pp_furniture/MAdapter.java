package com.example.pp_furniture;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pp_furniture.databinding.ItemFurnitureBinding;
import com.example.pp_furniture.models.FurnitureModel;

import java.util.ArrayList;
import java.util.List;

public class MAdapter extends RecyclerView.Adapter<MAdapter.ViewHolder> {
    ItemFurnitureBinding binding;
    List<FurnitureModel> list_m = new ArrayList<>();
    private ArrayList<FurnitureModel> selected_list = new ArrayList<>();
    NavController navController;

    public void setList_m(List<FurnitureModel> list_m) {
        this.list_m = list_m;
    }

    @NonNull
    @Override
    public MAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemFurnitureBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull MAdapter.ViewHolder holder, int position) {
        holder.onBind(list_m.get(position));

    }

    @Override
    public int getItemCount() {
        return list_m.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemFurnitureBinding binding;
        public ViewHolder(@NonNull ItemFurnitureBinding itemView) {
            super(itemView.getRoot());
            binding= itemView;
        }

        public void onBind(FurnitureModel furnitureModel) {
            binding.titleCard.setText(furnitureModel.getTitle());
            binding.priceCard.setText(furnitureModel.getPrice());
            binding.descriptionCard.setText(furnitureModel.getDescription());
            binding.imageCard.setImageResource(furnitureModel.getImageInt());

            binding.btnDone.setOnClickListener(view -> {

                selected_list.add(furnitureModel);

                navController = Navigation.findNavController((Activity)itemView.getContext(),
                        R.id.nav_host_fragment_activity_main);

                Bundle bundle = new Bundle();

                bundle.putParcelableArrayList("favorite", selected_list);

                navController.navigate(R.id.descriptionFragment, bundle);
            });

        }
    }
}
