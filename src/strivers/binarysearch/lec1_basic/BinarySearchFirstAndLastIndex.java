package strivers.binarysearch.lec1_basic;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 07-Jun-24
 * @Description : <a href="">link</a>
 */
public class BinarySearchFirstAndLastIndex {

    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;

        first = getFirst(nums, target, first);
        if (first == -1) return new int[]{-1, -1}; // no wasting
        last = getLast(nums, target, last);

        return new int[]{first, last};
    }

    private int getLast(int[] nums, int target, int last) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                last = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return last;
    }

    private static int getFirst(int[] nums, int target, int first) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {   //int[] nums1 = {2,2}; 0,1
            int mid = (start + end) / 2;  // -> 0
            if (nums[mid] == target) {
                first = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return first;
    }

    public static void main(String[] args) {
        BinarySearchFirstAndLastIndex bs = new BinarySearchFirstAndLastIndex();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] nums1 = {2, 2};
        int target1 = 2;
        System.out.println("bs = " + Arrays.toString(bs.searchRange(nums1, target1)));
        System.out.println("bs = " + Arrays.toString(bs.searchRange(nums, target)));
    }
}
