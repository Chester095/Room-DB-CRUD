package com.phjethva.room_db_crud.models;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class ModelTask implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String taskName;

    public ModelTask() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

}