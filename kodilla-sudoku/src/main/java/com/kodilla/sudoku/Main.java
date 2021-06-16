package com.kodilla.sudoku;

public class Main {

    public static void main(String[] args) {
        boolean gameFinished = false;
        UserMenu userMenu = new UserMenu();
        SudokuBoard sudokuBoard = new SudokuBoard();
        while (!gameFinished) {
            SudokuGame theGame = new SudokuGame(userMenu, sudokuBoard);
            theGame.initalize();
            gameFinished = theGame.resolveSudoku();
        }
    }
}
