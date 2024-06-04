package strivers.recurssion;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 23-Feb-24
 * @Description : <a href="">link</a>
 */
public class RevArray {


    public static int[] reverseArray(int n, int[] nums) {
        int[] rev = new int[n];
        int idx = 0;
        return rev(rev, nums, n, idx);
    }

    private static int[] rev(int[] rev, int[] nums, int n, int idx) {
        if (n == idx) {
            rev[idx - 1] = nums[n- (idx - 1)];
            return rev;
        }
        rev(rev, nums, n, idx + 1);
        rev[idx] = nums[n - idx - 1];

        return rev;
    }

    public static void main(String[] args) {
        int[] ar = {5, 7, 8, 1, 6, 3};
        System.out.println("ar = " + Arrays.toString(ar));
        System.out.println("args = " + Arrays.toString(reverseArray(6, ar)));

    }
}
