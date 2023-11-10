package arrays.easy;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 12-Oct-23
 * @Description : <a href="https://leetcode.com/problems/left-and-right-sum-differences/description/">Link</a>
 */
public class LeftAndRightSumDifferences {

    public int[] leftRightDifference(int[] nums) {
        // follow the prefix and postfix
        int left=0;
        int right=0;
        int[] leftSum = new int[nums.length];

       // The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
       // The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].

        for (int i = 0; i <nums.length; i++) {
              leftSum[i]=left;
              left+=nums[i];

        }

       // System.out.println("leftSum = " + Arrays.toString(leftSum));
        int[] rightSum = new int[nums.length];
        int[] ans = new int[nums.length];

        for (int i = nums.length -1 ; i >=0 ; i--) {
            rightSum[i]+=right;
            right+=nums[i];

        }
        //System.out.println("leftSum right= " + Arrays.toString(rightSum));
//answer[i] = |leftSum[i] - rightSum[i]|.
        for (int i = 0; i < nums.length; i++) {
            ans[i]= Math.abs(leftSum[i] - rightSum[i]);

        }
        //System.out.println("ans = " + Arrays.toString(ans));

       return ans;

    }

    public static void main(String[] args) {
        int[] arr = {10,4,8,3};
        LeftAndRightSumDifferences differences = new LeftAndRightSumDifferences();
        System.out.println("differences = " + Arrays.toString(differences.leftRightDifference(arr)));  ;

    }
}
