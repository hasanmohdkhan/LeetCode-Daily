package strivers.Arrays.hard;

import java.util.HashMap;

/**
 * @Auther : hasan.khan
 * @Created : 06-May-24
 * @Description :
 */
public class LongestSubArrayWithZeroSum {

    public static int getLongestZeroSumSubarrayLengthBrute(int[] arr) {
        // Write your code here.
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) max = Math.max(max, j - i + 1);
            }

        }


        return max;
    }

    /**
     * Solution using a Prefix sum:
     * Core Logic: create a record for index and sum at the index  map<sum, index>
     * 1. If a prefix map does not contain a sum then add sum and their index in map
     * 2. Else get the index using a sum.
     *
     * 3.  lengthOfLongestArrayWithSum = current index - map.get(sum);
     *
     * Add two variable sums and max, compare max with lengthOfLongestArrayWithSum get the max
     *
     *
     * @param arr
     * @return
     */
    public static int getLongestZeroSumSubarrayLength(int[] arr) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>(); // sum , index
        int sum = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {  //  {1, -1, 0, 0, 1};
            sum += arr[i];
            if (sum == 0) {
                max = i + 1;
            } else {
                if (prefixSum.get(sum) != null) max = Math.max(max, i - prefixSum.get(sum));
                else prefixSum.put(sum, i);
            }
        }


        return max;
    }

    public static void main(String[] args) {

        int[] arr = {1, -1, 0, 0, 1};
        int[] arr1 = {19, 0, 32, 49, 21, 25, 23, 31, 20, 5, 50, 49, 9, 44, 10, 13, 3, 31, 48, 22, -1};
        int[] arr2 = {1, 45, 22, 0, 10, -37, 37, 29, 23, 2, 9, 0, 2, 15, 49, 6, 27, 25, 35, 50,
                39, 1, 42, 49, 20, 33, 28, 40, 26, 14, 38, 26, 25, 16, 49};

        System.out.println("getLongestZeroSumSubarrayLength() = " + getLongestZeroSumSubarrayLength(arr));
        System.out.println("getLongestZeroSumSubarrayLength() = " + getLongestZeroSumSubarrayLength(arr1));
        System.out.println("getLongestZeroSumSubarrayLength() = " + getLongestZeroSumSubarrayLength(arr2));
    }

}
