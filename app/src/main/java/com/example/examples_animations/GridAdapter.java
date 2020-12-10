package com.example.examples_animations;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.jakewharton.picasso.OkHttp3Downloader;
        import com.squareup.picasso.Picasso;

        import java.util.List;

        import static com.example.examples_animations.NetworkUtils.buildImageURL;

public class GridAdapter extends RecyclerView.Adapter {
    List<Grid_ListItem> grid_listItems;
    Context context;
    ListItemClickListener mClickListener;

    public GridAdapter(Context context, List<Grid_ListItem> grid_listItems, ListItemClickListener mClickListener) {
        this.grid_listItems =grid_listItems;
        this.context=context;
        this.mClickListener=mClickListener;
    }

    interface ListItemClickListener{
        void onListItemClick(int position);
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
        View view = layoutInflater.inflate(R.layout.gridlistitems, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        View currentView = holder.itemView;
        Grid_ListItem currentItemAtPos = grid_listItems.get(position);

        ImageView imageView= currentView.findViewById(R.id.imageView);

        switch (position){
            case 1:imageView.setImageResource(R.drawable.scene1);break;
            case 2:imageView.setImageResource(R.drawable.scene2);break;
            case 3:imageView.setImageResource(R.drawable.scene3);break;
            case 4:imageView.setImageResource(R.drawable.scene4);break;
            case 5:imageView.setImageResource(R.drawable.scene1);break;
            case 6:imageView.setImageResource(R.drawable.scene2);break;
            case 7:imageView.setImageResource(R.drawable.scene3);break;
            case 8:imageView.setImageResource(R.drawable.scene4);break;
            case 9:imageView.setImageResource(R.drawable.scene1);break;
            case 10:imageView.setImageResource(R.drawable.scene2);break;
            case 11:imageView.setImageResource(R.drawable.scene3);break;
            case 12:imageView.setImageResource(R.drawable.scene4);break;
            case 13:imageView.setImageResource(R.drawable.scene1);break;
            default:imageView.setImageResource(R.drawable.scene5);break;
        }


    }

    public void setData(List<Grid_ListItem> data) {
        grid_listItems.clear();
        grid_listItems.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return grid_listItems.size();
    }


}
