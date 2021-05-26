package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private List<SudokuRow> sudokuRows = new ArrayList<>();

    public SudokuBoard() {
        this.sudokuRows.add(new SudokuRow());
        this.sudokuRows.add(new SudokuRow());
        this.sudokuRows.add(new SudokuRow());
        this.sudokuRows.add(new SudokuRow());
        this.sudokuRows.add(new SudokuRow());
        this.sudokuRows.add(new SudokuRow());
        this.sudokuRows.add(new SudokuRow());
        this.sudokuRows.add(new SudokuRow());
        this.sudokuRows.add(new SudokuRow());
    }

    public List<SudokuRow> getSudokuRows() {
        return sudokuRows;
    }

    @Override
    public String toString() {
        String board ="";
        int counter = 1;
        for(SudokuRow sudokuRow : sudokuRows) {
            if (counter == 3) {
                counter = 0;
                board += sudokuRow.toString() + "\n\n";
            }else {
                board += sudokuRow.toString() + "\n" +"----------    ----------    ----------\n";
            }
            counter++;
        }
        return board;
    }
}
