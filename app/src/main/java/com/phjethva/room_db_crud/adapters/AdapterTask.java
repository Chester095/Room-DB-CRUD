package com.phjethva.room_db_crud.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.phjethva.room_db_crud.R;
import com.phjethva.room_db_crud.models.ModelTask;

import java.util.List;

public class AdapterTask extends RecyclerView.Adapter<AdapterTask.TaskViewHolder> {

    public ItemClick click;
    private List<ModelTask> tasks;

    public interface ItemClick {

    }

    public AdapterTask(ItemClick click, List<ModelTask> tasks) {
        this.click = click;
        this.tasks = tasks;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView taskName;

        public TaskViewHolder(View view) {
            super(view);
            taskName = view.findViewById(R.id.textview_task_name);
        }

    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        ModelTask task = tasks.get(position);
        holder.taskName.setText(task.getTaskName());
    }

    public void notifyData(List<ModelTask> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

}