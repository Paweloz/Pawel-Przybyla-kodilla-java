package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement{
    public static int EMPTY = -1;
    private int value;
    private List<Integer> possibleValues = new ArrayList<>();
    private int size;
    private int boxX;
    private int boxY;
    private int x;
    private int y;
    private int boxNumber;

    public SudokuElement(int size) {
        this.size = size;
        this.value = EMPTY;
        for(int i = 0; i<size; i++) {
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
            return "| - ";
        } else if(value >= 10) {
            return "|"+value+" ";
        }
        return "| "+value+" ";
    }

    public int getBoxX() {
        return boxX;
    }
    public void setBoxX(int boxX) {
        this.boxX = boxX;
    }
    public int getBoxY() {
        return boxY;
    }
    public void setBoxY(int boxY) {
        this.boxY = boxY;
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
