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
    Button AutoAnimateLayoutUpdates;
    Button AnimateLayoutChangesUsingTransition;
    Button Createcustomtransitionanimation;
    Button StartActivityUsingAnimation;
    Button SlideBetweenFragmentsUsingViewPager;
    Button SlideBetweenFragmentsUsingViewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moveViewWithAnimation =findViewById(R.id.MoveViewWithAnimation);
        drawbaleOrRevealHide=findViewById(R.id.drawbaleOrRevealHide);
        moveViewWithFlingAnimation=findViewById(R.id.moveViewWithFlingAnimation);
        enlargeViewWithZoomAnimation=findViewById(R.id.enlargeViewWithZoomAnimation);
        animateMovementWithSpringAnimation=findViewById(R.id.animateMovementWithSpringAnimation);
        AutoAnimateLayoutUpdates=findViewById(R.id.AutoAnimateLayoutUpdates);
        AnimateLayoutChangesUsingTransition=findViewById(R.id.AnimateLayoutChangesUsingTransition);
        Createcustomtransitionanimation=findViewById(R.id.Createcustomtransitionanimation);
        StartActivityUsingAnimation=findViewById(R.id.StartActivityUsingAnimation);
        SlideBetweenFragmentsUsingViewPager=findViewById(R.id.StartActivityUsingAnimation);
        SlideBetweenFragmentsUsingViewPager2=findViewById(R.id.StartActivityUsingAnimation);

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

        AutoAnimateLayoutUpdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), AutoAnimateLayoutUpdatesActivity.class);
                Bundle bundle= ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext()).toBundle();
                startActivity(intent,bundle);
            }
        });

        AnimateLayoutChangesUsingTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), AnimateLayoutChangesUsingTransitionActivity.class);
                Bundle bundle= ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext()).toBundle();
                startActivity(intent,bundle);
            }
        });

        Createcustomtransitionanimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent=new Intent(v.getContext(), CreatecustomtransitionanimationActivity.class);
                Bundle bundle= ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext()).toBundle();
                startActivity(intent,bundle);*/
            }
        });

        StartActivityUsingAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), StartActivityUsingAnimationActivity.class);
                Bundle bundle= ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext()).toBundle();
                startActivity(intent,bundle);
            }
        });

        SlideBetweenFragmentsUsingViewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent=new Intent(v.getContext(), SlideBetweenFragmentsUsingViewPagerActivity.class);
                Bundle bundle= ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext()).toBundle();
                startActivity(intent,bundle);*/
            }
        });

        SlideBetweenFragmentsUsingViewPager2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent=new Intent(v.getContext(), SlideBetweenFragmentsUsingViewPager2Activity.class);
                Bundle bundle= ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext()).toBundle();
                startActivity(intent,bundle);*/
            }
        });
    }
}