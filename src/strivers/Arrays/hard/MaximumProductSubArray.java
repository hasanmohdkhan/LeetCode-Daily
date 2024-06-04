package strivers.Arrays.hard;

/**
 * @Auther : hasan.khan
 * @Created : 03-Jun-24
 * @Description : <a href="">link</a>
 */
public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = nums[0];
        int maxProduct = nums[0];
        int minProduct =nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) { // flip the max and min in case of -ve
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);
            ans = Math.max(ans, maxProduct);
        }

        return ans;
    }

    public int maxProductBrute(int[] nums) {
        int ans = Integer.MIN_VALUE;

        for (int num : nums) {
            int currProd = 1;
            for (int j = 0; j <= nums.length; j++) {
                if(currProd==0) currProd=1;
                 currProd *= nums[j];
                //System.out.println("currProd = " + currProd);
                ans = Math.max(currProd, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumProductSubArray s = new MaximumProductSubArray();
        int[] nums = {2, 3, -2, 4};
        int[] nums2 = {0,2};
        int[] nums3 = {0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0};
       // System.out.println("maxProductBrute = " + s.maxProductBrute(nums3));
       // System.out.println("maxProductBrute = " + s.maxProductBrute(nums2));
        System.out.println("maxProduct = " + s.maxProduct(nums3));
    }

}
