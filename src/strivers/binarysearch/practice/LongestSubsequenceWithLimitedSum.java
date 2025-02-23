package strivers.binarysearch.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 16-Aug-24
 * @Description : <a href="https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/">link</a>
 */
public class LongestSubsequenceWithLimitedSum {


    public int[] answerQueries(int[] nums, int[] queries) {
        int[] list = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) nums[i] += nums[ i - 1];
        for (int i = 0; i < queries.length; i++) list[i]  = bs(nums, queries[i]);

        return list;
    }

    private Integer bs(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] <= target) {
                low = mid + 1;
            } else high = mid - 1;

        }

        return low;
    }

    public static void main(String[] args) {
        LongestSubsequenceWithLimitedSum ls = new LongestSubsequenceWithLimitedSum();
         System.out.println("ls = " + Arrays.toString(ls.answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})));
         System.out.println("ls = " + Arrays.toString(ls.answerQueries(new int[]{2, 3, 4, 5}, new int[]{1})));

        System.out.println("bs = " + ls.bs(new int[]{1, 3, 7, 12}, 3));
        System.out.println("bs = " + ls.bs(new int[]{1, 3, 7, 12}, 10));
        System.out.println("bs = " + ls.bs(new int[]{1, 3, 7, 12}, 21));

    }

}
