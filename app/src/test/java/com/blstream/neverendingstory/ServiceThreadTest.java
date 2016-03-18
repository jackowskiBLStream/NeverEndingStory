package com.blstream.neverendingstory;

import com.blstream.neverendingstory.ServiceManager.TimeHolder;
import com.blstream.neverendingstory.ServiceManager.ServiceThread;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ServiceThreadTest {
    @Test
    public void testShouldReturn500() {
        //given
        TimeHolder holder = new TimeHolder();
        ServiceThread thread = new  ServiceThread(500,holder);
        //when
        new Thread(thread).run();
        try {
            Thread.sleep(501);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //then
        assertEquals(500, holder.getElapsedTime());
    }
}