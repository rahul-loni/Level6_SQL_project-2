package com.example.sqlite_project3.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite_project3.ItemsModel;
import com.example.sqlite_project3.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {
    private final RcyclerViewClickListener rcyclerViewClickListener;
    private final ArrayList<ItemsModel>itemsModels;
    public ItemsAdapter(ArrayList<ItemsModel> itemsModels,
                        RcyclerViewClickListener rcyclerViewClickListener){
        this.itemsModels=itemsModels;
        this.rcyclerViewClickListener=rcyclerViewClickListener;
    }

    @NonNull
    @Override
    public ItemsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.signle_item,parent,false);
        return new ItemViewHolder();
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ItemViewHolder holder, int position) {
        ItemsModel itemsModel=itemsModels.get(position);


    }

    @Override
    public int getItemCount() {
        return itemsModels.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView textName,textDescription;
        public  ItemViewHolder(View itemview){
            super(itemview);
            imageView=itemview.findViewById(R.id.item_img);
            textName=itemview.findViewById(R.id.item_name);
            textDescription=itemview.findViewById(R.id.itme_description);
            itemview.setOnClickListener(this::itemViewClick);
        }
        public void itemViewClick(View view){
            rcyclerViewClickListener.onItemClick(view,getAdapterPosition());
        }
    }
}
