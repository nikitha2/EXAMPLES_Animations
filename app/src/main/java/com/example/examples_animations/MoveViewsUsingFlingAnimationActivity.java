package com.example.examples_animations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import java.util.ArrayList;
import java.util.List;

public class MoveViewsUsingFlingAnimationActivity extends AppCompatActivity implements ImagesListAdapter.ListItemClickListener {
    RecyclerView listOfImages;
    List<Grid_ListItem> listOfImageUrls;
    Context mContext=this;
    float maxFlingVelocity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_views_using_fling_animation);

        setTitle(getResources().getText(R.string.MoveViewsUsingFlingAnimation));
    }

    @Override
    protected void onStart() {
        super.onStart();

        listOfImages=findViewById(R.id.MoveViewsUsingFlingAnimationView);
        listOfImages.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        createList();
        listOfImages.setHasFixedSize(true);
        ImagesListAdapter gridAdapter = new ImagesListAdapter(this, listOfImageUrls, this);
        listOfImages.setAdapter(gridAdapter);

        FlingAnimation fling = new FlingAnimation(listOfImages, DynamicAnimation.SCROLL_X);
        listOfImages.setOnFlingListener(new RecyclerView.OnFlingListener() {
            @Override
            public boolean onFling(int velocityX, int velocityY) {
                fling.setStartVelocity(-velocityX)
                        .setMinValue(0)
                        .setMaxValue(2000)
                        .setFriction(1.1f)
                        .start();
                if(velocityX!=0)
                    return true;
                return false;
            }
        });

       // GestureDetector.OnGestureListener(new)
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

    }
}