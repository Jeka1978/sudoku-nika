package com.nika;

import com.nika.ui.SudokuFrame;
import com.nika.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class GameManager {

    public void createGame(GameLevel gameLevel) {
        Sudoku sudoku = new Sudoku(gameLevel.getNumberOfHiddenCells());
        sudoku.printSudoku();
        int[][] withAnswers = sudoku.getBoard();



        new SudokuFrame(withAnswers, sudoku.removeDigits(),new ScoreCalculator(gameLevel.getNumberOfHiddenCells()));
    }

}
