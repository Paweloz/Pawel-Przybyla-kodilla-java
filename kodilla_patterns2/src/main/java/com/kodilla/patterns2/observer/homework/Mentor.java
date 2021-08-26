package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String name;
    private final String lastname;
    private int homeWorkCounter = 0;

    public Mentor(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public void update(HomeworkQueue homeworkQueue) {
        homeWorkCounter++;
        System.out.println(name +" "+ lastname + ": New homework to check for " + homeworkQueue.getName() + "\n" +
                " (total homeworks for this student : " + homeworkQueue.getHomeworkQueue().size() +")");
    }

    public int getHomeWorkCounter() {
        return homeWorkCounter;
    }
}
