package com.example.examples_animations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity implements GridAdapter.ListItemClickListener {
    GridAdapter gridAdapter;
    List<Grid_ListItem> listOfImageUrls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        RecyclerView gridView=findViewById(R.id.grid_details);
        gridView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        createList();
        gridView.setHasFixedSize(true);
        gridAdapter = new GridAdapter(this, listOfImageUrls, this);
        gridView.setAdapter(gridAdapter);


    }

    private void createList() {
        listOfImageUrls=new ArrayList<Grid_ListItem>();
        listOfImageUrls.add(new Grid_ListItem("https://www.lovethispic.com/uploaded_images/8340-Colorful-Scenery.jpg?2"));
        listOfImageUrls.add(new Grid_ListItem("https://www.encodedna.com/images/theme/angularjs.png"));
        listOfImageUrls.add(new Grid_ListItem("https://www.encodedna.com/images/theme/angularjs.png"));
        listOfImageUrls.add(new Grid_ListItem("https://www.encodedna.com/images/theme/angularjs.png"));
        listOfImageUrls.add(new Grid_ListItem("https://www.encodedna.com/images/theme/angularjs.png"));
        listOfImageUrls.add(new Grid_ListItem("https://www.lovethispic.com/uploaded_images/8340-Colorful-Scenery.jpg?2"));
        listOfImageUrls.add(new Grid_ListItem("https://www.encodedna.com/images/theme/angularjs.png"));
        listOfImageUrls.add(new Grid_ListItem("https://www.encodedna.com/images/theme/angularjs.png"));
        listOfImageUrls.add(new Grid_ListItem("https://www.encodedna.com/images/theme/angularjs.png"));
        listOfImageUrls.add(new Grid_ListItem("https://www.encodedna.com/images/theme/angularjs.png"));
        listOfImageUrls.add(new Grid_ListItem("https://www.lovethispic.com/uploaded_images/8340-Colorful-Scenery.jpg?2"));
        listOfImageUrls.add(new Grid_ListItem("https://www.encodedna.com/images/theme/angularjs.png"));
        listOfImageUrls.add(new Grid_ListItem("https://www.encodedna.com/images/theme/angularjs.png"));
        listOfImageUrls.add(new Grid_ListItem("https://www.encodedna.com/images/theme/angularjs.png"));
        listOfImageUrls.add(new Grid_ListItem("https://www.encodedna.com/images/theme/angularjs.png"));

    }

    @Override
    public void onListItemClick(int position) {
        Intent intent=new Intent(this,DetailsActivity.class);
        Bundle bundle= ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        startActivity(intent,bundle);
    }
}