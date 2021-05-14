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
        shoppingTask.executeTask();
        paintingTask.executeTask();
        drivingTask.executeTask();

        //Then
        assertEquals("Buy Food", shoppingTask.getTaskName());
        assertTrue(shoppingTask.isTaskExecuted());
        assertEquals("Paint Room", paintingTask.getTaskName());
        assertTrue(paintingTask.isTaskExecuted());
        assertEquals("Driving", drivingTask.getTaskName());
        assertTrue(drivingTask.isTaskExecuted());
    }
}
