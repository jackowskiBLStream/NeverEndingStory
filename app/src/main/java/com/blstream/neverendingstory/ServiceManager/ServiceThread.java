package com.blstream.neverendingstory.ServiceManager;

/**
 * Created by Patryk Gwiazdowski
 * Runnable that will do background task and update service elapsed time
 */
public class ServiceThread implements Runnable {
    long duration;
    static final long updateInterval = 50;
    TimeHolder timeHolder;

    public ServiceThread(long duration, TimeHolder timeHolder) {
        this.duration = duration;
        this.timeHolder = timeHolder;
    }

    /**
     * Starts executing the active part of the class' code. This method is
     * called when a thread is started that has been created with a class which
     * implements {@code Runnable}.
     */
    @Override
    public void run() {
        while (timeHolder.getElapsedTime() < duration) {
            try {
                Thread.sleep(updateInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeHolder.setElapsedTime(timeHolder.getElapsedTime()+updateInterval);
        }
    }

}
