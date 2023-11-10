package CodingPatterns;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 24-Oct-23
 * @Description : <a href="https://www.designgurus.io/blog/dont-just-leetcode">link</a>
 */
public class SlidingWindow {

    /**
     * Core concept
     *
     * @param nums arr
     */
    public static void TestWidow(int[] nums) {
        int windowSize = 3;
        for (int i = 0; i < nums.length - windowSize + 1; i++) {
            for (int j = i; j < i + windowSize; j++) {
                System.out.println();
                System.out.print(" " + nums[j]);
            }
            System.out.println();
        }

    }

    public static void TestWidowOptimal(int[] nums) {
        int windowSize = 3;
        for (int i = 0; i < nums.length - windowSize + 1; i++) {
            for (int j = i; j < i + windowSize; j++) {
                System.out.println();
                System.out.print(" " + nums[j]);
            }
            System.out.println();
        }

    }

    public static int findMaxSumSubarray(int[] arr, int k) {
        // check validate array and k
        if (arr == null || arr.length == 0 || k > arr.length) return -1;

        int totalSum = 0;
        int currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }

        System.out.println("currentSum = " + currentSum);

        for (int i = k; i < arr.length; i++) {
         //   System.out.println("i = " + i + ", k " +k +" , arr[i-k] = " + arr[i - k] + " currentSum = " + currentSum);
            currentSum -= arr[i - k]; // i=3 & k=3 -> arr[0] :-> 1
        //    System.out.println("currentSum = " + currentSum);
            currentSum += arr[i];

            totalSum = Math.max(currentSum, totalSum);
            System.out.println();


        }

        return totalSum;
    }

    public static void main(String[] args) {
       /* int k = 3;
        int[] arr = {1, 2, 3, 4, 5, 6};*/
        int[] arr = {1,2,3,4,5};
        int k = 3;
        System.out.println("arr = " + Arrays.toString(arr));
      //  System.out.println("slidingWindow = " + findMaxSumSubarray(arr, k));
       TestWidow(arr);
       TestWidowOptimal(arr);


    }
}
