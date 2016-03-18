package com.blstream.neverendingstory.Class;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blstream.neverendingstory.Interfaces.IServiceManager;
import com.blstream.neverendingstory.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author Krzysztof Antczak
 */
public class TaskPreviewAdapter extends RecyclerView.Adapter<TaskPreviewAdapter.ViewHolder> {
    private ArrayList<Integer> listOfTasksInService;
    private IServiceManager manager;

    /**
     * Constructor of TaskPreviewAdapter.
     * @param mServiceManager instance of service Manager.
     */
    public TaskPreviewAdapter(IServiceManager mServiceManager) {
        this.manager = mServiceManager;
        this.listOfTasksInService = manager.getAllTasksId();
    }

    /**
     * Method used to update adapter;
     *
     * @param datas array of tasks Ids that have been added to queue;
     */
    public void updateIdLists(ArrayList<Integer> datas) {
        listOfTasksInService.clear();
        listOfTasksInService.addAll(datas);
    }
    public ArrayList<Integer> getListOfTasksInService(){
        return this.listOfTasksInService;
    }

    @Override
    public TaskPreviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_element_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskPreviewAdapter.ViewHolder holder, int position) {
        if (listOfTasksInService.size() != 0) {
            holder.mTitle.setText(manager.getTaskTitle(listOfTasksInService.get(position)));
            holder.progresBar.setProgress((int) manager.getTaskProgress(listOfTasksInService.get(position)));
        }
    }

    @Override
    public int getItemCount() {
        return listOfTasksInService.size();
    }

    /**
     * class of ViewHolder implementation.
     * Use to remember each element in list.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitle;
        public final ProgressBar progresBar;

        /**
         * Constructor where we set reference to layout of progressbar and TextView.
         *
         * @param view instance of view.
         */
        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitle = (TextView) view.findViewById(R.id.taskTitle);
            progresBar = (ProgressBar) view.findViewById(R.id.taskProgressBar);
        }

        /**
         * @return text as String from titleTextView.
         */
        @Override
        public String toString() {
            return super.toString() + " '" + mTitle.getText() + "'";
        }
    }
}
