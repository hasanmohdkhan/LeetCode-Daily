package strivers.bitmanipulation.l2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 30-Mar-25
 * @Description : <a href="">link</a>
 */
public class SingleNumber {

    public int singleNumberI(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;
        return xor;
    }

    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;

        for (int n : nums) {
            one = (one ^ n) & ~two;
            two = (two ^ n) & ~one;
        }

        return one;
    }



    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int totalNoOfCombinations = 1 << nums.length;// total no of combination are there
        //System.out.println("totalNoOfCombinations = " + Integer.toBinaryString(totalNoOfCombinations));

        for (int mask = 0; mask < totalNoOfCombinations; mask++) {
            List<Integer> subset = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if ((mask & (1 << i)) != 0) {
                  //  System.out.println("i = " + Integer.toBinaryString(1 << i) + " m = " + Integer.toBinaryString(mask & (1 << i)));
                    subset.add(nums[i]);
                }
            }
            res.add(subset);

        }


        return res;
    }

    public static int findXOR(int l, int r) {

        for (int i = l; i <= r; i++) {
            System.out.println("l = " + i);
            l ^= i;
        }

        return l;
    }

    public static void main(String[] args) {
        SingleNumber s = new SingleNumber();
        System.out.println("s.subsets() = " + findXOR(4, 8));
      //  System.out.println("s = " + s.subsets(new int[]{1, 2, 3}));
      /*  System.out.println("() = " + ((Integer.toBinaryString(0))));
        System.out.println("() = " + ((Integer.toBinaryString(~0))));
        System.out.println("s = " + (((2 & 2) ^ 2) ^ 3));
       // System.out.println("s = " + s.singleNumber(new int[]{2, 2, 1}));
        System.out.println("s = " + s.singleNumber(new int[]{2,2,3,2}));
       // System.out.println("s = " + s.singleNumber(new int[]{4, 1, 2, 1, 2}));*/
    }
}
