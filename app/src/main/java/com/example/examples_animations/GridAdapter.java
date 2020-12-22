package com.example.examples_animations;

import android.animation.LayoutTransition;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GridAdapter extends RecyclerView.Adapter {
    List<Grid_Item> grid_listItems;
    Context context;
    ListItemClickListener mClickListener;
    ImageView clear;

    public GridAdapter(Context context, List<Grid_Item> grid_listItems, ListItemClickListener mClickListener ) {
        this.grid_listItems =grid_listItems;
        this.context=context;
        this.mClickListener=mClickListener;
    }

    public interface ListItemClickListener{
        void onListItemClick(int position,View v);
    }



    class CustomViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        View v;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.v=itemView;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos=getAdapterPosition();
            mClickListener.onListItemClick(pos,v);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.grid_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)  {
        View currentView = holder.itemView;
        Grid_Item currentItemAtPos = grid_listItems.get(position);

        ImageView imageview_item= currentView.findViewById(R.id.imageview_item);
        TextView textview_name= currentView.findViewById(R.id.textview_name);

        String url = currentItemAtPos.getThumbnailUrl();
        Picasso.with(imageview_item.getContext()).load(url).into(imageview_item);

        textview_name.setText( currentItemAtPos.getName());

        imageview_item.setTransitionName(currentItemAtPos.getPhotoUrl());
        textview_name.setTransitionName(currentItemAtPos.getName());

    }

    public void setData(List<Grid_Item> data) {
        grid_listItems.clear();
        grid_listItems.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return grid_listItems.size();
    }


}
