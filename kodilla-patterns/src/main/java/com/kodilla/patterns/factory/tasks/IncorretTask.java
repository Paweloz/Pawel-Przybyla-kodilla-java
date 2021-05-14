package com.kodilla.patterns.factory.tasks;

public class IncorretTask implements Task {
    @Override
    public void executeTask() {

    }

    @Override
    public String getTaskName() {
        return "IncorretTask";
    }

    @Override
    public boolean isTaskExecuted() {
        return false;
    }
}
