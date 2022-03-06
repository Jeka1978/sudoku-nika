package com.nika.ui;

import com.nika.ScoreCalculator;
import com.nika.Sudoku;

import javax.swing.*;
import java.awt.*;

/**
 * @author Evgeny Borisov
 */
public class SudokuFrame extends JFrame{

    private ScoreCalculator scoreCalculator;

    public SudokuFrame(int[][] sudokuAnswers,int[][] shownValues,ScoreCalculator scoreCalculator) throws HeadlessException {
        this.scoreCalculator=scoreCalculator;
        JPanel contentPane = new JPanel(new GridLayout(9, 9));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                SudokuCell sudokuCell = new SudokuCell(sudokuAnswers[i][j], shownValues[i][j],scoreCalculator);
                if (shownValues[i][j] != 0) {
                    sudokuCell.setEnabled(false);
                }
                contentPane.add(sudokuCell);
            }
        }
        setContentPane(contentPane);
        setSize(600,600);
        setVisible(true);
    }
}
