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
     *
     * @param context
     * @return
     */
    long getElapsedTime(Context context);

    /**
     * Starts service
     * @return true if service was successfully bounded
     */
    boolean startService(Context context);



}
;