package com.blstream.neverendingstory.Interfaces;

import java.util.ArrayList;

/**
 * Created by Patryk Gwiazdowski
 */
public interface ITaskProgressProvider {

    /**
     *
     * @return task elapsed time in milis
     */
    long getProgress(int Id);

    /**
     *
     * @return ids of all tasks in queue
     */
    ArrayList<Integer> getAllTasksIds();


}
