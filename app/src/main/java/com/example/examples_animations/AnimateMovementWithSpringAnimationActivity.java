package com.example.examples_animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AnimateMovementWithSpringAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate_movement_with_spring_animation);
        setTitle(getResources().getText(R.string.animateMovementWithSpringAnimation));
    }
}