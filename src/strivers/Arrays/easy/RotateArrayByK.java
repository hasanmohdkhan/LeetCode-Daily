package strivers.Arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 05-Mar-24
 * @Description : <a href="">link</a>
 */
public class RotateArrayByK {

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
      //  System.out.println("length = " + length);
      //  System.out.println("k = " + k);

        int[] temp = new int[k];

        // copy to temp array
        for (int i = length - k ; i < length; i++) {
            temp[i - length + k] = nums[i];
        }

      //  System.out.println("temp = " + Arrays.toString(temp));
        // swift the element
        for (int i = length - k - 1; i >=0 ; i--) {
            nums[i+k] = nums[i];
        }
      //  System.out.println("nums = " + Arrays.toString(nums));

         //add the temp value to an original array
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }

    }

    public static ArrayList<Integer> rotateArray(ArrayList<Integer> nums, int k) {
        int length = nums.size();
        k = k % length;
        //  System.out.println("length = " + length);
        //  System.out.println("k = " + k);

        int[] temp = new int[k];

        // copy to temp array
        for (int i = length - k ; i < length; i++) {
            temp[i - length + k] = nums.get(i);
        }

        //  System.out.println("temp = " + Arrays.toString(temp));
        // swift the element
        for (int i = length - k - 1; i >=0 ; i--) {
            nums.set(i + k, nums.get(i));
        }
        //  System.out.println("nums = " + Arrays.toString(nums));

        //add the temp value to an original array
        for (int i = 0; i < k; i++) {
            nums.set(i, temp[i]);
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 11, 12, 17};
        int k = 4;
        ArrayList<Integer> l = new ArrayList<>();

        for ( Integer i : nums){
            l.add(i);
        }


        System.out.println("nums = " + Arrays.toString(nums));
        new RotateArrayByK().rotate(nums,k);
        System.out.println("l = " + rotateArray(l, k));
     //   new RotateArrayByK().rotate(nums,8);




        System.out.println("k = " + Arrays.toString(nums));
    }
}
