package strivers.bitmanipulation.misc.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 17-Apr-25
 * @Description : <a href="https://leetcode.com/problems/single-number-iii/?envType=problem-list-v2&envId=bit-manipulation">link</a>
 */
public class SingleNUmberIII {
    public int[] singleNumberBrute(int[] nums) {
        HashMap<Integer, Integer> res = new HashMap<>();

        for (int num : nums) res.put(num, res.getOrDefault(num, 0) + 1);

        int[] ans = new int[2];
        int i = 0;
        for (Map.Entry k : res.entrySet()) {
            //  System.out.println("k = " + k);
            if ((Integer) k.getValue() != 2) {
                ans[i] = (Integer) k.getKey();
                i++;
            }
        }


        return ans;
    }

    public int duplicateNumbersXOR(int[] nums) {
        Arrays.sort(nums);
        //  System.out.println("nums = " + Arrays.toString(nums));
        int xor = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                //  System.out.println("n = " + Integer.toBinaryString(nums[i]) + " xor = "+Integer.toBinaryString(xor));
                xor ^= nums[i];
                //System.out.println("xor = " + Integer.toBinaryString(xor));
            }

        }
        // 1 1 2 3
        //  0  2 3
        // 2  3 ->
        // 10  11  -> 01

        // 1 1 2 2  x= 0   - 1
        //  2.  x = 1 ^ 2  -> 01 ^ 10  -> 11 -> 3
        // 3. 3 ^ 2 => 11 ^ 10 -> 01
        //

        //  System.out.println("bi = " + Integer.toBinaryString(3));
        //  System.out.println("xor = " + xor);
        return xor;
    }

    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }
        //  System.out.println("xor = " + Integer.toBinaryString(xor));

        int lb = xor & (-xor);

        System.out.println("x = " + Integer.toBinaryString(xor));
        System.out.println("2`x = " + Integer.toBinaryString(-xor));
        System.out.println("lb = " + Integer.toBinaryString(lb));

        for (int n : nums) {

            if ((lb & n) == 0) {
                //  System.out.println(n +" "+" n = " + Integer.toBinaryString(n) + " lb = "+Integer.toBinaryString(lb));
                res[0] ^= n;

            } else res[1] ^= n;

        }

        return res;
    }

    public int findComplement(int num) {
        if (num == 0) return 1;
        int n = Integer.toBinaryString(num).length();
        int mask = (1 << n) - 1;
        return mask ^ num;
    }

    public static void main(String[] args) {
        SingleNUmberIII s = new SingleNUmberIII();

        System.out.println("s = " + s.findComplement(5));

       /* System.out.println("s = " + s.duplicateNumbersXOR(new  int[]{1,2,1,3}));
        System.out.println("s = " + s.duplicateNumbersXOR(new  int[]{1,2,3}));
        System.out.println("s = " + s.duplicateNumbersXOR(new  int[]{1,2,2,1}));*/
        //  System.out.println("s = " + Arrays.toString(s.singleNumber(new int[]{1, 2, 1, 3, 2})));
        //  System.out.println("s = " + Arrays.toString(s.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
        //      System.out.println("s = " + Arrays.toString(s.singleNumber(new int[]{-1, 0})));

    }
}
