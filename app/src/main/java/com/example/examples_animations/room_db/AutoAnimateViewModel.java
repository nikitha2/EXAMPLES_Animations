package com.example.examples_animations.room_db;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AutoAnimateViewModel extends AndroidViewModel {
    // Constant for logging
    private static final String TAG = AutoAnimateViewModel.class.getSimpleName();

    private LiveData<List<AutoAnimateTaskEntry>> tasks;
    private final AutoAnimateTasksRepository tasksRepository;

    public AutoAnimateViewModel(Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks from the DataBase");
        //tasks = database.taskDao().loadAllTasks();
        tasksRepository = new AutoAnimateTasksRepository(database);
        tasks = tasksRepository.getloadAllTasks();
    }

    public LiveData<List<AutoAnimateTaskEntry>> getTasks() {
        return tasks;
    }

    public void deleteTask(AutoAnimateTaskEntry taskEntry) {
        tasksRepository.deleteTasks(taskEntry);
    }

    public void insertTask(AutoAnimateTaskEntry taskEntry) {
        tasksRepository.insertTask(taskEntry);
    }
}
