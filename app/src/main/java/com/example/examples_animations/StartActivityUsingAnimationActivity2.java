package com.example.examples_animations;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class StartActivityUsingAnimationActivity2 extends AppCompatActivity {
    public static final String EXTRA_PARAM = "details";
    public static final String EXTRA_PARAM_ID = "details_id";
    public static final String VIEW_NAME_HEADER_IMAGE = "detail:header:image";
    public static final String VIEW_NAME_HEADER_TITLE = "detail:header:title";
    ImageView mHeaderImageView;
    TextView mHeaderTitle;
    Grid_Item grid_item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_using_animation2);
        setTitle(R.string.StartActivityUsingAnimation2);
        mHeaderImageView = findViewById(R.id.sharedImageResourceTo);
        mHeaderTitle = findViewById(R.id.title);
        getWindow().setEnterTransition(null);
// added in xml so below lines not needed. if not defined in xml can define here
//        ViewCompat.setTransitionName(mHeaderImageView, VIEW_NAME_HEADER_IMAGE);
//        ViewCompat.setTransitionName(mHeaderTitle, VIEW_NAME_HEADER_TITLE);

        grid_item = (Grid_Item) getIntent().getSerializableExtra(EXTRA_PARAM);
        mHeaderTitle.setText(getString(R.string.image_header, grid_item.getName(), grid_item.getAuthor()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // If we're running on Lollipop and we have added a listener to the shared element
            // transition, load the thumbnail. The listener will load the full-size image when
            // the transition is complete.
            loadThumbnail();
        } else {
            // If all other cases we should just load the full-size image now
            loadFullSizeImage();
        }




    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                supportFinishAfterTransition();
//                Activity.finishAfterTransition()
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * Load the item's thumbnail image into our {@link ImageView}.
     */
    private void loadThumbnail() {
        Picasso.with(mHeaderImageView.getContext())
                .load(grid_item.getThumbnailUrl())
                .noFade()
                .into(mHeaderImageView);
    }

    /**
     * Load the item's full-size image into our {@link ImageView}.
     */
    private void loadFullSizeImage() {
        Picasso.with(mHeaderImageView.getContext())
                .load(grid_item.getPhotoUrl())
                .noFade()
                .noPlaceholder()
                .into(mHeaderImageView);
    }

}