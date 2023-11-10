package matrix.easy;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 04-Nov-23
 * @Description : <a href="https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/">link</a>
 */
public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        int[][] temp = new int[mat.length][2];


        for (int row = 0; row < mat.length; row++) {
            int soldier = 0;
            for (int col = 0; col < mat[row].length; col++) {
                soldier += mat[row][col];
            }
            temp[row][0] = soldier;
            temp[row][1] = row;

            soldier = 0;
        }

        Arrays.sort(temp, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);


        for (int i = 0; i < k; i++) {

            res[i] = temp[i][1];
        }


        return res;
    }

    public static void main(String[] args) {

        int[][] mat1 =
                {{1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}};
        int k = 3;

        TheKWeakestRowsInAMatrix mat = new TheKWeakestRowsInAMatrix();
        System.out.println("mat = " + Arrays.toString(mat.kWeakestRows(mat1, k)));
    }


}
