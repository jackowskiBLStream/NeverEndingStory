package com.blstream.neverendingstory.ServiceManager;

import com.blstream.neverendingstory.Interfaces.IServiceManager;
import com.blstream.neverendingstory.Interfaces.ITask;

/**
 * Created by INV-6179 on 17.03.2016.
 */
public class ServiceManager implements IServiceManager {

    public ServiceManager(){

    }
    /**
     * @param taskId Id of task
     * @returns task's progress in percent. Returns 0 if is already waiting in queue
     */
    @Override
    public float getTaskProgress(int taskId) {
        return 0;
    }

    /**
     * @param taskId Id of task
     * @returns task's title
     */
    @Override
    public String getTaskTitle(int taskId) {
        return null;
    }

    /**
     * Add task to queue
     *
     * @param task
     * @returns true if properly added, false if not
     */
    @Override
    public boolean addTask(ITask task) {
        return false;
    }

    /**
     * @returns taks's number being already executed
     */
    @Override
    public int getExecutedTasksNumber() {
        return 0;
    }

    /**
     * @returns all tasks' number
     */
    @Override
    public int getAllTasksNumber() {
        return 0;
    }
}
