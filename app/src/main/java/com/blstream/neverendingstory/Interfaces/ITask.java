package com.blstream.neverendingstory.Interfaces;

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
