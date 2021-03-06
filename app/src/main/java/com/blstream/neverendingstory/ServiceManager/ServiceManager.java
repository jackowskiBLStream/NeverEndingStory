package com.blstream.neverendingstory.ServiceManager;

import android.content.Context;

import com.blstream.neverendingstory.Class.TaskPreviewAdapter;
import com.blstream.neverendingstory.Class.TaskPreviewFragment;
import com.blstream.neverendingstory.Interfaces.IServiceManager;
import com.blstream.neverendingstory.Interfaces.IService;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Patryk Gwiazdowski on 17.03.2016. //good job :D
 * Service manager will manage all your services and execute then in order
 */
public class ServiceManager implements IServiceManager, Runnable {
    public static final int MAX_PARALLEL_TASKS_RUNNING = 4;
    private Context context;
    private ArrayList<Service> servicesQueue;
    private int executedCount;
    private TaskPreviewFragment taskPreviewFragment;


    public ServiceManager(Context context) {
        this.context = context;
        servicesQueue = new ArrayList<>();
    }

    /**
     * @param taskId Id of task
     * @return task's progress in percent. Returns 0 if is already waiting in queue
     */
    @Override
    public synchronized float getTaskProgress(int taskId) {
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
    public synchronized String getTaskTitle(int taskId) {
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
    public synchronized boolean addTask(IService task) {
        servicesQueue.add((Service) task);
        return true;
    }

    /**
     * @returns taks's number being already executed
     */
    @Override
    public synchronized int getExecutedTasksNumber() {
        return executedCount;
    }

    /**
     * @returns all tasks' number
     */
    @Override
    public synchronized int getAllTasksNumber() {
        return servicesQueue.size();
    }

    /**
     * @return all ids of task in queue;
     */
    @Override
    public synchronized ArrayList<Integer> getAllTasksId() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Service task : servicesQueue) {
            ids.add(task.getId());
        }
        return ids;
    }

    public synchronized void setTaskPreviewFragment(TaskPreviewFragment taskPreviewFragment) {
        this.taskPreviewFragment = taskPreviewFragment;
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
                if (executedCount < MAX_PARALLEL_TASKS_RUNNING && !task.isBound()) {
                    task.startService(context);
//                    taskPreviewFragment.returnAdapter().addItem(task.getId());
                    executedCount++;
                }
                System.out.println("task "+task.getId()+ " time: "+task.getElapsedTime(context));

            }
            removeFinished(servicesQueue);

//            taskPreviewFragment.returnAdapter().notifyDataSetChanged();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void removeFinished(ArrayList<Service> list){
        // uyzwamy iteratora nie for int i =0;
        for(Iterator<Service> iterator = list.iterator(); iterator.hasNext();) {
            Service s = iterator.next();
            //if
            // iterator.remove()
            //endif
        }

        for (int i = 0; i<list.size();i++) {
            if(list.get(i).isFinished()){
                System.out.println("task" + list.get(i).getId()+ " finished");
                list.remove(i);
                i--;
                executedCount--;
            }
        }
    }
    private synchronized Service findServiceById(int serviceId) {
        for (Service task : servicesQueue) {
            if (task.getId() == serviceId) {
                return task;
            }
        }
        return null;
    }
}
