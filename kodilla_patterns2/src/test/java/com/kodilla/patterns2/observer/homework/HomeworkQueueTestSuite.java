package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkQueueTestSuite {

    private HomeworkQueue pawel,adam, barbara, rafal, bartosz, malgorzata;
    private Mentor adrian, piotr, andrzej;

    @BeforeEach
    void setup() {
        pawel = new KodillaStudent("Pawel");
        adam = new KodillaStudent("Adam");
        barbara = new KodillaStudent("Barbara");
        rafal = new KodillaStudent("Rafał");
        bartosz = new KodillaStudent("Bartosz");
        malgorzata = new KodillaStudent("Małgorzata");
        adrian = new Mentor("Adrian", "Pażucha");
        piotr = new Mentor("Piotr", "Grosicki");
        andrzej = new Mentor("Andrzej", "Jaromin");
    }

    @Test
    void testHomeworkQueuePattern() {
        //Given
        pawel.registerObserver(adrian);
        adam.registerObserver(adrian);
        barbara.registerObserver(piotr);
        rafal.registerObserver(andrzej);
        bartosz.registerObserver(piotr);
        malgorzata.registerObserver(piotr);

        //When
        pawel.addHomework("Task 21.1");
        pawel.addHomework("Task 21.2");
        pawel.addHomework("Task 21.3");
        adam.addHomework("Task 7.5");
        adam.addHomework("Task 7.6");
        barbara.addHomework("Task 1.1");
        rafal.addHomework("Task 19.4");
        rafal.addHomework("Task 19.5");
        bartosz.addHomework("Task 27.5");
        malgorzata.addHomework("Task 28.1");
        malgorzata.addHomework("Task 28.2");
        malgorzata.addHomework("Task 28.3");

        //Then
        assertEquals(5, adrian.getHomeWorkCounter());
        assertEquals(2, andrzej.getHomeWorkCounter());
        assertEquals(5, piotr.getHomeWorkCounter());

    }
}