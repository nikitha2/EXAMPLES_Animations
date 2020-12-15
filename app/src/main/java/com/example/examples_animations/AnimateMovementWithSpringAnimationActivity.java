package com.example.examples_animations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.graphics.Point;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class AnimateMovementWithSpringAnimationActivity extends AppCompatActivity {
    private static final String TAG = AnimateMovementWithSpringAnimationActivity.class.getSimpleName();
    SpringAnimation animation;
    private float dX;  // x-position
    private float dY;  //y position
    VelocityTracker tracker;
    View img;
    DisplayMetrics displayMetrics = new DisplayMetrics();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate_movement_with_spring_animation);
        setTitle(getResources().getText(R.string.animateMovementWithSpringAnimation));
    }

    @Override
    protected void onStart() {
        super.onStart();
        img = findViewById(R.id.imageView_SpringAnim);
       // startSpringAnimation(img);
        tracker=VelocityTracker.obtain();

        // ACTION_DOWN - record the x and y positions in dX and dY and cancel any animations if already existing
        // ACTION_MOVE-  now to start moving the view we need to know by how much x and y positions are changing and move the view accordingly
        // ACTION_UP - when the user leaves the view- we need a way to position the view. In this case leaving the view where ver the user moved it to
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tracker.addMovement(event);
                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN:  //when we click on thr view
                        // capture the difference between view's top left corner and touch point
                        dX = v.getX() - event.getRawX();
                        dY = v.getY() - event.getRawY();
                        // cancel animations
                        if(animation!=null)
                            animation.cancel();
                        break;
                    case MotionEvent.ACTION_MOVE: // when we move the view- add or subtract x,y values from the one obtained when we clicked on the view dX,dY
                        //  a different approach would be to change the view's LayoutParams.
                        float dXplus= event.getRawX() + dX;  // x-position
                        float dYplus=event.getRawY() + dY;
                        img.animate()
                                .x(dXplus)
                                .y(dYplus)
                                .setDuration(0)
                                .start();
                        break;
                    case MotionEvent.ACTION_UP:
                        tracker.computeCurrentVelocity(1000);
                        float velocityX = tracker.getXVelocity();
                        float finalPosition;
                        finalPosition=dX+event.getRawX();
                        animation = new SpringAnimation(img, SpringAnimation.X,finalPosition).setStartVelocity(velocityX);
                        animation.start();
                        break;
                }
                return true;
            }
        });
    }


}