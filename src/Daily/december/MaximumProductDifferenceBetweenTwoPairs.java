package Daily.december;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 18-Dec-23
 * @Description : <a href="">link</a>
 */
public class MaximumProductDifferenceBetweenTwoPairs {

    public int maxProductDifference(int[] nums) {
        if(nums.length == 0 )return 0;
        Arrays.sort(nums);
      //  System.out.println("nums = " + Arrays.toString(nums));
        return (nums[nums.length-2]  * nums[nums.length-1]) - (nums[0] * nums[1]) ;

       //return 0;
    }

    public static void main(String[] args) {
        int[] a = {5,6,2,7,4};
        int[] b ={4,2,5,9,7,4,8};
         MaximumProductDifferenceBetweenTwoPairs o = new MaximumProductDifferenceBetweenTwoPairs();
        System.out.println("o = " + o.maxProductDifference(a));
        System.out.println("o = " + o.maxProductDifference(b));
    }
}
