package com.blstream.neverendingstory.Class;


import com.blstream.neverendingstory.ServiceManager.ServiceManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * Created by Krzysztof Antczak on 17.03.2016.
 */
public class TaskPreviewAdapterTest {
    ServiceManager manager;
    ArrayList<Integer> array;
    @Before
    public void setup()
    {
        array = new ArrayList<Integer>(6);
        array.add(0);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        manager = mock(ServiceManager.class);
        when(manager.getAllTasksId()).thenReturn(array);
    }
    @After
    public void setUpAfet(){
        array = null;
        manager = null;
    }

    @Test
    public void shouldReturnArrayOfIdList() throws Exception{
        //given
        TaskPreviewAdapter adapter = new TaskPreviewAdapter(manager);
        //when
        ArrayList<Integer> arrayReturned = manager.getAllTasksId();
        //then
        assertArrayEquals(arrayReturned.toArray(), array.toArray());
    }
    @Test
    public void shouldAddArrayToAddapter_SizeFive(){
        //given
        TaskPreviewAdapter adapter = new TaskPreviewAdapter(manager);
        //when
        int count = adapter.getItemCount();
        //then
        assertEquals(5,count);

    }
    @Test
    public void shouldChangeArrayInAdapter() throws Exception{
        //given //oldArray.size() = 5;
        TaskPreviewAdapter adapter = new TaskPreviewAdapter(manager);
        ArrayList<Integer> newArray = new ArrayList<>();
        newArray.add(1);
        newArray.add(2);
        newArray.add(3);
        ServiceManager newManager = mock(ServiceManager.class);
        when(newManager.getAllTasksId()).thenReturn(newArray);
        //when
        int countBefeoreChange = adapter.getItemCount();
        adapter.updateIdLists(newManager.getAllTasksId());
        int countAfterChange = adapter.getItemCount();
        //then
        assertNotEquals(countBefeoreChange,countAfterChange);
    }

    @Test
    public void should
}