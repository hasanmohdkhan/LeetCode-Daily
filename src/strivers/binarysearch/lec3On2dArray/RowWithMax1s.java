package strivers.binarysearch.lec3On2dArray;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 18-Jul-24
 * @Description : <a href="https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=row-with-max-1s">link</a>
 */
public class RowWithMax1s {


    public int rowWithMax1sBrute(int[][] arr) {
        int row = arr.length;
        int count = 0;
        int rowNum = 0;

        for (int i = 0; i < row; i++) {
            int currC = 0;
            for (int j = 0; j < arr[i].length; j++) if (arr[i][j] == 1) currC++;
            if (currC > count) {
                count = currC;
                rowNum = i;
            }
        }


        return rowNum;
    }

    public int rowWithMax1s(int[][] arr) {
        int row = arr.length;
        int count = 0;
        int index = -1;

        for (int i = 0; i < row; i++) {
            int currC = arr[i].length - callBs(arr[i]);
            if (currC > count) {
                count = currC;
                index = i;
            }
        }
        return index;
    }

    private int callBs(int[] ints) {
        int start = 0;
        int end = ints.length - 1;
        int ans = ints.length;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (ints[mid] >= 1) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;

        }

       // System.out.println("ans = " + ans);
        return ans;
    }


    public static void main(String[] args) {
        RowWithMax1s r = new RowWithMax1s();
        System.out.println("r = " + r.rowWithMax1s(new int[][]{{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}}));
        System.out.println("r = " + r.rowWithMax1s(new int[][]{{0, 0}, {1, 1}}));
    }

}
