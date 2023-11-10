package easy;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 08-Sep-23
 * @Description:
 */
public class BuildArrayFromPermutation {
    public int[] buildArray(int[] nums) {
        int[] per = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            per[i] = nums[num];
        }
       // System.out.println(Arrays.toString(per));
        return per;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 5, 3, 4};
        BuildArrayFromPermutation per = new BuildArrayFromPermutation();
        System.out.println("per = " + Arrays.toString(per.buildArray(arr)));

    }
}
