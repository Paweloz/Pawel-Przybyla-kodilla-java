package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {
    private final UserMenu userMenu;

    public SudokuGame(UserMenu userMenu) {
        this.userMenu = userMenu;
        userMenu.displayMenu();
        userMenu.userInput(new SudokuBoard());
    }

    public boolean resolveSudoku() {
        SudokuBoard sudokuBoard = new SudokuBoard();

        return true;
    }
}
