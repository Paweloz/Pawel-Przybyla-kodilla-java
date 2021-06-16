package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> row = new ArrayList<>();

    public SudokuRow() {
        for(int i=0; i<9; i++) {
            SudokuElement sudokuElement = new SudokuElement();
            sudokuElement.setX(i);
            this.row.add(sudokuElement);
        }
    }

    public List<SudokuElement> getElementsInRow() {
        return row;
    }

    @Override
    public String toString() {
        String result = "";
        int counter = 0;
        for(SudokuElement sudokuElement : row) {
            if(counter == 3) {
                counter = 0;
                result += "|    ";
            }
            result += sudokuElement.toString();
            counter++;
        }
        return result+"|";
    }
}
