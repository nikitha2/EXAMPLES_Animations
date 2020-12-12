package com.example.examples_animations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.PathInterpolator;
import android.widget.Button;

import com.google.android.material.imageview.ShapeableImageView;

public class MoveViewWithAnimationActivity extends AppCompatActivity {
    PathInterpolator pathInterpolator;
    int screenWidthDp;
    int screenHeightDp;
    Button  curverMotionBtn;
    Button  straightMotionBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moveviewwithanimation);

        setTitle(getResources().getText(R.string.MoveViewWithAnimation));
    }

    @Override
    protected void onStart() {
        super.onStart();

//Change the view position with ObjectAnimator
        ShapeableImageView view=findViewById(R.id.shapeableImageView);
        Configuration configuration = getResources().getConfiguration();
        screenWidthDp = configuration.screenWidthDp;//screen width
        straightMotionBtn=findViewById(R.id.straightMotionBtn);
        ViewGroup.LayoutParams origianlParams = view.getLayoutParams();
        straightMotionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animation = ObjectAnimator.ofFloat(view, "translationX", (float)screenWidthDp*2f);
                animation.setDuration(3000);
                animation.start();

                animation.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        view.animate().translationX(0).translationY(0);
                        view.animate().setDuration(3000);
                       // view.setLayoutParams(origianlParams);
                    }
                });
            }
        });


//Add curved motion : Use PathInterpolator
        ShapeableImageView view1=findViewById(R.id.ChangeViewPositionCurvedWithPathInterpolator_shapeableImageView);
        curverMotionBtn=findViewById(R.id.curverMotionBtn);
        screenHeightDp = configuration.screenHeightDp;//screen width

        curverMotionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // arcTo() and PathInterpolator only available on API 21+
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.arcTo((float)screenWidthDp/3, (float)screenHeightDp+200f, (float)screenWidthDp*2, (float)screenHeightDp*2.2f, 0f, -359f, true);
                    ObjectAnimator animator = ObjectAnimator.ofFloat(view1, View.X, View.Y, path);
                    animator.setDuration(3000);
                    animator.start();
                }else{

                }
            }
        });



    }
}