package Daily.december;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 14-Dec-23
 * @Description : <a href="https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/?envType=daily-question&envId=2023-12-14">link</a>
 */
public class DifferenceBetweenOnesAndZerosInRowAndColumn {


    public int[][] onesMinusZeros(int[][] mat) {
        int rowLen = mat.length;
        int colLen = mat[0].length;
        int[][] diff = new int[rowLen][colLen];

        int[] oneRow = new int[mat.length];
        int[] oneCol = new int[mat[0].length];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                oneCol[j]+=mat[i][j];
                oneRow[i]+=mat[i][j];

              //  diff[i][j]= oneRow[i] + oneCol[j] - (rowLen - oneRow[i]) - (colLen - oneCol[j]);
            }

       /*     System.out.println("oneRow = " + Arrays.toString(oneRow));
            System.out.println("oneCol = " + Arrays.toString(oneCol));*/


        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                diff[i][j]= oneRow[i] + oneCol[j] - (rowLen - oneRow[i]) - (colLen - oneCol[j]);
            }
        }


        return diff;
    }


    private static void getSum(int[][] mat, int row, int col, int[][] res) {
        int sumOne = 0;
        int sumZero = 0;
        int[] rowArr = mat[row];

        //  System.out.println("Row ------ ");
        for (int j : rowArr) {
            System.out.print(" " + j);
            if (j == 1) sumOne += j;
            else if (j == 0) sumZero++;
        }

       /* System.out.println("\nsumOne: " + sumOne);
        System.out.println("\nsumZero: " + sumZero);*/

       /* System.out.println("Col ------> " + mat[0].length);
        System.out.println("Col ------>* " + mat.length);*/

        for (int[] ints : mat) {
            System.out.print("col " + ints[col]);
            if (ints[col] == 1) sumOne += ints[col];
            else if (ints[col] == 0) sumZero++;
            // sumOne += mat[i][col];
        }
        int diff = sumOne - sumZero;
       /* System.out.println("diff = " + diff + " 1: " + sumOne + " 2: " + sumZero);

        System.out.println("sumOne: " + sumOne);
        System.out.println("sumZero: " + sumZero);*/

        res[row][col] = diff;

    }


    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1},
                {1, 0, 1},
                {0, 0, 1}};
        int[][] g = {{1,1,1},{1,1,1}};
        DifferenceBetweenOnesAndZerosInRowAndColumn result = new DifferenceBetweenOnesAndZerosInRowAndColumn();
        System.out.println("result = " + Arrays.deepToString(result.onesMinusZeros(grid)));
      //  System.out.println("result = " + Arrays.deepToString(result.onesMinusZeros(g)));
    }

}
