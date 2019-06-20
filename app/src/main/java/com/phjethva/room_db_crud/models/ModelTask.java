package com.phjethva.room_db_crud.models;
/**
 * @author PJET APPS (Pratik Jethva)
 * Check Out My Other Repositories On Github: https://github.com/phjethva
 * Visit My Website: https://www.pjetapps.com
 * Follow My Facebook Page: https://www.facebook.com/pjetapps
 */

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class ModelTask implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String taskName;

    private String taskDateTime;

    public ModelTask() {
    }

    public ModelTask(String taskName, String taskDateTime) {
        this.taskName = taskName;
        this.taskDateTime = taskDateTime;
    }

    public ModelTask(int id, String taskName, String taskDateTime) {
        this.id = id;
        this.taskName = taskName;
        this.taskDateTime = taskDateTime;
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

    public String getTaskDateTime() {
        return taskDateTime;
    }

    public void setTaskDateTime(String taskDateTime) {
        this.taskDateTime = taskDateTime;
    }

}