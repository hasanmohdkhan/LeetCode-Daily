package strivers.binarysearch.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 31-Aug-24
 * @Description : <a href="https://leetcode.com/problems/longest-increasing-subsequence/description/">link</a>
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        List<Integer> dp = new ArrayList<>();

        for (int target : nums) {
            int index = bs(dp, target);

            if (index < dp.size()) {
                dp.set(index, target);
            } else dp.add(target);

        }

        System.out.println("dp = " + dp);
        return dp.size();
    }

    private int bs(List<Integer> dp, int target) {
        int low = 0;
        int high = dp.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (dp.get(mid) == target) return mid;
            if (dp.get(mid) < target) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence s = new LongestIncreasingSubsequence();
        System.out.println("s = " + s.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println("s = " + s.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println("s = " + s.lengthOfLIS(new int[]{}));
    }

}
