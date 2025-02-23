package strivers.binarysearch.practice;

/**
 * @Auther : hasan.khan
 * @Created : 16-Aug-24
 * @Description : <a href="https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/">link</a>
 */
public class MaximumCountOfPositiveIntegerAndNegative {
    //TODO important problem

    public int maximumCount(int[] nums) {
        int neg = bsFindFirstNegative(nums);
        int pos = bsFindFirstPositive(nums);

        int posCount = nums.length - pos;
        int negCount = neg + 1;

        return Math.max(posCount, negCount);
    }

    private int bsFindFirstPositive(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > 0) {
                high = mid - 1;
            } else low = mid + 1;

        }
        return low; // first positive
    }

    private int bsFindFirstNegative(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < 0) {
                low = mid + 1;
            } else high = mid - 1;
        }

        return high; // last negative
    }

    public static void main(String[] args) {
        MaximumCountOfPositiveIntegerAndNegative s = new MaximumCountOfPositiveIntegerAndNegative();
        System.out.println("s = " + s.maximumCount(new int[]{-2, -1, -1, 1, 2, 3}));
        System.out.println("s = " + s.maximumCount(new int[]{-3, -2, -1, 0, 0, 1, 2}));
        System.out.println("s = " + s.maximumCount(new int[]{5, 20, 66, 1314}));
    }


}
