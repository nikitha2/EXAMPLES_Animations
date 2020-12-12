package com.example.examples_animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EnlargeViewWithZoomAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlarge_view_with_zoom_animation);
        setTitle(getResources().getText(R.string.enlargeViewWithZoomAnimation));
    }
}