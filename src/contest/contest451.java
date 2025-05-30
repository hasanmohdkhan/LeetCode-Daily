package contest;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Auther : hasan.khan
 * @Created : 25-May-25
 * @Description : <a href="">link</a>
 */
public class contest451 {

    public long minCuttingCost(int n, int m, int k) {
        if (n <= k && m <= k) return 0;
        int minCost = Integer.MAX_VALUE;

        if (n > k) {
            for (int i = 1; i < n; i++) {
                int b = n - i;
                //System.out.println("b = " + b);
                minCost = Math.min(minCost, b * i);
            }
        }

        System.out.println("n = " + minCost);

        if (m > k) {
            for (int i = 1; i < m; i++) {
                int b = m - i;
                System.out.println("b = " + b + " i = " + i);
                minCost = Math.min(minCost, b * i);
            }
        }
        System.out.println("n = " + minCost);

        return minCost;

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if (map.containsKey(dif)) {
                return new int[]{map.get(dif), i};
            }
            map.put(nums[i], i);
        }


        return new int[]{};
    }

    public static void main(String[] args) {
        contest451 c = new contest451();
        System.out.println("c = " + Arrays.toString(c.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println("c = " + Arrays.toString(c.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("c = " + Arrays.toString(c.twoSum(new int[]{3, 3}, 6)));
       /* System.out.println("c = " + c.minCuttingCost(6, 5, 5));
        System.out.println("c = " + c.minCuttingCost(4, 4, 6));
        System.out.println("c = " + c.minCuttingCost(1, 4, 2));*/
    }
}
