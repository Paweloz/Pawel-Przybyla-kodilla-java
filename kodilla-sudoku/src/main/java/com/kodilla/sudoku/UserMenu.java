package com.kodilla.sudoku;

import java.util.Scanner;

public class UserMenu {
    private static final String SUDOKU = "SUDOKU";

    public void displayMenu() {

    }

    public void userInput(SudokuBoard sudokuBoard) {
        boolean done = false;
        int col = 0;
        int row = 0;
        int value = 0;

        System.out.println("Please enter value for Sudoku in format : col,row,value or " +
                "type 'SUDOKU' to finish input and start resolver");
        while (!done) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            int in = 0;

            if(input.equals(SUDOKU)) {
                done = true;
            }else {
                try {
                    col = Integer.parseInt(input.substring(0, 1));
                    row = Integer.parseInt(input.substring(2, 3));
                    value = Integer.parseInt(input.substring(4, 5));
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect input format");
                }
                sudokuBoard.getSudokuRows().get(col - 1).getElementsInRow().get(row - 1).setValue(value);
                System.out.println(sudokuBoard);
            }
        }

    }
}
