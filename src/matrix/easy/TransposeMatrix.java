package matrix.easy;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 30-Oct-23
 * @Description : <a href="https://leetcode.com/problems/transpose-matrix/description/">link</a>
 */
public class TransposeMatrix {

    public int[][] transpose(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];

        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                int val = matrix[row][col];
                transpose[col][row] = val;
                ///System.out.print(" " + val);
            }
          //  System.out.println();
        }

       return transpose;
    }

    public static void main(String[] args) {
        int[][] mat ={{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat1 ={{1,2,3},{4,5,6}};
        TransposeMatrix matrix = new TransposeMatrix();
        System.out.println("matrix = " + Arrays.deepToString(matrix.transpose(mat)));
        System.out.println("matrix = " + Arrays.deepToString(matrix.transpose(mat1)));

    }
}
