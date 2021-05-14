package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testCreateTaskFactory() {
        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task shoppingTask = taskFactory.createTask(TaskFactory.SHOPPINGTASK);
        Task paintingTask = taskFactory.createTask(TaskFactory.PAINTINGTASK);
        Task drivingTask = taskFactory.createTask(TaskFactory.DRIVINGTASK);
        if (shoppingTask != null) {
            shoppingTask.executeTask();
        }
        if (paintingTask != null) {
            paintingTask.executeTask();
        }
        if (drivingTask != null) {
            drivingTask.executeTask();
        }

        //Then
        assertNotNull(shoppingTask);
        assertEquals("Buy Food", shoppingTask.getTaskName());
        assertTrue(shoppingTask.isTaskExecuted());
        assertNotNull(paintingTask);
        assertEquals("Paint Room", paintingTask.getTaskName());
        assertTrue(paintingTask.isTaskExecuted());
        assertNotNull(drivingTask);
        assertEquals("Driving", drivingTask.getTaskName());
        assertTrue(drivingTask.isTaskExecuted());
    }
}
