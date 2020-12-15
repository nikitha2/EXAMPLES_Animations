package com.example.examples_animations.room_db;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class AutoAnimateTasksRepository {
    private static final String LOG_TAG = AutoAnimateTasksRepository.class.getSimpleName();
    private LiveData<List<AutoAnimateTaskEntry>> tasks;
    private AutoAnimateDAO taskDao;
    AppDatabase database;
    ExecutorService executor;
    public AutoAnimateTasksRepository(AppDatabase database) {
        this.database = database;
        executor = MyApplication.getInstance().executorService;
    }

    public LiveData<List<AutoAnimateTaskEntry>> getloadAllTasks() {
        tasks = database.autoAnimatetaskDao().loadAllTasks();
        return tasks;
    }

    public LiveData<AutoAnimateTaskEntry> getloadTaskById(int taskId) {
        return database.autoAnimatetaskDao().loadTaskById(taskId);
    }

    public void deleteTasks(AutoAnimateTaskEntry taskEntry) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
              database.autoAnimatetaskDao().deleteTask(taskEntry);
            }
        });
    }

    public void updateTaskById(AutoAnimateTaskEntry task) {
        database.autoAnimatetaskDao().updateTask(task);
    }

    public void insertTask(AutoAnimateTaskEntry task) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.autoAnimatetaskDao().insertTask(task);
            }
        });

    }

}
