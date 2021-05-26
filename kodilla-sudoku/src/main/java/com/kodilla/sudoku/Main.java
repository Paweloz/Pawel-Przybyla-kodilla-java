package com.kodilla.sudoku;

public class Main {

    public static void main(String[] args) {
        boolean gameFinished = false;
        UserMenu userMenu = new UserMenu();
        while (!gameFinished) {
            SudokuGame theGame = new SudokuGame(userMenu);
            gameFinished = theGame.resolveSudoku();
        }
    }
}
