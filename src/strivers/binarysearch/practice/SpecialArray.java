package strivers.binarysearch.practice;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 21-Aug-24
 * @Description : <a href="https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/">link</a>
 */
public class SpecialArray {

    public int specialArrayBrue(int[] nums) {
        int size = nums.length;
        int count = 0;
        int range = nums.length;

        for (int x = 0; x < range; x++) {
            for (int num : nums) {
                if (num >= x) count++;
            }

            for (int num : nums) {
                if (x == num && count == num) return count;
            }
        }

        if (count == 0) return -1;
        else return count;
    }

    public int specialArray(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n;
        Arrays.sort(nums);

        while (low <= high) {
            int target = (low + high) / 2;
            int count = n - lowerBound(target, nums);

            if (count == target) {
                return target;
            } else if (count > target) {
                low = target + 1;
            } else {
                high = target - 1;
            }

        }


        return -1;
    }

    private int lowerBound(int target, int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        SpecialArray sa = new SpecialArray();
        // System.out.println("sa = " + sa.specialArray(new int[]{3, 5}));
       // System.out.println("sa = " + sa.specialArray(new int[]{0, 0}));
        System.out.println("sa = " + sa.specialArray(new int[]{0, 4, 3, 0, 4}));
    }
}
