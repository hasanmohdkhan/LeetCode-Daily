package strivers.bitmanipulation.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 06-Apr-25
 * @Description : <a href="https://leetcode.com/problems/binary-prefix-divisible-by-5/description/?envType=problem-list-v2&envId=bit-manipulation">link</a>
 */
public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {

        List<Boolean> ans = new ArrayList<>();
        int num = 0;
        for (int bit : nums) {
            num = ((num << 1) | bit) % 5;
// 10 |  1  =>  11
// 11 | 0  ==> 11
            // System.out.println("i = " + Integer.toBinaryString(num));
            ans.add(num == 0);

        }

        return ans;
    }

    public static void main(String[] args) {
        BinaryPrefixDivisibleBy5 s = new BinaryPrefixDivisibleBy5();
        System.out.println("s = " + s.prefixesDivBy5(new int[]{1, 0, 1}));
        System.out.println("s = " + s.prefixesDivBy5(new int[]{0, 1, 1}));
    }
}
