package com.kodilla.testing.collection;
import java.util.*;

public class OddNumbersExterminator {

    //Przyjmuje liste liczb typu Integer i zwraca również listę Integer, ale z pominięciem liczb nieparzystych
    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> evenList = new LinkedList<>();

        if (numbers.isEmpty()) {
            evenList = null;
        } else {
            for (Integer number : numbers) {
                if (number % 2 == 0) {
                    evenList.add(number);
                }
            }
        }
        return evenList;
    }
}
