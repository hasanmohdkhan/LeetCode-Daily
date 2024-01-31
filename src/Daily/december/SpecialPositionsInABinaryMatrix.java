package Daily.december;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 13-Dec-23
 * @Description : <a href="https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/">link</a>
 */
public class SpecialPositionsInABinaryMatrix {
    public int numSpecial(int[][] mat) {

        int count = 0;
        for (int row = 0; row < mat.length; row++) {
            System.out.println("mat[row] = " + Arrays.toString(mat[row]));
            for (int col = 0; col < mat[row].length; col++) {


                //  System.out.println("mat[col] = " + mat[col][row]);
                if (mat[row][col] == 1) {
                    int sum = getSum(mat, row, col);
                   /* System.out.println("\nsum: "+sum);
                    System.out.println();*/

                    if (sum == 2) {
                        count++;
                    }
                }

            }
        }

        return count;
    }


    private static int getSum(int[][] mat, int row, int col) {
        int sum = 0;
        int[] rowArr = mat[row];

        System.out.println("Row ------ ");
        for (int i = 0; i < rowArr.length; i++) {
            System.out.print(" " + rowArr[i]);
            sum += rowArr[i];
        }

        System.out.println("\nsum: " + sum);

        System.out.println("Col ------> " + mat[0].length);
        System.out.println("Col ------>* " + mat.length);

        for (int i = 0; i < mat.length; i++) {
            System.out.print(" " + mat[i][col]);
            sum += mat[i][col];
        }
      //  System.out.println("\nsum: " + sum);
        return sum;
    }


    public int numSpecial1(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int res = 0;
        if(n == 1 && n == 1) return mat[0][0];
        int flag = 0;
        int col = -1;
        for(int i=0; i<n; i++){
            flag = 0;
            for(int j=0; j<m; j++){
                if(mat[i][j] == 1){
                    flag += 1;
                    col = j;
                }
            }
            if(flag == 1){
                flag = 0;
                for(int row = 0; row<n; row++){
                    if(mat[row][col] == 1){
                        flag += 1;
                    }
                }
            }
            if(flag == 1){
                res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}};
        int[][] mat1 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int[][] mat2 = {
                {0, 0},
                {0, 0},
                {1, 0}
        };

        SpecialPositionsInABinaryMatrix o = new SpecialPositionsInABinaryMatrix();
//       /* System.out.println("o = " + o.numSpecial(mat));
        // System.out.println("o = " + o.numSpecial(mat1));
        System.out.println("o = " + o.numSpecial(mat2));
    }
}
