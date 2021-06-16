package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype<SudokuBoard> {
    private List<SudokuRow> board = new ArrayList<>();
    private int size = 0;

    public SudokuBoard() {
        for(int i=0; i<9; i++) {
            SudokuRow sudokuRow = new SudokuRow();
            for (SudokuElement sudokuElement : sudokuRow.getElementsInRow()) {
                sudokuElement.setY(i);
                size++;
            }
            this.board.add(sudokuRow);
        }
        assingBoxes();
    }

    public List<SudokuRow> getBoard() {
        return board;
    }

    public void setBoard(List<SudokuRow> board) {
        this.board = board;
    }



    //Big brain time ... wymyśl coś sprytniejszego
    public void assingBoxes() {

        for( SudokuRow sudokuRow : board) {
            for( SudokuElement sudokuElement : sudokuRow.getElementsInRow() ) {
                if(sudokuElement.getX() <=2 && sudokuElement.getY() <=2) {
                    sudokuElement.setBoxNumber(1);
                } else if ( sudokuElement.getX() > 2 && sudokuElement.getX() <= 5 && sudokuElement.getY() <= 2) {
                    sudokuElement.setBoxNumber(2);
                } else if ( sudokuElement.getX() > 5 && sudokuElement.getX() <= 8 && sudokuElement.getY() <= 2) {
                    sudokuElement.setBoxNumber(3);
                } else if ( sudokuElement.getX() <=2 && sudokuElement.getY() > 2 && sudokuElement.getY() <= 5) {
                    sudokuElement.setBoxNumber(4);
                } else if ( sudokuElement.getX() > 2 && sudokuElement.getX() <= 5 &&
                        sudokuElement.getY() > 2 && sudokuElement.getY() <= 5) {
                    sudokuElement.setBoxNumber(5);
                } else if ( sudokuElement.getX() > 5 && sudokuElement.getX() <= 8 &&
                        sudokuElement.getY() > 2 && sudokuElement.getY() <= 5) {
                    sudokuElement.setBoxNumber(6);
                } else if ( sudokuElement.getX() <= 2 && sudokuElement.getY() > 5 && sudokuElement.getY() <= 8) {
                    sudokuElement.setBoxNumber(7);
                } else if ( sudokuElement.getX() > 2 && sudokuElement.getX() <= 5 &&
                        sudokuElement.getY() > 5 && sudokuElement.getY() <= 8) {
                    sudokuElement.setBoxNumber(8);
                }else if ( sudokuElement.getX() > 5 && sudokuElement.getX() <=8 &&
                        sudokuElement.getY() > 5 && sudokuElement.getY() <= 8) {
                    sudokuElement.setBoxNumber(9);
                }
            }
        }
    }

    public int getSize() {
        return size;
    }

    //Valid sudokuBoard for debugging purpuse only !! TO BE DELETED
    public void hardInitialize() {
        board.get(0).getElementsInRow().get(1).setValue(2);
        board.get(0).getElementsInRow().get(3).setValue(5);
        board.get(0).getElementsInRow().get(5).setValue(1);
        board.get(0).getElementsInRow().get(7).setValue(9);

        board.get(1).getElementsInRow().get(0).setValue(8);
        board.get(1).getElementsInRow().get(3).setValue(2);
        board.get(1).getElementsInRow().get(5).setValue(3);
        board.get(1).getElementsInRow().get(8).setValue(6);

        board.get(2).getElementsInRow().get(1).setValue(3);
        board.get(2).getElementsInRow().get(4).setValue(6);
        board.get(2).getElementsInRow().get(7).setValue(7);

        board.get(3).getElementsInRow().get(2).setValue(1);
        board.get(3).getElementsInRow().get(6).setValue(6);

        board.get(4).getElementsInRow().get(0).setValue(5);
        board.get(4).getElementsInRow().get(1).setValue(4);
        board.get(4).getElementsInRow().get(7).setValue(1);
        board.get(4).getElementsInRow().get(8).setValue(9);

        board.get(5).getElementsInRow().get(2).setValue(2);
        board.get(5).getElementsInRow().get(6).setValue(7);

        board.get(6).getElementsInRow().get(1).setValue(9);
        board.get(6).getElementsInRow().get(4).setValue(3);
        board.get(6).getElementsInRow().get(7).setValue(8);

        board.get(7).getElementsInRow().get(0).setValue(2);
        board.get(7).getElementsInRow().get(3).setValue(8);
        board.get(7).getElementsInRow().get(5).setValue(4);
        board.get(7).getElementsInRow().get(8).setValue(7);

        board.get(8).getElementsInRow().get(1).setValue(1);
        board.get(8).getElementsInRow().get(3).setValue(9);
        board.get(8).getElementsInRow().get(5).setValue(7);
        board.get(8).getElementsInRow().get(7).setValue(6);

        for(SudokuRow sudokuRow : board) {
            for (SudokuElement sudokuElement : sudokuRow.getElementsInRow()) {
                if(sudokuElement.getValue() != -1) {
                    sudokuElement.getPossibleValues().clear();
                }
            }
        }
    }

    public SudokuBoard deepCopy() {
        SudokuBoard clonedBoard = new SudokuBoard();
        try {
            clonedBoard = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        clonedBoard.setBoard(new ArrayList<>());

        for(SudokuRow sudokuRow : board) {
            SudokuRow clonedRow = new SudokuRow();
            clonedRow.getElementsInRow().clear();
            for(SudokuElement sudokuElement : sudokuRow.getElementsInRow()) {
                SudokuElement copiedElement = new SudokuElement();
                copiedElement.setValue(sudokuElement.getValue());
                copiedElement.setX(sudokuElement.getX());
                copiedElement.setY(sudokuElement.getY());
                copiedElement.setBoxNumber(sudokuElement.getBoxNumber());
                copiedElement.getPossibleValues().clear();
                for(Integer i : sudokuElement.getPossibleValues()) {
                    copiedElement.getPossibleValues().add(i);
                }
                clonedRow.getElementsInRow().add(copiedElement);
            }
            clonedBoard.getBoard().add(clonedRow);
        }
        return  clonedBoard;
    }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder();
        int counter = 1;
        for(SudokuRow sudokuRow : this.board) {
            if (counter == 3) {
                counter = 0;
                board.append(sudokuRow.toString()).append("\n\n");
            }else {
                board.append(sudokuRow.toString()).append("\n").append("-------    -------    -------\n");
            }
            counter++;
        }
        return board.toString();
    }
}
