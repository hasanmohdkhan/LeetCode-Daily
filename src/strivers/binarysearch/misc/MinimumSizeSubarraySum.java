package strivers.binarysearch.misc;

/**
 * @Auther : hasan.khan
 * @Created : 24-Jun-24
 * @Description : <a href="">link</a>
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLenBrute(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    min = Math.min(min, ((j - i) + 1));
                }
            }

        }
        if (min == Integer.MAX_VALUE) return 0;
        return min;
    }

    public int minSubArrayLenBrute2(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                sum -= nums[left];
                min = Math.min(min, right - left + 1);
                left++;
            }
            right++;
        }


        if (min == Integer.MAX_VALUE) return 0;
        return min;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int start = 1;
        int end = nums.length ;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (getMin(target, nums, mid)) {
                end = mid - 1;
                min = mid;
            } else {
                start = mid + 1;
            }

        }
        if (min == Integer.MAX_VALUE) return 0;
        return min;
    }

    private static boolean getMin(int target, int[] nums, int size) {
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        while (right < nums.length) {
            sum += nums[right];
            if (right - left + 1 == size) {
                max = Math.max(sum, max);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return max >= target;
    }


    public static void main(String[] args) {
        MinimumSizeSubarraySum s = new MinimumSizeSubarraySum();
        System.out.println("s = " + s.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("s1 = " + s.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println("s2 = " + s.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));

//        System.out.println("b = " + s.minSubArrayLenBrute2(7, new int[]{2, 3, 1, 2, 4, 3}));
//        System.out.println("b1 = " + s.minSubArrayLenBrute2(4, new int[]{1, 4, 4}));
//        System.out.println("b2 = " + s.minSubArrayLenBrute2(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
