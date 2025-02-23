package strivers.binarysearch.practice;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 28-Aug-24
 * @Description : <a href="">link</a>
 */
public class RangeSumOfSortedSubArraySums {//TODO BS
    public int rangeSumBrute(int[] nums, int n, int left, int right) {
        long ans = 0;
        int mod = 1000000007;
        int[] ar = new int[(n * (n + 1)) / 2];

        int index = 0;
        for (int j = 0; j < nums.length; j++) {
            int sum = 0;
            for (int i = j; i < nums.length; i++) {
                sum += nums[i];
                ar[index++] = sum;
            }
        }

        Arrays.sort(ar);
        System.out.println("ar = " + Arrays.toString(ar));
        left--;
        for (int i = left; i < right; i++) ans = (ans + ar[i]) % mod;

        return (int) ans;
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = 1000000007;
        int minSum = Arrays.stream(nums).min().getAsInt();
        int maxSum = Arrays.stream(nums).sum();
        System.out.println("maxSum = " + maxSum);

        long ans = 0;
        for (int i = left; i <= right; i++) {
            ans = (ans + findKthSum(i,minSum, maxSum, n, nums)) % mod;
        }

        return (int) ans;
    }

    // Function to find the sum of the first k smallest subarray sums
    int findKthSum(int k , int minSum, int maxSum, int n, int[] nums) {
        int left = minSum, right = maxSum;
        int sum = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (countLessThanOrEqual(mid, n, nums) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
                sum = mid;  // potential k-th smallest sum
            }
        }
        return sum;
    }

    int countLessThanOrEqual(int x, int n, int[] nums) {
        int count = 0;
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                if (currentSum > x) break;
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        RangeSumOfSortedSubArraySums s = new RangeSumOfSortedSubArraySums();
        System.out.println("s = " + s.rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5));
        System.out.println("s = " + s.rangeSumBrute(new int[]{1, 2, 3, 4}, 4, 1, 5));
        System.out.println("s = " + s.rangeSum(new int[]{1, 2, 3, 4}, 4, 3, 4));
    }

}
