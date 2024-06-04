package strivers.Arrays.medium;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 31-Mar-24
 * @Description : <a href="https://leetcode.com/problems/rotate-image/description/">link</a>
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        // transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j < i) { // swap
                   // System.out.print(" j " + j + ", " + matrix[i][j]);
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            //System.out.println();
        }

        // reverse
        for (int[] ints : matrix) {
            reverse(ints);
        }


    }

    public static void reverse(int[] a) {
       // System.out.println("a = " + Arrays.toString(a));
        int i=0;
        int j = a.length-1;

        while (i<j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

      //  System.out.println("rev = " + Arrays.toString(a));

    }


    public static void main(String[] args) {
        RotateImage e = new RotateImage();

        int[][] m = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("before = " + Arrays.deepToString(m));
        e.rotate(m);
       // (m[0]);

        System.out.println("after = " + Arrays.deepToString(m));
    }
}
