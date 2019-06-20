package com.phjethva.room_db_crud.db;
/**
 * @author PJET APPS (Pratik Jethva)
 * Check Out My Other Repositories On Github: https://github.com/phjethva
 * Visit My Website: https://www.pjetapps.com
 * Follow My Facebook Page: https://www.facebook.com/pjetapps
 */

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

    public LiveData<Integer> getTotalTaskCount() {
        return  databaseTask.daoTask().getTotalTaskCount();
    }

    public LiveData<List<ModelTask>> readAllTask() {
        LiveData<List<ModelTask>> tasks = databaseTask.daoTask().readAllTask();
        return tasks;
    }

    public LiveData<ModelTask> readTaskByID(int id) {
        LiveData<ModelTask> task = databaseTask.daoTask().readTaskByID(id);
        return task;
    }

    public void updateTask(final ModelTask task) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                databaseTask.daoTask().updateTask(task);
                return null;
            }
        }.execute();
    }

    public void deleteTask(final ModelTask task) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                databaseTask.daoTask().deleteTask(task);
                return null;
            }
        }.execute();
    }
}