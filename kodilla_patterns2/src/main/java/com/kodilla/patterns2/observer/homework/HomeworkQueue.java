package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class HomeworkQueue implements Observable {
    private final List<Observer> observerList = new ArrayList<>();
    private final Deque<String> homeworkQueue = new ArrayDeque<>();
    private final String name;

    public HomeworkQueue(String name) {
        this.name = name;
    }

    public void addHomework(String homework) {
        homeworkQueue.push(homework);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observerList) {
            observer.update(this);
        }
    }

    public Deque<String> getHomeworkQueue() {
        return homeworkQueue;
    }

    public String getName() {
        return name;
    }
}
