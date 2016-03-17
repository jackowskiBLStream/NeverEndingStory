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
public class TaskPreviewFragment extends Fragment {
    private IServiceManager serviceManager;
    private TaskPreviewAdapter taskPreviewAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_preview_list_layout,container,false);
        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.allTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(taskPreviewAdapter);
        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serviceManager = new ServiceManager();
        taskPreviewAdapter = new TaskPreviewAdapter(serviceManager);

    }
    @Override
    public void onStart() {
        super.onStart();
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
      //  taskPreviewAdapter.updateIdLists(serviceManager.getAllTasksId());
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }


}
