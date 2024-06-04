package strivers.Arrays.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 18-Mar-24
 * @Description : <a href="">link</a>
 */
public class SumOfK {

    public static int getLongestSubarrayBrute(int[] nums, int k) {
        int l = 0;

        for (int i = 0; i < nums.length; i++) {
            int s = 0;
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                s += nums[j];
                count++;
                if (s == k) {
                    l = Math.max(count, l);
                }

            }
        }

        return l;
    }

    public static int getLongestSubarray(int[] nums, int k) {
        int maxlen = 0;
        int sum = 0;

        Map<Integer , Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(sum==k){
                maxlen = Math.max(maxlen, i+1);
            }

            // x - k
            int rem = sum - k;

            // calculate the length again
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                maxlen = Math.max(maxlen,len);
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }

        }


        return maxlen;
    }

    public static void main(String[] args) {
        int k = 4;
        int[] nums = {1, 2, 1, 0, 1};

        System.out.println("nums = " + getLongestSubarray(nums, k));

    }
}
