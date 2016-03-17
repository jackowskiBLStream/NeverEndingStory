package com.blstream.neverendingstory;

/**
 * ServiceManager interface containing very important methods
 */
public interface IServiceManager {
    /**
     *
     * @param taskId Id of task
     * @returns task's progress in percent. Returns 0 if is already waiting in queue
     */
    float getTaskProgress(int taskId);

    /**
     *
     * @param taskId Id of task
     * @returns task's title
     */
    String getTaskTitle(int taskId);

    /**
     * Add task to queue
     * @param task
     * @returns true if properly added, false if not
     */
    boolean addTask(ITask task);

    /**
     *
     * @returns taks's number being already executed
     */
    int getExecutedTasksNumber();

    /**
     *
     * @returns all tasks' number
     */
    int getAllTasksNumber();
}
