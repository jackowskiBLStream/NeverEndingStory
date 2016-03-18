package com.blstream.neverendingstory.Class;


import android.content.Context;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blstream.neverendingstory.BuildConfig;
import com.blstream.neverendingstory.ServiceManager.ServiceManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * Created by Krzysztof Antczak on 17.03.2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml")
public class TaskPreviewAdapterTest {
    ServiceManager manager;
    ArrayList<Integer> array;
    TextView textView;
    ProgressBar progressBar;
    ViewGroup viewGroup;
    Context context;
    @Before
    public void setup() {
        array = new ArrayList<>(6);
        array.add(0);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        manager = mock(ServiceManager.class);
        when(manager.getAllTasksId()).thenReturn(array);
        textView = mock(TextView.class);
        context = mock(Context.class);
        viewGroup = mock(ViewGroup.class);
        when(viewGroup.getContext()).thenReturn(context);
        textView = mock(TextView.class);
        progressBar = mock(ProgressBar.class);


    }

    @After
    public void setUpAfter() {
        array = null;
        manager = null;
    }

    @Test
    public void shouldCreateAdapterWithEmptyArray() {
        //given
        ServiceManager serviceManager = mock(ServiceManager.class);
        ArrayList<Integer> emptyList = new ArrayList<>();
        when(serviceManager.getAllTasksId()).thenReturn(new ArrayList<Integer>());
        //when
        TaskPreviewAdapter adapter = new TaskPreviewAdapter(serviceManager);
        //then
        assertArrayEquals(adapter.getListOfTasksInService().toArray(), emptyList.toArray());
    }

    @Test
    public void shouldReturnArrayOfIdList() throws Exception {
        //given
        //when
        TaskPreviewAdapter adapter = new TaskPreviewAdapter(manager);
        //then
        assertArrayEquals(adapter.getListOfTasksInService().toArray(), array.toArray());
    }

    @Test
    public void shouldAddArrayToAdapter_ReturnSizeFive() {
        //given
        TaskPreviewAdapter adapter = new TaskPreviewAdapter(manager);
        //when
        int count = adapter.getItemCount();
        //then
        assertEquals(5, count);
    }

    @Test
    public void shouldChangeArrayInAdapter() throws Exception {
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
        assertNotEquals(countBefeoreChange, countAfterChange);
    }
}