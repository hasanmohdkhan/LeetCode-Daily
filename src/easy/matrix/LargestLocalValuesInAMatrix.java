package easy.matrix;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 06-Oct-23
 * @Description: <a href="https://leetcode.com/problems/largest-local-values-in-a-matrix/description/">link</a>
 */
/*
[[9,9,8,1],
 [5,6,2,6],
 [8,2,6,4],
 [6,2,2,2]]


 so in that, we need to see only 3 * 3 at one time.

  9 9 8 = 3
  5 6 2
  8 2 6  = 3
  its 3*3 ok so. in that. 9 is big.

  now col +1;
  9 8 1 = 3
  6 2 6
  2 6 4 = 3.
  its also 3 * 3 in that 9 is max.

  now row + 1;
   5 6 2
   8 2 6
   6 2 2
   in that 8 is max.
   now col +1;
   6 2 6
   2 6 4
   2 2 2
   so in that 6 is max.

   so now u can see. matrix is n-2 length was 4 , its 2 length;
   9 9
   8 6.

 */
public class LargestLocalValuesInAMatrix {

    public int[][] largestLocal(int[][] grid) {
        int length = grid.length ;
        int[][] maxLocal = new int[length-2][length-2];

        for (int i = 0; i < length - 2; i++) {
            for (int j = 0; j < length - 2; j++) {
                maxLocal[i][j] =  findMax(grid, i, j);
            }
        }
        return maxLocal;

    }

    private int findMax(int[][] grid, int iStart, int jStart) {
        int max = Integer.MIN_VALUE;
       // System.out.println(iStart + "_________FIND MAX________" + jStart);

        for (int i = iStart; i < iStart + 3; i++) {
            for (int j = jStart; j < jStart + 3; j++) {
           //     System.out.print(" " + grid[i][j]);
                max = Math.max(max, grid[i][j]);
            }

         //   System.out.println("");

        }

        return max;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {9, 9, 8, 1},
                {5, 6, 2, 6},
                {8, 2, 6, 4},
                {6, 2, 2, 2}
        };
        LargestLocalValuesInAMatrix valuesInAMatrix = new LargestLocalValuesInAMatrix();
        int[][] a = valuesInAMatrix.largestLocal(matrix);
        System.out.println("valuesInAMatrix = " + Arrays.deepToString(a));

    }
}
