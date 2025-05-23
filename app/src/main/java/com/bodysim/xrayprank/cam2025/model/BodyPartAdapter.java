package com.bodysim.xrayprank.cam2025.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bodysim.xrayprank.cam2025.databinding.ItemBodyPartBinding;
import com.bodysim.xrayprank.cam2025.spalsh.BodyPartDetailActivity;

import java.util.List;

public class BodyPartAdapter extends RecyclerView.Adapter<BodyPartAdapter.ViewHolder> {

    private final List<BodyPartModel> list;
    private int selectedPosition = -1;

    Context context;

    public BodyPartAdapter(List<BodyPartModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public BodyPartModel getSelectedItem() {
        return selectedPosition != -1 ? list.get(selectedPosition) : null;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBodyPartBinding binding = ItemBodyPartBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BodyPartModel model = list.get(position);
        holder.binding.imgIcon.setImageResource(model.getImageResId());
        holder.binding.txtName.setText(model.getTitle());


        holder.itemView.setOnClickListener(v -> {
            selectedPosition = position;
            Intent intent = new Intent(context, BodyPartDetailActivity.class);
            intent.putExtra("title", model.getTitle());
            intent.putExtra("image", model.getImageResId());
            intent.putExtra("description", model.getDescription());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemBodyPartBinding binding;

        public ViewHolder(ItemBodyPartBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}