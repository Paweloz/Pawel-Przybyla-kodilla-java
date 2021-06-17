package com.kodilla.sudoku;

public class Main {

    public static void main(String[] args) {
        boolean gameFinished = false;
        UserMenu userMenu = new UserMenu();
        int size = userMenu.getBoardSize();
        SudokuBoard sudokuBoard = new SudokuBoard(size);
        while (!gameFinished) {
            SudokuGame theGame = new SudokuGame(userMenu, sudokuBoard);
            theGame.initalize();
            gameFinished = theGame.resolveSudoku();
        }
    }
}
