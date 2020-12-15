package com.example.examples_animations.room_db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AutoAnimateDAO {

    @Query("SELECT * FROM AutoAnimate ORDER BY id")
    LiveData<List<AutoAnimateTaskEntry>> loadAllTasks();

    @Query("SELECT * FROM AutoAnimate WHERE id=:id")
    LiveData<AutoAnimateTaskEntry> loadTaskById(int id);

    @Insert
    void insertTask(AutoAnimateTaskEntry taskEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(AutoAnimateTaskEntry taskEntry);

    @Delete
    void deleteTask(AutoAnimateTaskEntry taskEntry);




}
