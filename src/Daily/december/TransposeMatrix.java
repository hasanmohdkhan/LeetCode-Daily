package Daily.december;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 10-Dec-23
 * @Description : <a href="https://leetcode.com/problems/transpose-matrix/description/?envType=daily-question&envId=2023-12-10">link</a>
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int[][] mat =  new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
              //  System.out.print(" " + matrix[i][j]);
                mat[j][i] = matrix[i][j];
            }
        //    System.out.println();
        }

        //System.out.println("mat = " + Arrays.deepToString(mat));

        return mat;
    }

    public static void main(String[] args) {
        TransposeMatrix o = new TransposeMatrix();

       int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("o = " + Arrays.deepToString(o.transpose(matrix)));
    }

}
