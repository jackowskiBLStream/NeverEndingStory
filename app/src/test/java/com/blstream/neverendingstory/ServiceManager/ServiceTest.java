package com.blstream.neverendingstory.ServiceManager;

import android.content.Context;
import android.content.Intent;
import android.test.mock.MockContext;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Patryk Gwiazdowski on 17.03.2016.
 * Some tests of Service class
 */
public class ServiceTest {

    @Test
    public void testStartNewServiceShouldReturn500(){
        //given
        Service testService;
        MockContext context;
        //when
        testService = new Service(1,500);
        context = new MockContext();

        //then
        testService.startService(context);


    }
}