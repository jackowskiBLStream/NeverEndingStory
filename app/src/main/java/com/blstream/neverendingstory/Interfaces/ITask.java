package com.blstream.neverendingstory.Interfaces;

/**
 *
 */
public interface ITask {
    int getId();

    String getName();

    long getInitialTime();

    long getElapsedTime();

    ISingleTaskService getService();



}
