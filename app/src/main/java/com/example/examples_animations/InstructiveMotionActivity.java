package com.example.examples_animations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;


//https://youtu.be/FTRpemXF3_8
public class InstructiveMotionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructive_motion);
        setTitle(getResources().getText(R.string.InstructiveMotion));
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        final int StartScrollPosition=getResources().getDimensionPixelOffset(R.dimen.init_scroll_up_distance);
        Animator animator= ObjectAnimator.ofInt(findViewById(R.id.mScrollView),"scrollY",StartScrollPosition).setDuration(300);
        animator.start();
    }
}