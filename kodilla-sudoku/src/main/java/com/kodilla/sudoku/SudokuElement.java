package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SudokuElement{
    public static int EMPTY = -1;
    private int value;
    private List<Integer> possibleValues = new ArrayList<>();
    private int x;
    private int y;
    private int boxNumber;

    public SudokuElement() {
        this.value = EMPTY;
        for(int i = 0; i<9; i++) {
            possibleValues.add(i+1);
        }
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
            return "|-";
        }
        return "|"+value;
    }

    public int getBoxNumber() {
        return boxNumber;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setBoxNumber(int boxNumber) {
        this.boxNumber = boxNumber;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
