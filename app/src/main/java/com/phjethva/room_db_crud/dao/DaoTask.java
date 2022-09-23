package com.phjethva.room_db_crud.dao;
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
}