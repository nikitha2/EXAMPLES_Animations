package com.example.examples_animations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class DrawableOrRevealHideActivity extends AppCompatActivity {
    AnimationDrawable rocketAnimation;
    AnimatedVectorDrawable rocketVectorAnimation;
    ImageView animationVectorDrawableImage;
    boolean isChecked;
    private View contentView;
    private View loadingView;
    private int shortAnimationDuration;
    Button crossfadeButton;
    boolean showingBack;
    FrameLayout card;
    Button revealButton;
    Button hideButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_revealhide);

        setTitle(getResources().getText(R.string.drawbaleOrRevealHide));
        isChecked = true;

// Card Flip Animation
        // set card front side as default
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.cardflip_fragment_contentainer, new CardFrontFragment())
                    .commit();

            showingBack=false;
        }
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

//AnimationVectorDrawable EXAMPLE
        animationVectorDrawableImage = (ImageView) findViewById(R.id.animationVectorDrawableImage);
        animationVectorDrawableImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isChecked)
                    checkToClose();
                else
                    closeToCheck();

                isChecked = !isChecked;
            }
        });

//CrossFade Animation Example
    //Step 1:set up the crossfade animation
        contentView = findViewById(R.id.content_crossfade);
        loadingView = findViewById(R.id.loading_spinner_crossfade);
        crossfadeButton = findViewById(R.id.crossfadeButton);
        // Initially hide the content view.
        contentView.setVisibility(View.GONE);
        // Retrieve and cache the system's default "short" animation time.
        shortAnimationDuration = getResources().getInteger(android.R.integer.config_shortAnimTime);
    //Step 2:Crossfade the views on click of a button - crossFade

        crossfadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the content view to 0% opacity but visible, so that it is visible
                // (but fully transparent) during the animation.
                contentView.setAlpha(0f);
                contentView.setVisibility(View.VISIBLE);

                // Animate the content view to 100% opacity, and clear any animation
                // listener set on the view.
                contentView.animate()
                        .alpha(1f)
                        .setDuration(shortAnimationDuration)
                        .setListener(null);

                // Animate the loading view to 0% opacity. After the animation ends,
                // set its visibility to GONE as an optimization step (it won't
                // participate in layout passes, etc.)
                loadingView.animate()
                        .alpha(0f)
                        .setDuration(shortAnimationDuration)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                loadingView.setVisibility(View.GONE);
                            }
                        });
            }
        });

// Card Flip Animation
        card= findViewById(R.id.cardflip_fragment_contentainer);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard();
            }
        });

//Circular reveal Animation
        revealButton = findViewById(R.id.RevealBtn);
        hideButton = findViewById(R.id.HideBtn);
        // previously invisible view
        View myView = findViewById(R.id.text_circularReveal_contentainer);
        revealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Check if the runtime version is at least Lollipop
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    // get the center for the clipping circle
                    int cx = myView.getWidth() / 2;
                    int cy = myView.getHeight() / 2;

                    // get the final radius for the clipping circle
                    float finalRadius = (float) Math.hypot(cx, cy);

                    // create the animator for this view (the start radius is zero)
                    Animator anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0f, finalRadius);

                    // make the view visible and start the animation
                    myView.setVisibility(View.VISIBLE);
                    anim.start();
                } else {
                    // set the view to invisible without a circular reveal animation below Lollipop
                    myView.setVisibility(View.INVISIBLE);
                }

            }
        });

        hideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    // get the center for the clipping circle
                    int cx = myView.getWidth() / 2;
                    int cy = myView.getHeight() / 2;

                    // get the initial radius for the clipping circle
                    float initialRadius = (float) Math.hypot(cx, cy);

                    // create the animation (the final radius is zero)
                    Animator anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0f);

                    // make the view invisible when the animation is done
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            myView.setVisibility(View.INVISIBLE);
                        }
                    });

                    // start the animation
                    anim.start();
                } else {
                    // set the view to visible without a circular reveal animation below Lollipop
                    myView.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    private void flipCard() {
        if (showingBack) {
            getSupportFragmentManager().popBackStack();
            showingBack = false;
            return;
        }

        // Flip to the back.
        showingBack = true;
        // Create and commit a new fragment transaction that adds the fragment for
        // the back of the card, uses custom animations, and is part of the fragment
        // manager's back stack.

        getSupportFragmentManager().beginTransaction()
                // Replace the default fragment animations with animator resources
                // representing rotations when switching to the back of the card, as
                // well as animator resources representing rotations when flipping
                // back to the front (e.g. when the system Back button is pressed).
                .setCustomAnimations(
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out)

                // Replace any fragments currently in the container view with a
                // fragment representing the next page (indicated by the
                // just-incremented currentPage variable).
                .replace(R.id.cardflip_fragment_contentainer, new CardBackFragment())

                // Add this transaction to the back stack, allowing users to press
                // Back to get to the front of the card.
                .addToBackStack(null)

                // Commit the transaction.
                .commit();
    }
}