package matrix.easy;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 30-Oct-23
 * @Description : <a href="https://leetcode.com/problems/row-with-maximum-ones/description/">link</a>
 */
public class RowWithMaximumOnes {

    public int[] rowAndMaximumOnes(int[][] mat) {
        int max = 0;
        int rowCount = 0;

        for (int row = 0; row < mat.length; row++) {
            int sum = 0;
            for (int col = 0; col < mat[row].length; col++) {
                sum += mat[row][col];
            }

            if (sum > max) {
                max = sum;
                rowCount = row;
            }


        }

        return new int[]{rowCount, max};
    }

    public static void main(String[] args) {
        // int[][] mat = {{0, 0, 0}, {0, 1, 1}};
        int[][] mat = {{0, 1}, {1, 0}};
        RowWithMaximumOnes rowWithMaximumOnes = new RowWithMaximumOnes();
        System.out.println("rowWithMaximumOnes = " + Arrays.toString(rowWithMaximumOnes.rowAndMaximumOnes(mat)));
    }
}
