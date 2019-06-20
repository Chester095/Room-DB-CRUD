package com.phjethva.room_db_crud.dao;
/**
 * @author PJET APPS (Pratik Jethva)
 * Check Out My Other Repositories On Github: https://github.com/phjethva
 * Visit My Website: https://www.pjetapps.com
 * Follow My Facebook Page: https://www.facebook.com/pjetapps
 */

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.phjethva.room_db_crud.models.ModelTask;

import java.util.List;

@Dao
public interface DaoTask {

    @Insert
    Long createTask(ModelTask model);

    @Query("SELECT * FROM ModelTask ORDER BY id asc")
    LiveData<List<ModelTask>> readAllTask();

    @Query("SELECT * FROM ModelTask WHERE id =:taskId")
    LiveData<ModelTask> readTaskByID(int taskId);

    @Query("SELECT COUNT(id) FROM ModelTask")
    LiveData<Integer> getTotalTaskCount();

    @Update
    void updateTask(ModelTask note);

    @Delete
    void deleteTask(ModelTask note);

}