package com.blstream.neverendingstory;

/**
 *
 */
public interface ITask {
    int getId();

    String getName();

    int getInitialTime();

    int getElapsedTime();

    ISingleTaskService getService();



}
