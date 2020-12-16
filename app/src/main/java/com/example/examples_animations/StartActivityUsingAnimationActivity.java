package com.example.examples_animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StartActivityUsingAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_using_animation);
        setTitle(R.string.StartActivityUsingAnimation);
    }
}