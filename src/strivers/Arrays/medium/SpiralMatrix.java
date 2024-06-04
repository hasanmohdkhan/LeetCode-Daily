package strivers.Arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 01-Apr-24
 * @Description : <a href="https://leetcode.com/problems/spiral-matrix/description/">link</a>
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;//row
        int m = matrix[0].length;//columns
        System.out.println("m = " + m*n);
        // points for initialization for traversal
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        while (top <= bottom && left<= right) {
            // RIGHT traversal  L-R
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
             // traversal TOP - BOTTOM
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // traversal RIGHT - LEFT
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //traversal BOTTOM - TOP
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }

        }
      //  System.out.println("ans = " + ans);


        return ans;
    }

    public static int[] spiralMatrix(int [][]matrix) {
        //List<Integer> ans = new ArrayList<>();

        int n = matrix.length;//row
        int m = matrix[0].length;//columns
        int[] ans = new int[n*m];
        int ind=0;

        // points for initialization for traversal
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        while (top <= bottom && left<= right) {
            // RIGHT traversal  L-R
            for (int i = left; i <= right; i++) {
                ans[ind++]=matrix[top][i];
            }
            top++;
            // traversal TOP - BOTTOM
            for (int i = top; i <= bottom; i++) {
                ans[ind++]=matrix[i][right];
            }
            right--;

            // traversal RIGHT - LEFT
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans[ind++]=matrix[bottom][i];
                }
                bottom--;
            }
            //traversal BOTTOM - TOP
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans[ind++]=matrix[i][left];
                }
                left++;
            }

        }
        //  System.out.println("ans = " + ans);


        return ans;
    }

    public static void main(String[] args) {

        int[][] m = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        // {      L R
        //      {1,2,3,4},
        //  TB  {5,6,7,8},
        //     {9,10,11,12}
        // };
        //   L-R , T-B ,  R-L  , B-T
        SpiralMatrix sm = new SpiralMatrix();
        System.out.println("sm  = " + sm.spiralOrder(m));
        System.out.println("sm2 = " + Arrays.toString(sm.spiralMatrix(m)));
    }
}
