package com.phjethva.room_db_crud.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.phjethva.room_db_crud.dao.DaoTask;
import com.phjethva.room_db_crud.models.ModelTask;

@Database(entities = {ModelTask.class}, version = 2, exportSchema = false)
public abstract class DatabaseTask extends RoomDatabase {

    public abstract DaoTask daoTask();

}