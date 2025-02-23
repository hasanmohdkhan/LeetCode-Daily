package strivers.binarysearch.practice;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 19-Aug-24
 * @Description : <a href="https://leetcode.com/problems/find-the-distance-value-between-two-arrays/description/">link</a>
 */
public class FindDistanceValueBetweenTwoArrays {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int j : arr1) if (bs(j, arr2, d)) count++;
        return (arr1.length - count);
    }

    private boolean bs(int val, int[] arr2, int d) {
        int low = 0;
        int high = arr2.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (Math.abs(val - arr2[mid]) <= d) return true;
            if (arr2[mid] < val) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }


    public static void main(String[] args) {
        FindDistanceValueBetweenTwoArrays s = new FindDistanceValueBetweenTwoArrays();
        System.out.println("s = " + s.findTheDistanceValue(new int[]{4, 5, 8}, new int[]{10, 9, 1, 8}, 2));
        System.out.println("s = " + s.findTheDistanceValue(new int[]{1, 4, 2, 3}, new int[]{-4, -3, 6, 10, 20, 30}, 3));
        System.out.println("s = " + s.findTheDistanceValue(new int[]{2, 1, 100, 3}, new int[]{-5, -2, 10, -3, 7}, 6));
    }

}
