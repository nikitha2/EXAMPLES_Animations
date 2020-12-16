package com.example.examples_animations;

import androidx.appcompat.app.AppCompatActivity;

import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.content.Context;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class AnimateLayoutChangesUsingTransitionActivity extends AppCompatActivity {
    Scene scene1;
    Scene scene2,scene3,scene4;
    Context context;
    ViewGroup sceneRoot;
    TransitionManager mTransitionManagerForScene;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate_layout_changes_using_transition);
        setTitle(R.string.AnimateLayoutChangesUsingTransition);
        context=this;
        // Create the scene root for the scenes in this app
        sceneRoot = (ViewGroup) findViewById(R.id.scene_root);
        scene1=Scene.getSceneForLayout(sceneRoot, R.layout.scene1, this);
        scene2=Scene.getSceneForLayout(sceneRoot, R.layout.scene2, this);
        scene3=Scene.getSceneForLayout(sceneRoot, R.layout.scene3, this);
        scene4=Scene.getSceneForLayout(sceneRoot, R.layout.scene4, this);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.select_scene);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.select_scene_1: {
                        Transition fadeTransition = new Fade();
                        TransitionManager.go(scene1, fadeTransition);
                        break;
                    }
                    case R.id.select_scene_2: {
                        mTransitionManagerForScene = TransitionInflater.from(context).inflateTransitionManager(R.transition.transition_manager, sceneRoot);
                        mTransitionManagerForScene.transitionTo(scene2);
                        break;
                    }
                    case R.id.select_scene_3: {
                        mTransitionManagerForScene = TransitionInflater.from(context).inflateTransitionManager(R.transition.transition_manager, sceneRoot);
                        mTransitionManagerForScene.transitionTo(scene3);
                        break;
                    }
                    case R.id.select_scene_4: {
                        Transition changeBoundsTransition = new ChangeBounds();
                        //Transition fadeTransition =TransitionInflater.from(context).inflateTransition(R.transition.fade_transition);
                        TransitionManager.go(scene4, changeBoundsTransition);
                        break;
                    }
                }
            }
        });
    }
}


/*
*  In activity Create scene for each layout-> Create  TransitionManager.xml connecting the scene with the transaction.xml
*                               -> In transaction.xml for the targeted id , apply the transaction property.
*
*  In activity inflate TransitionManager and place it in container:  mTransitionManagerForScene = TransitionInflater.from(context).inflateTransitionManager(R.transition.transition_manager, sceneRoot);
*                                     Then say which scene to goto:   mTransitionManagerForScene.transitionTo(scene3);
* */