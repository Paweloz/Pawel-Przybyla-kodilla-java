package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> row = new ArrayList<>();
    private final int size;
    private int rowNumber;

    public SudokuRow(int size) {
        this.size = size;
        for(int i=0; i<size; i++) {
            SudokuElement sudokuElement = new SudokuElement(size);
            sudokuElement.setX(i);
            this.row.add(sudokuElement);
        }
    }

    public int getRowNumber() {
        return rowNumber;
    }
    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }
    public List<SudokuElement> getElementsInRow() {
        return row;
    }

    public String toString(int line) {
        String result = "";
        int counter = 0;
        for(SudokuElement sudokuElement : row) {
            if(counter == line) {
                counter = 0;
                result += "|    ";
            }
            result += sudokuElement.toString();
            counter++;
        }
        return result+"|";
    }
}
