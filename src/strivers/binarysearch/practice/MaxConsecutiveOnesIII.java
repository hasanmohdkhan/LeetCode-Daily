package strivers.binarysearch.practice;

/**
 * @Auther : hasan.khan
 * @Created : 27-Aug-24
 * @Description : <a href="https://leetcode.com/problems/max-consecutive-ones-iii/description/">link</a>
 */
public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int high = nums.length;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (count1s(nums, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return ans;
    }

    private boolean count1s(int[] nums, int k, int minCount) {
        int countChanges = 0;

        for (int i = 0; i < minCount; i++) {
            if (1 != nums[i]) countChanges++;
        }

        if (countChanges <= k) return true;

        for (int i = minCount; i < nums.length; i++) {
            if (nums[i - minCount] != 1) countChanges--;
            if (nums[i] != 1) countChanges++;
            if (countChanges <= k) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII s = new MaxConsecutiveOnesIII();
        System.out.println("s = " + s.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println("s = " + s.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        System.out.println("s = " + s.longestOnes(new int[]{0, 0, 0, 0}, 0));
        System.out.println("s = " + s.longestOnes(new int[]{0,0,1,1,1,0,0}, 0));
        System.out.println("s = " + s.longestOnes(new int[]{0,0,0,1}, 4));
    }
}
