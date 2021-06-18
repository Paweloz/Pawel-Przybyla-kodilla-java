package com.kodilla.sudoku;

public class Main {

    public static void main(String[] args) {
        UserMenu userMenu = new UserMenu();
        boolean gameFinished = false;
        boolean sudokuFinished;

        while (!gameFinished) {
            int size = userMenu.getBoardSize();
            SudokuBoard sudokuBoard = new SudokuBoard(size);
            SudokuGame theGame = new SudokuGame(userMenu, sudokuBoard);
            theGame.initalize();
            sudokuFinished = theGame.resolveSudoku();
            if (sudokuFinished) {
                gameFinished = userMenu.playAgain();
            }
        }
    }
}
