package com.kodilla.sudoku;

public class SudokuDto {
    private final SudokuBoard sudokuBoard;
    private final int x;
    private final int y;
    private final int value;

    public SudokuDto(SudokuBoard sudokuBoard, int x, int y, int value) {
        this.sudokuBoard = sudokuBoard;
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public int getValue() {
        return value;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
