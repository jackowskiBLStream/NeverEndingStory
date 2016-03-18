package com.blstream.neverendingstory.Class;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blstream.neverendingstory.Interfaces.IServiceManager;
import com.blstream.neverendingstory.R;
import com.blstream.neverendingstory.ServiceManager.ServiceManager;

/**
 * @author Krzysztof Antczak
 *
 */
public class TaskPreviewFragment extends Fragment implements OnTaskAdded {
    interface  OnTAskAdded {
        void OnAtaskadded(Task a);
        void onTaskFinished(Task a);
        void onTaskProgress(Task task);
    }
    class Task {
        String id;
        int progress;
    }
    private TaskPreviewAdapter taskPreviewAdapter;
    View view;

    public TaskPreviewFragment(){
        //FIXME:  do onCreate
        IServiceManager serviceManager = new ServiceManager(getContext());
        taskPreviewAdapter = new TaskPreviewAdapter(serviceManager);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.task_preview_list_layout, container, false);
        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.allTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(taskPreviewAdapter);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //bind to service
        bindedSErivce.addonATaskAddedListner(this);
    }

    onResume-> bind to service & add listerner
    onPause -> unbind and remove listenr

    public TaskPreviewAdapter returnAdapter(){
        return this.taskPreviewAdapter;
    }

    void onTaskAdded(Task t) {
        myTasksAdapter.updateTaskInfo(t);
    }
}
