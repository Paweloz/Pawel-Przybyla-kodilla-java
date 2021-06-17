package com.kodilla.sudoku;

import java.util.Scanner;

public class UserMenu {
    private static final String SUDOKU = "SUDOKU";

    public void displayMenu() {

    }

    public int getBoardSize() {
         boolean correct = false;
         int size = 0;
         System.out.println("Welcome to Sudoku Solver\nPlease enter size of a board X by X");
         while(!correct) {
             Scanner scanner = new Scanner(System.in);
             String input = scanner.nextLine();
             try {
                size = Integer.parseInt(input);
             } catch (NumberFormatException e) {
                 System.out.println("Incorrect format. Size has to be given as one number. Try again");
             }
             correct = validateSize(size);
         }
         return size;
    }

    //To be moved to SudokuValidator
    private boolean validateSize(int size) {
        boolean correct;

        correct = isNotToBig(size);
        if(correct) {
            correct = canBeBuild(size);
        }
        return correct;
    }

    //To be moved to SudokuValidator
    private boolean canBeBuild(int size) {
        int counter = 0;
        boolean correct = false;
        for(int i = 1; i<10; i++) {
            if(size %i == 0) {
                counter++;
            }
        }
        if(counter > 2) {
            correct = true;
        } else {
            System.out.println("Incorrect size. Please enter size divisible by more than just itself");
        }
        return correct;
    }

    //To be moved to SudokuValidator
    private boolean isNotToBig(int size) {
        boolean correct = true;
        if(size > 25) {
            correct = false;
            System.out.println("Size cannot be bigger than 25. Try again");
        }
        return correct;
    }

    public void userInput(SudokuBoard sudokuBoard) {
        boolean done = false;
        boolean correct = false;
        int col = 0;
        int row = 0;
        int value = 0;

        System.out.println("Please enter value for Sudoku in format : col,row,value or " +
                "type 'SUDOKU' to finish input and start resolver");
        while (!done) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if(input.equals(SUDOKU)) {
                done = true;
            }else {
                try {
                    col = Integer.parseInt(input.substring(0, 1));
                    row = Integer.parseInt(input.substring(2, 3));
                    value = Integer.parseInt(input.substring(4, 5));
                    correct = true;
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect input format. Try again");
                }
                if(correct) {
                    sudokuBoard.getBoard().get(col - 1).getElementsInRow().get(row - 1).setValue(value);
                    sudokuBoard.getBoard().get(col - 1).getElementsInRow().get(row - 1).getPossibleValues().clear();
                }
                System.out.println(sudokuBoard);
            }
        }
    }
}
