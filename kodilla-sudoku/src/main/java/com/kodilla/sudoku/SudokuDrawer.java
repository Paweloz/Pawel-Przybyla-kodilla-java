package com.kodilla.sudoku;

public class SudokuDrawer {

    private static SudokuDrawer sudokuDrawer;

    private SudokuDrawer(){}

    public String drawBoard(SudokuBoard sudokuBoard,int col, int row) {
        StringBuilder board = new StringBuilder();
        String spacer = drawSpacer(col, row);

        int counter = 1;
        for(SudokuRow sudokuRow : sudokuBoard.getBoard()) {
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

    public String drawRow(int line, SudokuRow row) {
        String result = "";
        int counter = 0;
        for(SudokuElement sudokuElement : row.getElementsInRow()) {
            if(counter == line) {
                counter = 0;
                result += "|    ";
            }
            result += sudokuElement.toString();
            counter++;
        }
        return result+"|";
    }

    public String drawElement(SudokuElement sudokuElement) {
        if(sudokuElement.getValue() == SudokuElement.EMPTY) {
            return "| - ";
        } else if(sudokuElement.getValue() >= 10) {
            return "|"+sudokuElement.getValue()+" ";
        }
        return "| "+sudokuElement.getValue()+" ";
    }

    private String drawSpacer(int col, int row) {
        StringBuilder spacer = new StringBuilder();
        String dash = "-";
        String space = "    ";
        String line = dash.repeat(row * 4 + 1);
        for(int n=0; n<col; n++) {
            spacer.append(line).append(space);
        }
        return spacer.toString();
    }

    public static SudokuDrawer getInstance() {
        if(sudokuDrawer == null) {
            return new SudokuDrawer();
        }
        return sudokuDrawer;
    }


}
