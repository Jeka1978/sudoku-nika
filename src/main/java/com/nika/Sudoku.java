package com.nika;

/**
 * @author Evgeny Borisov
 */
public class Sudoku {
    int[][] board = new int[9][9];
    int numberOfMissingCells; // No. Of missing digits

    // Constructor
    public Sudoku(int numberOfMissingCells) {
        this.numberOfMissingCells = numberOfMissingCells;
        fillValues();
    }

    // Sudoku Generator
    public void fillValues() {
        // Fill the diagonal of SRN x SRN matrices
        fillDiagonal();

        // Fill remaining blocks
        fillRemaining(0, 3);

        // Remove Randomly K digits to make game
//        removeKDigits();
    }

    // Fill the diagonal SRN number of SRN x SRN matrices
    void fillDiagonal() {

        for (int i = 0; i < 9; i = i + 3)

            // for diagonal box, start coordinates->i==j
            fillBox(i, i);
    }

    // Returns false if given 3 x 3 block contains num.
    boolean unUsedInBox(int rowStart, int colStart, int num) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[rowStart + i][colStart + j] == num)
                    return false;

        return true;
    }

    // Fill a 3 x 3 matrix.
    void fillBox(int row, int col) {
        int num;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                do {
                    num = randomGenerator(9);
                }
                while (!unUsedInBox(row, col, num));

                board[row + i][col + j] = num;
            }
        }
    }

    // Random generator
    int randomGenerator(int num) {
        return (int) Math.floor((Math.random() * num + 1));
    }

    // Check if safe to put in cell
    boolean CheckIfSafe(int i, int j, int num) {
        return (unUsedInRow(i, num) &&
                unUsedInCol(j, num) &&
                unUsedInBox(i - i % 3, j - j % 3, num));
    }

    // check in the row for existence
    boolean unUsedInRow(int i, int num) {
        for (int j = 0; j < 9; j++)
            if (board[i][j] == num)
                return false;
        return true;
    }

    // check in the row for existence
    boolean unUsedInCol(int j, int num) {
        for (int i = 0; i < 9; i++)
            if (board[i][j] == num)
                return false;
        return true;
    }

    // A recursive function to fill remaining
    // matrix
    boolean fillRemaining(int i, int j) {
        //  System.out.println(i+" "+j);
        if (j >= 9 && i < 9 - 1) {
            i = i + 1;
            j = 0;
        }
        if (i >= 9 && j >= 9)
            return true;

        if (i < 3) {
            if (j < 3)
                j = 3;
        } else if (i < 9 - 3) {
            if (j == (i / 3) * 3)
                j = j + 3;
        } else {
            if (j == 9 - 3) {
                i = i + 1;
                j = 0;
                if (i >= 9)
                    return true;
            }
        }

        for (int num = 1; num <= 9; num++) {
            if (CheckIfSafe(i, j, num)) {
                board[i][j] = num;
                if (fillRemaining(i, j + 1))
                    return true;

                board[i][j] = 0;
            }
        }
        return false;
    }

    // Remove the K no. of digits to
    // complete game
    public int[][] removeDigits() {
        int[][] boardToShow = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boardToShow[i][j] = board[i][j];
            }
        }
        int count = numberOfMissingCells;
        while (count != 0) {
            int cellId = randomGenerator(9 * 9) - 1;

            // System.out.println(cellId);
            // extract coordinates i  and j
            int i = (cellId / 9);
            int j = cellId % 9;
            if (j != 0)
                j = j - 1;

            // System.out.println(i+" "+j);
            if (board[i][j] != 0) {
                count--;
                boardToShow[i][j] = 0;
            }
        }
        return boardToShow;
    }

    // Print sudoku
    public void printSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }


    public int[][] getBoard() {
        return board;
    }

    public int[][] getBoardWithEmptyCells() {
        removeDigits();
        return board;
    }


}
