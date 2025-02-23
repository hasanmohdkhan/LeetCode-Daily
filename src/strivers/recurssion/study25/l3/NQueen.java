package strivers.recurssion.study25.l3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 17-Feb-25
 * @Description : <a href="https://leetcode.com/submissions/detail/1547495448/">link</a>
 */
public class NQueen {
    public List<List<String>> solveNQueensBrute(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) board[i][j] = '.';

        dfs(0, board, res);

        return res;
    }

    private void dfs(int col, char[][] board, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }


        for (int row = 0; row < board.length; row++) {
            if (validate(row, col, board)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                board[row][col] = '.'; // backtracking
            }

        }

    }

    private boolean validate(int row, int col, char[][] board) {
        int dupRow = row;
        int dupCol = col;

        // Check upper diagonal left
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;

        // Check left side
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }
        row = dupRow;
        col = dupCol;

        // Check lower diagonal left
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();

        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }

        return res;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) board[i][j] = '.';

        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];


        dfs2(0, board, res, leftRow, upperDiagonal, lowerDiagonal);

        return res;
    }

    private void dfs2(int col, char[][] board, List<List<String>> res, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[col + row] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;

                dfs2(col + 1, board, res, leftRow, upperDiagonal, lowerDiagonal);
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;

                board[row][col] = '.';

            }


        }

    }


    public static void main(String[] args) {
        NQueen s = new NQueen();
        System.out.println("s = " + s.solveNQueens(4));
    }
}
