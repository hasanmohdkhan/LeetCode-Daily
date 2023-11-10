package neet150.Arrayshashing;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 11-Oct-23
 * @Description : <a href="https://leetcode.com/problems/product-of-array-except-self/description/">link</a>
 */
public class ProductOfArrayExceptSelf { //TODO update sheet with logic

    /**
     * Brute Force solution:
     *
     * @param nums array
     * @return productExceptSelf array
     */
    public int[] productExceptSelfBF(int[] nums) {
        int[] product = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            product[i]=1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product[i]*=nums[j];

                }
            }
        }
      //  System.out.println("" +Arrays.toString(product));

        return product;
    }

    /**
     * For ones, who did not understand how prefix-postfix works,
     * lets change 1, 2, 3, 4 positions to symbols like a, b, c, d, so multiplying will be:
     * prefix:
     * ->
     * |       a       |   a*b   | a*b*c | a*b*c*d |
     *  OR more accurate
     *  | 1 | a | a * b | a * b * c |
     * postfix:
     * <-
     * | a*b*c*d | b*c*d |   c*d   |      d        |
     * OR more accurate
     * |b * c * d |  c * d | d | 1 |
     *
     * the result is a multiply without the symbol in own position
     * (the left value from prefix and the right one from postfix):
     * | b*c*d | a*c*d | a*b*d | a*b*c |
     *
     * @param nums array
     * @return  pro
     */
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int left =1 ;
        int right =1;
       // prefix -> | 1 | a | a * b | a * b * c |
        for (int i = 0; i < nums.length; i++) {
            product[i] = left;
            left*= nums[i];
        }
        // postfix  -> |b * c * d |  c * d | d | 1 |
        for (int i = nums.length -1;  i >=0; i--) {
           product[i] *=right;
           right*= nums[i];
        }


        return product;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] arr1 = {-1,1,0,-3,3};
        ProductOfArrayExceptSelf self = new ProductOfArrayExceptSelf();
        System.out.println("in = " + Arrays.toString(arr));
        System.out.println("self = " + Arrays.toString(self.productExceptSelf(arr)));
        System.out.println("self = " + Arrays.toString(self.productExceptSelf(arr1)));

    }
}
