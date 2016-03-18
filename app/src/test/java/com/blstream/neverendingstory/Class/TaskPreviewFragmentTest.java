package com.blstream.neverendingstory.Class;
import android.test.mock.MockContext;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import junit.framework.TestCase;
import junit.framework.TestResult;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 *
 * Created by Krzysztof Antczak on 18.03.2016.
 */
public class TaskPreviewFragmentTest extends TestCase {
    ViewGroup group;
    MockContext context;
    @Before
    public void setup(){
        context = new MockContext();
        group = mock(ViewGroup.class);
    }

    @Test
    public void testOnCreateTest(){
        //given
        TaskPreviewFragment fragmenent = new TaskPreviewFragment();
        //when
        View myView = fragmenent.onCreateView(LayoutInflater.from(context),group,null);
        //then
        assertNotNull(myView);
    }
}