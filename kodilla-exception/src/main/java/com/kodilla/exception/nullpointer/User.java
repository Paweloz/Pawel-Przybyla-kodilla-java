package com.kodilla.exception.nullpointer;

public class User {

    private String name;
    private int age;
    private int some;
    private String someother;

    public User(String name, int age, int some, String someother) {
        this.name = name;
        this.age = age;
        this.some = some;
        this.someother = someother;
    }

    public String getName() {
        return name;
    }

}