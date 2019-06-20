package com.phjethva.room_db_crud.db;
/**
 * @author PJET APPS (Pratik Jethva)
 * Check Out My Other Repositories On Github: https://github.com/phjethva
 * Visit My Website: https://www.pjetapps.com
 * Follow My Facebook Page: https://www.facebook.com/pjetapps
 */

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.phjethva.room_db_crud.dao.DaoTask;
import com.phjethva.room_db_crud.models.ModelTask;

@Database(entities = {ModelTask.class}, version = 1, exportSchema = false)
public abstract class DatabaseTask extends RoomDatabase {

    public abstract DaoTask daoTask();

}