package com.example.examples_animations.room_db;

import android.animation.LayoutTransition;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examples_animations.Grid_ListItem;
import com.example.examples_animations.R;

import java.util.List;

public class AutoAnimateAdapter extends RecyclerView.Adapter {
    List<AutoAnimateTaskEntry> grid_listItems;
    Context context;
    ListItemClickListener mClickListener;
    ClearItemClickListener mClearItemClickListener;
    ImageView clear;
    public AutoAnimateAdapter(Context context, List<AutoAnimateTaskEntry> grid_listItems, ListItemClickListener mClickListener, ClearItemClickListener mClearItemClickListener) {
        this.grid_listItems =grid_listItems;
        this.context=context;
        this.mClickListener=mClickListener;
        this.mClearItemClickListener=mClearItemClickListener;
    }

    public interface ListItemClickListener{
        void onListItemClick(int position);
    }

    public interface ClearItemClickListener{
        void onClearItemClick(AutoAnimateTaskEntry taskEntry);
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
            mClickListener.onListItemClick(pos);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.autoanimate_listitems, parent, false);
        ((ViewGroup) view.findViewById(R.id.autoAnimateListItem)).getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);  // to auto animate exach item
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)  {
        View currentView = holder.itemView;
        AutoAnimateTaskEntry currentItemAtPos = grid_listItems.get(position);

        TextView priority= currentView.findViewById(R.id.priority);
        TextView description= currentView.findViewById(R.id.description);
        clear= currentView.findViewById(R.id.clear);

        priority.setText( Integer.toString(currentItemAtPos.getId()));
        description.setText(currentItemAtPos.getDescription()+ currentItemAtPos.getId());

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClearItemClickListener.onClearItemClick(currentItemAtPos);
            }
        });

    }

    public void setData(List<AutoAnimateTaskEntry> data) {
        grid_listItems.clear();
        grid_listItems.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return grid_listItems.size();
    }


}
