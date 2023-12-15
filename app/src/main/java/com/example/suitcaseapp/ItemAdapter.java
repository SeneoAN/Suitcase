package com.example.suitcaseapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> itemList;
    private ItemClickListener listener;

    public ItemAdapter(List<Item> itemList, ItemClickListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }

    public interface ItemClickListener {
        void onDeleteClick(int position);
        void onEditClick(int position);
        void onMarkAsPurchasedClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemNameTextView;
        public CheckBox isPurchasedCheckBox;
        public ImageView deleteImageView;
        public ImageView editImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.itemNameTextView);
            isPurchasedCheckBox = itemView.findViewById(R.id.isPurchasedCheckBox);
            deleteImageView = itemView.findViewById(R.id.deleteImageView);
            editImageView = itemView.findViewById(R.id.editImageView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item currentItem = itemList.get(position);

        holder.itemNameTextView.setText(currentItem.getItemName());
        holder.isPurchasedCheckBox.setChecked(currentItem.isPurchased());

        holder.deleteImageView.setOnClickListener(v -> listener.onDeleteClick(position));
        holder.editImageView.setOnClickListener(v -> listener.onEditClick(position));

        holder.isPurchasedCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            currentItem.setPurchased(isChecked);
            listener.onMarkAsPurchasedClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

