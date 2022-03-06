package com.nika;

/**
 * @author Evgeny Borisov
 */
public enum GameLevel {
    EASY(5),MEDIUM(25),HARD(35);


    private final int numberOfHiddenCells;

    GameLevel(int numberOfHiddenCells) {
        this.numberOfHiddenCells = numberOfHiddenCells;
    }

    public int getNumberOfHiddenCells() {
        return numberOfHiddenCells;
    }
}
