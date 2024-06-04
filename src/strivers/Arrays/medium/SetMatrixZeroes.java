package strivers.Arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 29-Mar-24
 * @Description : <a href="">link</a>
 */
public class SetMatrixZeroes {

    public void setZeroesB(int[][] matrix) {

        int row = matrix.length;

        //  System.out.println("row = " + row);
        for (int i = 0; i < row; i++) {
            int col = matrix[i].length;
            //   System.out.println("col = " + col);
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) { // j
                    for (int r = 0; r < col; r++) if (matrix[i][r] != 0) matrix[i][r] = -1;
                    for (int k = 0; k < row; k++) if (matrix[k][j] != 0) matrix[k][j] = -1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) matrix[i][j] = 0;
            }
        }


    }


    public void setZeroes(int[][] matrix) {
        int n = matrix.length; // row matrix[...][0]
        int m = matrix[0].length; // col  matrix[0][...]

        int col0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    //mark i-th row
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        // leaving 0-th row and col
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0]==0){
            for (int i = 0; i < m; i++) matrix[0][i]=0;
        }

        if (col0==0){
            for (int i = 0; i < n; i++) matrix[i][0]=0;
        }

    }

    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix,
                                                           Integer n, Integer m) {

        boolean[] row= new boolean[n]; // row
        boolean[] col = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix.get(i).get(j)==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(row[i] || col[j]){
                    matrix.get(i).set(j,0);
                }
            }}



        return matrix;
    }


    public static void main(String[] args) {
        SetMatrixZeroes zero = new SetMatrixZeroes();
        int[][] a = {{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        int[][] b = {{0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };


        zero.setZeroes(b);
        zero.setZeroes(a);
        System.out.println("zero = " + Arrays.deepToString(b));
        System.out.println("zero = " + Arrays.deepToString(a));

      //  [[0, 0, 0, 0],
      //  [0, 4, 5, 0],
      //  [0, 3, 1, 0]]

      //  [[1, 0, 1],
      //  [0, 0, 0],
      //  [1, 0, 1]]

    }
}
