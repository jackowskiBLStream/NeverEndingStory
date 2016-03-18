package com.blstream.neverendingstory.Interfaces;

import android.content.Context;

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

    /**
     *  Returns task elapsed time.
     *  If task has started
     * @param context
     * @return task elapsed time.
     */
    long getElapsedTime(Context context);

    /**
     * Starts service
     * @return true if service was successfully bounded
     */
    boolean startService(Context context);



}
;