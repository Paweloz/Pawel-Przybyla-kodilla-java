package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype<SudokuBoard> {
    private List<SudokuRow> board = new ArrayList<>();
    private int col = 0;
    private int row = 0;
    private final int size;
    private int quantity = 0;

    public SudokuBoard(int size) {
        this.size = size;
        for(int i=0; i<size; i++) {
            SudokuRow sudokuRow = new SudokuRow(size);
            sudokuRow.setRowNumber(i);
            for (SudokuElement sudokuElement : sudokuRow.getElementsInRow()) {
                sudokuElement.setY(i);
                quantity++;
            }
            this.board.add(sudokuRow);
        }
        buildBoard();
        assingBoxes();
    }

    public List<SudokuRow> getBoard() {
        return board;
    }

    public void setBoard(List<SudokuRow> board) {
        this.board = board;
    }

    public void assingBoxes() {
        assignBoxCoordinates();
        for (SudokuRow sudokuRow : board) {
            for (SudokuElement sudokuElement : sudokuRow.getElementsInRow()) {
                sudokuElement.setBoxNumber(sudokuElement.getBoxY() * col + sudokuElement.getBoxX());
            }
        }
    }

    private void assignBoxCoordinates() {
        int boxY = 0;
        for (SudokuRow sudokuRow : board) {
            int boxX = 0;
            if(sudokuRow.getRowNumber()%col == 0 && sudokuRow.getRowNumber() != 0) boxY++;
            for (SudokuElement sudokuElement : sudokuRow.getElementsInRow()) {
                if (sudokuElement.getX() % row != 0 || sudokuElement.getX() == 0) {
                    sudokuElement.setBoxX(boxX);
                    sudokuElement.setBoxY(boxY);
                } else {
                    boxX++;
                    sudokuElement.setBoxX(boxX);
                    sudokuElement.setBoxY(boxY);
                }
            }
        }
    }

    private void buildBoard() {
        List<Integer> divisiable = new ArrayList<>();

        for(int n=2; n<10; n++) {
            if(size%n == 0) {
                divisiable.add(n);
            }
        }
        int prev = divisiable.get(0);
        for(Integer num : divisiable) {
            if(num * num == size) {
                col = num;
                row = num;
                break;
            }else if( prev * num == size) {
                col = prev;
                row = num;
                break;
            }else {
                prev = num;
            }
        }
    }

    public int getSize() {
        return quantity;
    }

    public SudokuBoard deepCopy() {
        SudokuBoard clonedBoard = new SudokuBoard(size);
        try {
            clonedBoard = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        clonedBoard.setBoard(new ArrayList<>());

        for(SudokuRow sudokuRow : board) {
            SudokuRow clonedRow = new SudokuRow(size);
            clonedRow.getElementsInRow().clear();
            for(SudokuElement sudokuElement : sudokuRow.getElementsInRow()) {
                SudokuElement copiedElement = new SudokuElement(size);
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
        String spacer = drawSpacer();

        int counter = 1;
        for(SudokuRow sudokuRow : this.board) {
            if (counter == col) {
                counter = 0;
                board.append(sudokuRow.toString(row)).append("\n\n");
            }else {
                board.append(sudokuRow.toString(row)).append("\n").append(spacer).append("\n");
            }
            counter++;
        }
        return board.toString();
    }

    private String drawSpacer() {
        StringBuilder spacer = new StringBuilder();
        String dash = "-";
        String space = "    ";
        String line = dash.repeat(row * 4 + 1);
        for(int n=0; n<col; n++) {
            spacer.append(line).append(space);
        }
        return spacer.toString();
    }
}
