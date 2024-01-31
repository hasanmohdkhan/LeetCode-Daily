package Daily.december;

/**
 * @Auther : hasan.khan
 * @Created : 12-Dec-23
 * @Description : <a href="https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/?envType=daily-question&envId=2023-12-12">link</a>
 */
public class MaximumProductOfTwoElementsInAnArray {

    public int maxProduct(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1 ; j < nums.length  ; j++) {
                int res = (nums[j] - 1) * (nums[i] - 1);
                max = Math.max(res, max);
            }
        }





        return max;
    }

    public static void main(String[] args) {

        int[] ar = {3, 4, 5, 2};
        int[] arr = {1, 5, 4, 5};
        MaximumProductOfTwoElementsInAnArray o = new MaximumProductOfTwoElementsInAnArray();
        System.out.println("o = " + o.maxProduct(ar));
        System.out.println("o = " + o.maxProduct(arr));
    }

}
