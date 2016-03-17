package com.blstream.neverendingstory.ServiceManager;

/**
 * Created by Patryk Gwiazdowski
 * Runnable that will do background task and update service elapsed time
 */
public class ServiceThread implements Runnable {
    long duration;
    long elapsedTime;
    long updateInterval;

    public ServiceThread(long duration, long elapsedTime) {
        this.duration = duration;
        this.elapsedTime = elapsedTime;
    }

    /**
     * Starts executing the active part of the class' code. This method is
     * called when a thread is started that has been created with a class which
     * implements {@code Runnable}.
     */
    @Override
    public void run() {
        while (elapsedTime < duration) {
            try {
                Thread.sleep(updateInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elapsedTime += updateInterval;
        }
    }
}
