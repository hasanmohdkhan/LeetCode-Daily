package arrays.easy;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 24-Sep-23
 * @Description:
 */
public class ShuffleTheArray {

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length/2; i++) {
            result[2*i]= nums[i];
            result[2*i+1] = nums[n+i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;

        ShuffleTheArray shuffleTheArray = new ShuffleTheArray();
        System.out.println("shuffleTheArray = " + Arrays.toString(shuffleTheArray.shuffle(nums, n)));


    }
}
