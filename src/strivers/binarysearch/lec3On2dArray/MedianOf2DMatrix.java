package strivers.binarysearch.lec3On2dArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 26-Jul-24
 * @Description : <a href="">link</a>
 */
public class MedianOf2DMatrix {

    int medianBrute(int[][] matrix, int m, int n) {
        List<Integer> list = new ArrayList<>();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                list.add(anInt);
            }
        }
        Collections.sort(list);
        return list.get((list.size()) / 2);
    }

    int median(int[][] matrix, int m1, int n1) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int[] row : matrix) {
            low = Math.min(low, row[0]); // low will be at O-index
            high = Math.max(high, row[n - 1]);
        }
        int req = (n * m) / 2;

        while (low <= high) {
            int mid = (low + high) / 2;
            int smallerThan = getBlackBox(matrix, m, mid);
            if (smallerThan <= req) low = mid + 1;
            else high = mid - 1;
        }


        return low;
    }

    private int getBlackBox(int[][] matrix, int m, int mid) {
        int smallerThan = 0;
        for (int i = 0; i < m; i++) smallerThan += bsUpperBound(matrix[i], mid);
        return smallerThan;
    }

    private int bsUpperBound(int[] matrix, int keyValue) {
        int low = 0;
        int high = matrix.length - 1;
        int ans = matrix.length ;


        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid] > keyValue) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    

    public static void main(String[] args) {
        MedianOf2DMatrix m = new MedianOf2DMatrix();
        System.out.println("median = " + m.median(new int[][]{
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}}, 3, 3));
        System.out.println("median = " + m.median(new int[][]{{1, 2, 3, 4, 5},
                {8, 9, 11, 12, 13},
                {21, 23, 25, 27, 29}}, 3, 4));

      /*  System.out.println("m = " + m.bsUpperBound(new int[]{1, 3, 5}, 5));
        System.out.println("m = " + m.bsUpperBound(new int[]{2, 6, 9}, 5));
        System.out.println("m = " + m.bsUpperBound(new int[]{3, 6, 9}, 5));*/
    }
}
