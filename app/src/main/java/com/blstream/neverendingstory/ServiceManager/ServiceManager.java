package com.blstream.neverendingstory.ServiceManager;

import android.content.Context;

import com.blstream.neverendingstory.Class.TaskPreviewAdapter;
import com.blstream.neverendingstory.Interfaces.IServiceManager;
import com.blstream.neverendingstory.Interfaces.IService;

import java.util.ArrayList;

/**
 * Created by Patryk Gwiazdowski on 17.03.2016.
 * Service manager will manage all your services and execute then in order
 */
public class ServiceManager implements IServiceManager, Runnable {
    private Context context;
    private ArrayList<Service> servicesQueue;
    private int executedCount;
    private TaskPreviewAdapter taskPreviewAdapter;


    public ServiceManager(Context context,TaskPreviewAdapter taskPreviewAdapter) {
        this.context = context;
        servicesQueue = new ArrayList<>();
        this.taskPreviewAdapter = taskPreviewAdapter;
    }

    /**
     * @param taskId Id of task
     * @returns task's progress in percent. Returns 0 if is already waiting in queue
     */
    @Override
    public float getTaskProgress(int taskId) {
        Service task = findServiceById(taskId);
        if (task != null) {
            return task.getElapsedTime(context);
        } else {
            return 0;
        }
    }

    /**
     * @param taskId Id of task
     * @returns task's title
     */
    @Override
    public String getTaskTitle(int taskId) {
        Service task = findServiceById(taskId);
        if (task != null) {
            return task.getName();
        } else {
            return "";
        }
    }

    /**
     * Add task to queue
     *
     * @param task
     * @returns true if properly added, false if not
     */
    @Override
    public boolean addTask(IService task) {
        servicesQueue.add((Service) task);
        return true;
    }

    /**
     * @returns taks's number being already executed
     */
    @Override
    public int getExecutedTasksNumber() {
        return executedCount;
    }

    /**
     * @returns all tasks' number
     */
    @Override
    public int getAllTasksNumber() {
        return servicesQueue.size();
    }

    /**
     * @return all ids of task in queue;
     */
    @Override
    public ArrayList<Integer> getAllTasksId() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Service task : servicesQueue) {
            ids.add(task.getId());
        }
        return ids;
    }

    /**
     * Starts executing the active part of the class' code. This method is
     * called when a thread is started that has been created with a class which
     * implements {@code Runnable}.
     */
    @Override
    public void run() {
        while (true) {
            for (Service task : servicesQueue) {
                if (executedCount < 4 && !task.isBound()) {
                    task.startService(context);
                    executedCount++;
                }

                if(task.isFinished()){
                    executedCount--;
                    servicesQueue.remove(task);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Service findServiceById(int serviceId) {
        for (Service task : servicesQueue) {
            if (task.getId() == serviceId) {
                return task;
            }
        }
        return null;
    }
}
