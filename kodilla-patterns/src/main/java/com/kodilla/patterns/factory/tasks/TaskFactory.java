package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String SHOPPINGTASK = "SHOPPING TASK";
    public static final String PAINTINGTASK = "PAINTING TASK";
    public static final String DRIVINGTASK = "DRIVING TASK";

    public Task createTask(final String task) {
        switch(task) {
            case SHOPPINGTASK:
                return new ShoppingTask("Buy Food", "Bread", 1);
            case PAINTINGTASK:
                return new PaintingTask("Paint Room", "White", "Room");
            case DRIVINGTASK:
                return new DrivingTask("Driving","Airport","Car");
            default:
                return null;
        }
    }
}
