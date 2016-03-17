package com.blstream.neverendingstory.Interfaces;

/**
 *
 */
public interface IService {
    int getId();

    String getName();

    /**
     *
     * @return
     */
    long getInitialTime();

    long getElapsedTime();

    ISingleTaskService getService();



}
