package com.example.examples_animations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StartActivityUsingAnimationActivity extends AppCompatActivity implements GridAdapter.ListItemClickListener {
    List<Grid_Item> list;
    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_using_animation);
        setTitle(R.string.StartActivityUsingAnimation1);
        list=new ArrayList<>();
        context=this;
        // Setup the GridView and set the adapter
        RecyclerView grid = findViewById(R.id.sharedImageResourceFrom);
        grid.setLayoutManager(new GridLayoutManager(this,3));
        populateList();
        GridAdapter adapter = new GridAdapter(this, list,this);
        grid.setAdapter(adapter);
    }

    private void populateList() {
        list.add(new Grid_Item("Flying in the Light", "Romain Guy", "flying_in_the_light.jpg") );
        list.add(new Grid_Item("Caterpillar", "Romain Guy", "caterpillar.jpg") );
        list.add(new Grid_Item("Look Me in the Eye", "Romain Guy", "look_me_in_the_eye.jpg"));
        list.add(new Grid_Item("Flamingo", "Romain Guy", "flamingo.jpg") );
        list.add(new Grid_Item("Rainbow", "Romain Guy", "rainbow.jpg") );
        list.add(new Grid_Item("Over there", "Romain Guy", "over_there.jpg") );
        list.add(new Grid_Item("Jelly Fish 2", "Romain Guy", "jelly_fish_2.jpg") );
        list.add(new Grid_Item("Lone Pine Sunset", "Romain Guy", "lone_pine_sunset.jpg") );
    }


    @Override
    public void onListItemClick(int position,View v) {
        Intent intent = new Intent(StartActivityUsingAnimationActivity.this, StartActivityUsingAnimationActivity2.class);
        intent.putExtra(StartActivityUsingAnimationActivity2.EXTRA_PARAM_ID, list.get(position).getId());
        intent.putExtra(StartActivityUsingAnimationActivity2.EXTRA_PARAM, list.get(position));

        Pair<View, String> p1 = Pair.create(v.findViewById(R.id.imageview_item), list.get(position).getPhotoUrl());
        Pair<View, String> p2 = Pair.create(v.findViewById(R.id.textview_name), list.get(position).getName());

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(StartActivityUsingAnimationActivity.this, p1,p2);
//                // Now we provide a list of Pair items which contain the view we can transitioning
//                // from, and the name of the view it is transitioning to, in the launched activity
//                new Pair<>(findViewById(R.id.imageview_item),StartActivityUsingAnimationActivity2.VIEW_NAME_HEADER_IMAGE),
//                new Pair<>(findViewById(R.id.textview_name),StartActivityUsingAnimationActivity2.VIEW_NAME_HEADER_TITLE));
        //ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(this,findViewById(R.id.imageview_item),StartActivityUsingAnimationActivity2.VIEW_NAME_HEADER_IMAGE);
        startActivity( intent, options.toBundle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                supportFinishAfterTransition();
//                Activity.finishAfterTransition()
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}