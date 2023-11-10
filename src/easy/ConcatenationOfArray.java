package easy;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 10-Sep-23
 * @Description:
 */
public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int[] arr = new int[nums.length*2];

        System.arraycopy(nums,0,arr,0,nums.length);
        System.arraycopy(nums,0,arr,nums.length,nums.length);

        System.out.println("arr = " + Arrays.toString(arr));

        return arr;

    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        ConcatenationOfArray concatenation = new ConcatenationOfArray();
        concatenation.getConcatenation(a);

    }


}
