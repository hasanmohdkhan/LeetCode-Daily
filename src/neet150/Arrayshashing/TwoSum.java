package neet150.Arrayshashing;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 24-Oct-23
 * @Description : <a href="https://leetcode.com/problems/two-sum/description/">link</a>
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            System.out.println("right = " + right);
            System.out.println("left = " + left);
            if (target == nums[left] + nums[right]) {
                res[0] = left;
                res[1] = right;
            }

            left++;
            right--;
        }


        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        System.out.println("twoSum = " + Arrays.toString(twoSum.twoSum(nums, target)));
    }
}
