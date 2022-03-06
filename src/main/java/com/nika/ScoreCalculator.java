package com.nika;

import javax.swing.*;

/**
 * @author Evgeny Borisov
 */
public class ScoreCalculator {
    private int numberOfTries = 3;
    private int numberOfHiddenCells;
    private int numberOfHints = 2;

    public ScoreCalculator(int numberOfHiddenCells) {
        this.numberOfHiddenCells = numberOfHiddenCells;
    }

    public void decreaseNumberOfHints() {
        numberOfHints--;
    }

    public int getNumberOfHints() {
        return numberOfHints;
    }

    public void decreaseNumberOfTries() {
        JOptionPane.showMessageDialog(null, "Wrong");
        numberOfTries--;
        if (numberOfTries == 0) {
            JOptionPane.showMessageDialog(null, "GAME OVER, you are too stupid, try another level");
            System.exit(0);
        }
    }

    public void correctAnswer() {
        numberOfHiddenCells--;
        if (numberOfHiddenCells == 0) {
            allDone();
        }
    }


    public void allDone() {
        JOptionPane.showMessageDialog(null, "GAME OVER, you win");
        System.exit(0);
    }

}
