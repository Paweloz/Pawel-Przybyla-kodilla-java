package com.kodilla.sudoku;

import java.util.*;

public class SudokuGame {
    private final UserMenu userMenu;
    private final SudokuBoard sudokuBoard;
    private SudokuValidator sudokuValidator;
    private boolean actionOccured = false;
    private boolean finished = false;
    private SudokuBoard workingBoard;
    private final Stack<SudokuDto> backTrack = new Stack<>();
    boolean isAvaliable = true;
    int elementsWithTheSamePossibleNumber = 0;

    public SudokuGame(UserMenu userMenu, SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
        this.userMenu = userMenu;
    }

    public void initalize() {
        userMenu.userInput(sudokuBoard);
    }

    public boolean resolveSudoku() {
        int filledElements = 0;
        finished = false;
        workingBoard = sudokuBoard.deepCopy();
        backTrack.push(new SudokuDto(sudokuBoard.deepCopy(), -1, -1, 0));
        sudokuValidator = SudokuValidator.getInstance();

        checkIncorrectValues();
        while (!finished) {
            if(filledElements == workingBoard.getSize()) {
                finished = true;
            } else  {
                filledElements = 0;
                for(SudokuRow sudokuRow : workingBoard.getBoard()) {
                    for(SudokuElement sudokuElement : sudokuRow.getElementsInRow() ) {
                        if(sudokuElement.getValue() == -1) {
                            HashSet<Integer> value = collectValues(sudokuRow, sudokuElement);
                            setValueToElement(sudokuElement, value);
                        }else {
                            filledElements++;
                        }
                    }
                }
                if(!actionOccured) {
                    backTrack.push(guessing());
                }
                actionOccured = false;
            }
        }
        System.out.println(workingBoard);
        return true;
    }

    private HashSet<Integer> collectValues(SudokuRow sudokuRow, SudokuElement sudokuElement) {
        HashSet<Integer> value = new HashSet<>();
        value.addAll(checkRow(sudokuElement, sudokuRow));
        value.addAll(checkColumn(sudokuElement));
        value.addAll(checkBox(sudokuElement));
        return value;
    }

    private void setValueToElement(SudokuElement sudokuElement, HashSet<Integer> value) {
        Object[] table = value.toArray();
        if(value.size() == 1) {
            int valueToSet = (int) table[0];
            sudokuElement.setValue(valueToSet);
            sudokuElement.getPossibleValues().clear();
            actionOccured = true;
        }
    }

    private void checkIncorrectValues() {
        if(!sudokuValidator.validateBoard(this, sudokuBoard)) {
            finished = true;
            System.out.println("Given sudoku is incorrect");
        }
    }

    public List<Integer> checkRow(SudokuElement sudokuElement, SudokuRow sudokuRow) {
        List<Integer> possibleValues = new ArrayList<>();
        List<Integer> takenValues = new ArrayList<>();

        for(Integer i : sudokuElement.getPossibleValues()) {
            for (SudokuElement element: sudokuRow.getElementsInRow()) {
                checkElement(sudokuElement, takenValues, i, element);
            }
            addPossibleValues(possibleValues, i);
        }
        removePossibleElements(sudokuElement, takenValues);
        return possibleValues;
    }

    public List<Integer> checkColumn(SudokuElement sudokuElement) {
        List<Integer> possibleValues = new ArrayList<>();
        List<Integer> takenValues = new ArrayList<>();

        for( Integer i : sudokuElement.getPossibleValues()) {
            for(SudokuRow sudokuRow : workingBoard.getBoard()) {
                int x = sudokuElement.getX();
                SudokuElement element = sudokuRow.getElementsInRow().get(x);
                checkElement(sudokuElement, takenValues, i, element);
            }
            addPossibleValues(possibleValues, i);
        }
        removePossibleElements(sudokuElement, takenValues);
        return possibleValues;
    }


    public List<Integer> checkBox(SudokuElement sudokuElement) {
        List<Integer> possibleValues = new ArrayList<>();
        List<Integer> takenValues = new ArrayList<>();
        List<SudokuElement> elementsInBox = selectBox(sudokuElement);

        for(Integer i : sudokuElement.getPossibleValues()) {
            for(SudokuElement element : elementsInBox) {
                checkElement(sudokuElement, takenValues, i, element);
            }
            addPossibleValues(possibleValues, i);
        }
        removePossibleElements(sudokuElement, takenValues);
        return possibleValues;
    }

    private void checkElement(SudokuElement sudokuElement,
                              List<Integer> takenValues,
                              Integer i,
                              SudokuElement element) {
        if (!element.equals(sudokuElement)) {
            if (element.getValue() == i) {
                isAvaliable = false;
                takenValues.add(i);
            } else if (element.getPossibleValues().contains(i) && element.getValue() == -1) {
                elementsWithTheSamePossibleNumber++;
            }
        }
    }

    private void addPossibleValues(List<Integer> possibleValues, Integer i) {
        if (elementsWithTheSamePossibleNumber == 0 && isAvaliable) {
            possibleValues.add(i);
        }
        isAvaliable = true;
        elementsWithTheSamePossibleNumber = 0;
    }

    public List<SudokuElement> selectBox(SudokuElement sudokuElement) {
        List<SudokuElement> elementsInBox = new ArrayList<>();
        for( SudokuRow sudokuRow : workingBoard.getBoard()) {
            for( SudokuElement elementToCheck : sudokuRow.getElementsInRow()) {
                if(sudokuElement.getBoxNumber() == elementToCheck.getBoxNumber()) {
                    elementsInBox.add(elementToCheck);
                }
            }
        }
        return elementsInBox;
    }

    public void removePossibleElements(SudokuElement sudokuElement, List<Integer> elementsToRemove) {
        for(Integer value : elementsToRemove) {
            sudokuElement.getPossibleValues().remove(value);
        }
        if (sudokuElement.getPossibleValues().isEmpty() && sudokuElement.getValue() == -1) {
            try {
                workingBoard = resumeBoard();
            } catch (InvalidSudokuException e) {
                System.out.println("Given sudoku is incorrect");
                finished = true;
            }
        }
    }

    public SudokuDto guessing() {
        int x = -1, y = -1;
        int gueesingNumber = 0;
        Random gen = new Random();
        SudokuBoard copiedBoard = workingBoard.deepCopy();

        outerloop :
        for(SudokuRow sudokuRow : workingBoard.getBoard()) {
            for(SudokuElement sudokuElement : sudokuRow.getElementsInRow()) {
                if(sudokuElement.getValue() == -1 && !sudokuElement.getPossibleValues().isEmpty()) {
                    x = sudokuElement.getX();
                    y = sudokuElement.getY();
                    int randomValue = gen.nextInt(sudokuElement.getPossibleValues().size());
                    gueesingNumber = sudokuElement.getPossibleValues().get(randomValue);
                    sudokuElement.setValue(gueesingNumber);
                    break outerloop;
                }
            }
        }
        return new SudokuDto(copiedBoard, x, y, gueesingNumber);
    }

    public SudokuBoard resumeBoard() throws InvalidSudokuException {
        SudokuDto clonedBoard;
        if(backTrack.empty()) {
            throw new InvalidSudokuException();
        } else {
           clonedBoard = backTrack.pop();
           workingBoard = clonedBoard.getSudokuBoard();
           removeGuessedNumberFromPossibleValues(clonedBoard);
        }
        return clonedBoard.getSudokuBoard();
    }

    private void removeGuessedNumberFromPossibleValues(SudokuDto clonedBoard) {
        outerloop :
        for(SudokuRow sudokuRow : workingBoard.getBoard()) {
            for(SudokuElement sudokuElement : sudokuRow.getElementsInRow()) {
                if(sudokuElement.getX() == clonedBoard.getX() &&
                sudokuElement.getY() == clonedBoard.getY() &&
                        clonedBoard.getValue() != 0 &&
                sudokuElement.getPossibleValues().contains(clonedBoard.getValue())) {
                    sudokuElement.getPossibleValues().remove((Object) clonedBoard.getValue());
                    break outerloop;
                }
            }
        }
    }
}
