package com.kodilla.sudoku;

import java.util.Scanner;

public class UserMenu {
    private static final String SUDOKU = "SUDOKU";
    private SudokuValidator validator;
    private int size;

    public boolean playAgain() {
        boolean finished = true;
        boolean correct = false;
        System.out.println(" If You would like to play another sudoku press 'Y' if not press 'N'");
        while (!correct) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if(input.equals("Y") || input.equals("y")) {
                correct = true;
                finished = false;
            }else if(input.equals("N") || input.equals("n")) {
                correct = true;
                System.out.println("Thank you for playing");
            }else {
                System.out.println("Incorrect input. Try Again");
            }
        }
        return finished;
    }

    public int getBoardSize() {
         boolean correct = false;
         int size = 0;
         System.out.println("\nWelcome to Sudoku Solver\nPlease enter size of a board X by X");
         while(!correct) {
             Scanner scanner = new Scanner(System.in);
             String input = scanner.nextLine();
             try {
                size = Integer.parseInt(input);
                correct = true;
             } catch (NumberFormatException e) {
                 System.out.println("Incorrect format. Size has to be given as one number. Try again");
             }
             if(correct) {
                 validator = SudokuValidator.getInstance();
                 correct = validator.validateSize(size);
             }
         }
         this.size = size;
         return size;
    }

    public void userInput(SudokuBoard sudokuBoard) {
        boolean done = false;
        boolean correct;
        int col = 0;
        int row = 0;
        int value = 0;

        System.out.println( sudokuBoard + "\nPlease enter value for Sudoku" +
                " in format : col,row,value eg: '5,2,6' \n" +
                "Invalid delimiter will couse values to be recjected\n" +
                "Type 'SUDOKU' to finish input and start resolver");
        while (!done) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] splitted = input.split(",");

            if(input.equals(SUDOKU)) {
                done = true;
            }else {
                correct = validateQuantity(splitted);
                if(correct) {
                    try {
                        col = Integer.parseInt(splitted[0]);
                        row = Integer.parseInt(splitted[1]);
                        value = Integer.parseInt(splitted[2]);
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input format. Try again");
                    }
                    validateValues(sudokuBoard, col, row, value);
                }
                System.out.println(sudokuBoard);
            }
        }
    }

    private boolean validateQuantity(String[] splitted) {
        boolean correct = true;
        if(splitted.length > 3) {
            System.out.println("Incorrect input. Input has to contain only 3 values :" +
                    " col, row and value\nTry again");
            correct = false;
        }
        return correct;
    }

    private void validateValues(SudokuBoard sudokuBoard, int col, int row, int value) {
        if(col <= size && row <= size && value <= size &&
                col != 0 && row != 0 && value !=0) {
            sudokuBoard.getBoard().get(col - 1).getElementsInRow().get(row - 1).setValue(value);
            sudokuBoard.getBoard().get(col - 1).getElementsInRow().get(row - 1).getPossibleValues().clear();
        } else {
            System.out.println("Incorrect input. Values cannot be greater than board size.\nTry again");
        }
    }
}
