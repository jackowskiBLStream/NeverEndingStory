package com.blstream.neverendingstory.Class;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blstream.neverendingstory.Interfaces.IServiceManager;
import com.blstream.neverendingstory.Interfaces.ITask;
import com.blstream.neverendingstory.R;
import com.blstream.neverendingstory.ServiceManager.ServiceManager;

import java.util.List;

/**
 *
 * @author Krzysztof Antczak
 *
 */
public class TaskPreviewAdapter extends RecyclerView.Adapter<TaskPreviewAdapter.ViewHolder> {

    private IServiceManager manager;
    private final Context context;

    public TaskPreviewAdapter(Context context, IServiceManager mServiceManager){
        this.context = context;
        this.manager = mServiceManager;
    }



    @Override
    public TaskPreviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_element_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskPreviewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitle;
        public final ProgressBar progresBar;
//
        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitle = (TextView) view.findViewById(R.id.taskTitle);
            progresBar = (ProgressBar) view.findViewById(R.id.taskProgressBar);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitle.getText() + "'";
        }
    }
}
