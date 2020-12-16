package com.example.examples_animations;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.examples_animations.room_db.AutoAnimateAdapter;
import com.example.examples_animations.room_db.AutoAnimateTaskEntry;
import com.example.examples_animations.room_db.AutoAnimateViewModel;

import java.util.ArrayList;
import java.util.List;

public class AutoAnimateLayoutUpdatesActivity extends AppCompatActivity implements AutoAnimateAdapter.ListItemClickListener, AutoAnimateAdapter.ClearItemClickListener {
    private static final String TAG = AutoAnimateLayoutUpdatesActivity.class.getSimpleName();
    AutoAnimateViewModel viewModel;
    RecyclerView autoAnimateRecyclerView;
    AutoAnimateAdapter autoAnimateAdapter;
    TextView emptyText;
    TextView textForAnimation;

    //***Because this is a recycler view- the container of the listItems is autoAnimateListItem layout. So we animate autoAnimateListItem in adaptor view as we inflate it there.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_animate_layout_updates);
        ((ViewGroup) findViewById(R.id.container)).getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);  // to auto animate Textview item
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        autoAnimateRecyclerView=findViewById(R.id.autoAnimateRecyclerView);
        autoAnimateAdapter=new AutoAnimateAdapter(this,new ArrayList<AutoAnimateTaskEntry>() ,this,this);
        autoAnimateRecyclerView.setAdapter(autoAnimateAdapter);
        autoAnimateRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        setTitle(R.string.AutoAnimateLayoutUpdates);
        setUpViewModel();
        emptyText=findViewById(R.id.EmptyText);
        textForAnimation=findViewById(R.id.text);
        textForAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String displayedText= (String) textForAnimation.getText();

               if(displayedText.equalsIgnoreCase(getString(R.string.text))){
                   textForAnimation.setText(R.string.textForAnim);
               }else{
                   textForAnimation.setText(R.string.text);
               }
            }
        });
    }

    private void setUpViewModel() {
        viewModel = ViewModelProviders.of(this).get(AutoAnimateViewModel.class);
        viewModel.getTasks().observe(this, new Observer<List<AutoAnimateTaskEntry>>() {
            @Override
            public void onChanged(@Nullable List<AutoAnimateTaskEntry> taskEntries) {
                Log.d(TAG, "Updating list of tasks from LiveData in ViewModel");
                autoAnimateAdapter.setData(taskEntries);
                autoAnimateAdapter.notifyDataSetChanged(); //optional statement. will work the same without also

                if(taskEntries.isEmpty()){
                    emptyText.setVisibility(View.VISIBLE);
                }else{
                    emptyText.setVisibility(View.GONE);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.autoanimate_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int it = item.getItemId();
        switch(item.getItemId()){
            case R.id.plus:viewModel.insertTask(new AutoAnimateTaskEntry()); break;
            case 16908332:  finish(); //home
            //default:finish();
        }
        return true;
    }

    @Override
    public void onListItemClick(int position) {

    }

    @Override
    public void onClearItemClick(AutoAnimateTaskEntry taskEntry) {
        viewModel.deleteTask(taskEntry);
    }
}