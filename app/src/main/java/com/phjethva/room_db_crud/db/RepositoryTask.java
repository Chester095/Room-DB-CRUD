package com.phjethva.room_db_crud.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import com.phjethva.room_db_crud.models.ModelTask;

import java.util.List;

public class RepositoryTask {

    private static final String DATABASE_NAME = "my_task_db";

    private DatabaseTask databaseTask;

    public RepositoryTask(Context context) {
        databaseTask = Room.databaseBuilder(context, DatabaseTask.class, DATABASE_NAME).build();
    }

    public void createTask(final ModelTask model) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                databaseTask.daoTask().createTask(model);
                return null;
            }
        }.execute();
    }

    public LiveData<List<ModelTask>> readAllTask() {
        LiveData<List<ModelTask>> tasks = databaseTask.daoTask().readAllTask();
        return tasks;
    }
}