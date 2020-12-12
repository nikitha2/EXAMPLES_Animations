package com.example.examples_animations;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity   {
    ImagesListAdapter gridAdapter;
    List<Grid_ListItem> listOfImageUrls;

    Button drawbaleOrRevealHide;
    Button moveViewWithAnimation;
    Button moveViewWithFlingAnimation;
    Button enlargeViewWithZoomAnimation;
    Button animateMovementWithSpringAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RecyclerView gridView=findViewById(R.id.grid_details);
        moveViewWithAnimation =findViewById(R.id.MoveViewWithAnimation);
        drawbaleOrRevealHide=findViewById(R.id.drawbaleOrRevealHide);
        moveViewWithFlingAnimation=findViewById(R.id.moveViewWithFlingAnimation);
        enlargeViewWithZoomAnimation=findViewById(R.id.enlargeViewWithZoomAnimation);
        animateMovementWithSpringAnimation=findViewById(R.id.animateMovementWithSpringAnimation);
        /*gridView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        createList();
        gridView.setHasFixedSize(true);
        gridAdapter = new GridAdapter(this, listOfImageUrls, this);
        gridView.setAdapter(gridAdapter);*/


    }

    @Override
    protected void onStart() {
        super.onStart();

        drawbaleOrRevealHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), DrawableOrRevealHideActivity.class);
                Bundle bundle= ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext()).toBundle();
                startActivity(intent,bundle);
            }
        });

        moveViewWithAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), MoveViewWithAnimationActivity.class);
                Bundle bundle= ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext()).toBundle();
                startActivity(intent,bundle);
            }
        });

        moveViewWithFlingAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), MoveViewsUsingFlingAnimationActivity.class);
                Bundle bundle= ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext()).toBundle();
                startActivity(intent,bundle);
            }
        });

        enlargeViewWithZoomAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), EnlargeViewWithZoomAnimationActivity.class);
                Bundle bundle= ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext()).toBundle();
                startActivity(intent,bundle);
            }
        });

        animateMovementWithSpringAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), AnimateMovementWithSpringAnimationActivity.class);
                Bundle bundle= ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext()).toBundle();
                startActivity(intent,bundle);
            }
        });
    }



   /* @Override
    public void onListItemClick(int position) {
        Intent intent=new Intent(this, DetailsActivity_DrawableAnim_RevealOrHideAnim.class);
        Bundle bundle= ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        startActivity(intent,bundle);
    }*/
}