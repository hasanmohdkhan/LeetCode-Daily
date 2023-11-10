package neet150.binarysearch;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 03-Oct-23
 * @Description:
 */
public class BinarySearch {


    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) start = mid + 1;
            else end = mid;

        }

        return -1;
    }

    private int binarySearch(int[] grid, int target) {
        System.out.println("grid = " + Arrays.toString(grid));
        int left = 0;
        int right = grid.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (grid[mid] == target)  return mid;
            if (grid[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        // not found
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        int[] arr1 = {2, 5};
        int target = 9;
        BinarySearch bs = new BinarySearch();
        System.out.println("bs = " + bs.search(arr, target));
        System.out.println("bs odd= " + bs.search(arr1, 5));

    }
}
