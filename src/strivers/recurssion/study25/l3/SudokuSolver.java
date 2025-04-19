package strivers.recurssion.study25.l3;

/**
 * @Auther : hasan.khan
 * @Created : 24-Feb-25
 * @Description : <a href="">link</a>
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
          if(board[i][col] == c) return false;
          if(board[row][i] == c) return false;
          if(board[3 * (row/3) +i/3][3*(col/3)+i%3]== c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver s = new SudokuSolver();
        char[][] p = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        s.solveSudoku(p);

        printSudoku(p);

    }

    private static void printSudoku(char[][] p) {
        for (char[] chars : p) {
            for (int j = 0; j < p[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }
}
