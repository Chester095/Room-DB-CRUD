package com.phjethva.room_db_crud.activities;

import android.app.Dialog;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.phjethva.room_db_crud.R;
import com.phjethva.room_db_crud.adapters.AdapterTask;
import com.phjethva.room_db_crud.db.RepositoryTask;
import com.phjethva.room_db_crud.models.ModelTask;

import java.util.ArrayList;
import java.util.List;

public class ActivityMain extends AppCompatActivity implements View.OnClickListener, AdapterTask.ItemClick {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private Button btnAddNewTsk;
    private List<ModelTask> tasks = new ArrayList<>();
    private AdapterTask adapterTask;
    private RecyclerView recyclerViewTask;

    RepositoryTask repositoryTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setView();
        setClickListen();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewTask.setLayoutManager(layoutManager);

        repositoryTask = new RepositoryTask(getApplicationContext());

        adapterTask = new AdapterTask(this, tasks);
        recyclerViewTask.setAdapter(adapterTask);

        readDataBase();

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_add_new_task) {
            dialogTaskAddNew(new ModelTask());
        }
    }

    private void setView() {
        btnAddNewTsk = findViewById(R.id.btn_add_new_task);
        recyclerViewTask = findViewById(R.id.recycle_view_task);
    }

    private void setClickListen() {
        btnAddNewTsk.setOnClickListener(this);
    }

    private void readDataBase() {
        tasks.clear();
        repositoryTask.readAllTask().observe(ActivityMain.this, new Observer<List<ModelTask>>() {
            @Override
            public void onChanged(List<ModelTask> models) {
                tasks = models;
                adapterTask.notifyData(tasks);
            }
        });
    }

    private void dialogTaskAddNew(final ModelTask task) {
        final Dialog dialog = new Dialog(this, R.style.DialogFullScreen);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.getWindow().setDimAmount(0.5f);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.BOTTOM;
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.dialog_task_add_new);

        final EditText etAddNewName = dialog.findViewById(R.id.et_add_new_name);
        Button btnAddNewClose = dialog.findViewById(R.id.btn_add_new_close);
        Button btnAddNewAdd = dialog.findViewById(R.id.btn_add_new_add);

        etAddNewName.setText("");
        btnAddNewAdd.setText(getString(R.string.add));


        btnAddNewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = etAddNewName.getText().toString().trim();
                ModelTask model = new ModelTask();
                //model.setId(id);
                model.setTaskName(message);
                repositoryTask.createTask(model);
                readDataBase();
                dialog.dismiss();
            }
        });

        btnAddNewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.getWindow().setDimAmount(0.5f);
        dialog.getWindow().setAttributes(lp);

    }

}