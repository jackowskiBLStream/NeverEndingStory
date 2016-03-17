package com.blstream.neverendingstory;

import com.blstream.neverendingstory.ServiceManager.ServiceThread;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ServiceThreadTest {
    @Test
    public void testShouldReturn500() {
        long elapsedTime=0;
        ServiceThread thread = new  ServiceThread(500);
        thread.run();
        assertEquals(500, thread.getElapsedTime());
    }
}