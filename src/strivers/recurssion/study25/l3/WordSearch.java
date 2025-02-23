package strivers.recurssion.study25.l3;

/**
 * @Auther : hasan.khan
 * @Created : 16-Feb-25
 * @Description : <a href="">link</a>
 */
public class WordSearch {

    public boolean exist1(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // check if word length is greater
        if (word.length() > m * n) return false;

        // iterating grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backTracking(board, word, i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean backTracking(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;

        // if out of bound OR cell does not match
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // temporally modified the grid to mark as considered
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all 4 directions (Up, Down, Left, Right)
        boolean found = backTracking(board, word, i + 1, j, index + 1) || // Down
                backTracking(board, word, i - 1, j, index + 1) || // Up
                backTracking(board, word, i, j + 1, index + 1) || // Right
                backTracking(board, word, i, j - 1, index + 1);   // Left

        // backtrack restore previous value
        board[i][j] = temp;
        return found;
    }

    public static void main(String[] args) {
        WordSearch s = new WordSearch();
        System.out.println("s = " + s.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println("s = " + s.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if( word.length() > m * n) return false;

        for(int i= 0 ; i < m ;  i++){
            for(int j= 0 ; i < n ; j++){
                if(back(board, word, i, j, 0 )) return true;
            }
        }

        return false;

    }


    public boolean back(char[][] board, String word, int i , int  j, int index){
        if(index == word.length()) return true;

        if(i< 0 || j <0 || i >= board.length || j >= board[0].length ||  board[i][j] != word.charAt(index) ) {return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = back(board, word, i-1, j, index+1 ) ||
                back(board, word, i+1, j, index+1 ) ||
                back(board, word, i, j-1, index+1 ) ||
                back(board, word, i, j+1, index+1 );


        board[i][j] = temp;
        return found;

    }
}
