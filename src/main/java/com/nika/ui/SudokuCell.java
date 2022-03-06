package com.nika.ui;

import com.nika.ScoreCalculator;

import javax.swing.*;
import java.awt.*;

/**
 * @author Evgeny Borisov
 */
public class SudokuCell extends JTextField {
    private int correctValue;
    private int shownValue;

    public SudokuCell(int correctValue, int shownValue, ScoreCalculator scoreCalculator) {
        super(Integer.toString(shownValue));
        setFont(new Font("Dialog", Font.BOLD, 24));
        setHorizontalAlignment(CENTER);
        setToolTipText(String.valueOf(correctValue));

        this.correctValue = correctValue;
        this.shownValue = shownValue;
        addActionListener(e -> {
            String userChoice = e.getActionCommand();
            if (userChoice.trim().equalsIgnoreCase("h")) {
                if (scoreCalculator.getNumberOfHints() > 0) {
                    scoreCalculator.decreaseNumberOfHints();
                    scoreCalculator.correctAnswer();
                    setEnabled(false);
                    System.out.println(correctValue);
                    setText(String.valueOf(correctValue));
                    repaint();
                }
                return;
            }
            int userNumber = Integer.parseInt(userChoice);
            if (userNumber != correctValue) {
                scoreCalculator.decreaseNumberOfTries();
            } else {
                scoreCalculator.correctAnswer();
                setEnabled(false);
            }
        });
    }


}
