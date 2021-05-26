package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    public static int EMPTY = -1;
    private int value;
    private List<Integer> possibleValues = new ArrayList<>();

    public SudokuElement() {
        this.value = EMPTY;
        possibleValues.add(1);
        possibleValues.add(2);
        possibleValues.add(3);
        possibleValues.add(4);
        possibleValues.add(5);
        possibleValues.add(6);
        possibleValues.add(7);
        possibleValues.add(8);
        possibleValues.add(9);
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    @Override
    public String toString() {
        if(value == EMPTY) {
            return "|  ";
        }
        return "|"+value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPossibleValues(List<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }
}
