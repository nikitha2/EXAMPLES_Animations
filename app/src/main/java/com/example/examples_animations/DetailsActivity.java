package com.example.examples_animations;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    AnimationDrawable rocketAnimation;
    AnimatedVectorDrawable rocketVectorAnimation;
    ImageView animationVectorDrawableImage;
    boolean isChecked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        setTitle(getResources().getText(R.string.details));

        isChecked = true;
    }
    private void closeToCheck() {
        animationVectorDrawableImage.setImageResource(R.drawable.avd_check__to_close_animation);
        rocketVectorAnimation= (AnimatedVectorDrawable)animationVectorDrawableImage.getDrawable();
        rocketVectorAnimation.start();
    }

    private void checkToClose() {
        animationVectorDrawableImage.setImageResource(R.drawable.avd_cross_to_close_animation);
        rocketVectorAnimation= (AnimatedVectorDrawable)animationVectorDrawableImage.getDrawable();
        rocketVectorAnimation.start();
    }

    @Override
    protected void onStart() {
        super.onStart();

        //AnimationDrawable EXAMPLE
        ImageView rocketImage = (ImageView) findViewById(R.id.animationDrawableImage);
        rocketImage.setBackgroundResource(R.drawable.animation_drawable_example);
        rocketAnimation = (AnimationDrawable) rocketImage.getBackground();

        rocketImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rocketAnimation.start();
            }
        });

        animationVectorDrawableImage = (ImageView) findViewById(R.id.animationVectorDrawableImage);

        animationVectorDrawableImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isChecked)
                    checkToClose();
                else
                    closeToCheck();

                isChecked = !isChecked;

//                animationVectorDrawableImage.setImageResource(R.drawable.avd_check__to_close_animation);
//                rocketVectorAnimation= (AnimatedVectorDrawable)animationVectorDrawableImage.getDrawable();
//                animationVectorDrawableImage.setImageDrawable(rocketVectorAnimation);
//                rocketVectorAnimation.start();
            }
        });

    }
}