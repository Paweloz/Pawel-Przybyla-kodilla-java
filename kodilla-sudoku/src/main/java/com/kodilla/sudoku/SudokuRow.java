package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> elementsInRow = new ArrayList<>();

    public SudokuRow() {
        this.elementsInRow.add(new SudokuElement());
        this.elementsInRow.add(new SudokuElement());
        this.elementsInRow.add(new SudokuElement());
        this.elementsInRow.add(new SudokuElement());
        this.elementsInRow.add(new SudokuElement());
        this.elementsInRow.add(new SudokuElement());
        this.elementsInRow.add(new SudokuElement());
        this.elementsInRow.add(new SudokuElement());
        this.elementsInRow.add(new SudokuElement());
    }

    public List<SudokuElement> getElementsInRow() {
        return elementsInRow;
    }

    @Override
    public String toString() {
        String result = "";
        int counter = 0;
        for(SudokuElement sudokuElement : elementsInRow ) {
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
