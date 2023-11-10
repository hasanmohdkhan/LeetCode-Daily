package neet150.Arrayshashing;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther : hasan.khan
 * @Created : 14-Oct-23
 * @Description : <a href="https://leetcode.com/problems/valid-sudoku/description/">Link</a>
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = null;
        Set<Character> colSet = null;
        //check row and col in 9x9
        for (int row = 0; row < 9; row++) {
            rowSet = new HashSet<>();
            colSet = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                if (checkRowNCol(board, row, col, rowSet, colSet)) return false;

            }
        }

        // check row and col in 3x3

        for (int row3 = 0; row3 < 9; row3 += 3) {
            for (int col3 = 0; col3 < 9; col3 += 3) {
              //  System.out.println(" row " + row3 + " col3 = " + col3);
                if(!checkBlock(row3, col3, board)) return false;
            }

        }

        // passes all the tests then valid board
        return true;
    }

    private boolean checkRowNCol(char[][] board, int row, int col, Set<Character> rowSet, Set<Character> colSet) {
        char rowVal = board[row][col];
        char colVal = board[col][row];

        if (rowVal != '.') {
            if (rowSet.contains(rowVal)) {
                return true;
            } else {
                rowSet.add(rowVal);
            }
        }

        if (colVal != '.') {
            if (colSet.contains(colVal)) {
                return true;
            } else colSet.add(colVal);
        }
        return false;
    }

    /**
     * @param rowIndexStart start index
     * @param colIndexStart start index
     * @param board         matrix
     * @return
     */
    private boolean checkBlock(int rowIndexStart, int colIndexStart, char[][] board) {
        int rowLimit = rowIndexStart + 3;
        int colLimit = colIndexStart + 3;
        Set<Character> blockSet = new HashSet<>();

        for (int i = rowIndexStart; i < rowLimit; i++) {
            for (int j = colIndexStart; j < colLimit; j++) {
              //  System.out.print(" " + board[i][j]);

                if (board[i][j] == '.') continue;
                if (blockSet.contains(board[i][j])) return false;

                blockSet.add(board[i][j]);
            }
          //  System.out.println();
        }

       // System.out.println("__________");

        return true;
    }


    public static void main(String[] args) {
        char[][] arr =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        // a[0,0][0,1]..... a[row....0][col....n] for row
        // a[0,0][1,0]...... a[row..n][][col ...0] for col


        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println("isValidSudoku(arr) = " + validSudoku.isValidSudoku(arr));


    }
}
