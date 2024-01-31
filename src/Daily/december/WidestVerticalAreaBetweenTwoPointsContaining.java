package Daily.december;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 21-Dec-23
 * @Description : <a href="https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/description/">link</a>
 */
public class WidestVerticalAreaBetweenTwoPointsContaining {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] x = new int[points.length];

        for (int i = 0; i < points.length; i++) x[i] = points[i][0];
        Arrays.sort(x);

        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < x.length - 1; i++) {
            maxDiff = Math.max( x[i + 1] - x[i], maxDiff);
        }
        
        return maxDiff;
    }

    public static void main(String[] args) {
        int[][] points = {{8, 7}, {9, 9}, {7, 4}, {9, 7}};

        int[][] points1 = {{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}};
        WidestVerticalAreaBetweenTwoPointsContaining o = new WidestVerticalAreaBetweenTwoPointsContaining();
        System.out.println("o = " + o.maxWidthOfVerticalArea(points));
        System.out.println("o = " + o.maxWidthOfVerticalArea(points1));
    }

}
