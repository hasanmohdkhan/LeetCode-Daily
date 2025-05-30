package strivers.bitmanipulation.misc.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 23-Apr-25
 * @Description : <a href="">link</a>
 */
public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        // 1. to remove one bit from we used right shift
        // 2. to add one bit from we used lef shift
        while (left != right) {
            left >>= 1;
            right >>= 1;
            count++;
        }
        // adding zeros to 1(if both bits are 1) if present then 0
        return (left << count);

    }

    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];

        int xor = 0;
        for (int n : nums) xor ^= n;
//        System.out.println("Integer.toBinaryString() = " + Integer.toBinaryString(xor));
//        System.out.println("Integer.toBinaryString() = " + Integer.toBinaryString(-xor));
//        System.out.println("Integer.toBinaryString() = " + Integer.toBinaryString(xor & -xor));


        int msb = xor & -xor;


        for (int i : nums) {
            if ((msb & i) == 0) res[0] ^= i;
            else res[1] ^= i;
        }

        return res;
    }

    public int bitwiseAdd(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public int binaryGap1(int n) {
        System.out.println("n = " + Integer.toBinaryString(n));
        int max = 0;
        int[] idx = new int[32];
        int t = 0;
        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) != 0) {
                idx[t++] = i;
            }
        }
        // System.out.println("idx = " + Arrays.toString(idx));

        for (int i = 0; i < t - 1; i++) {
            max = Math.max(max, idx[i + 1] - idx[i]);
        }


        return max;
    }

    public int binaryGap(int n) {
        int[] idx = new int[32];
        int t = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) != 0) idx[t++] = i;
            n >>= 1;
        }

        System.out.println("idx = " + Arrays.toString(idx));

        int ans = 0;
        for (int i = 0; i < t - 1; i++) {
            ans = Math.max(ans, idx[i + 1] - idx[i]);
        }

        return ans;
    }

    public int flipBitUsingXor(int n) {
        int mask = 0;
        System.out.println("n = " + Integer.toBinaryString(n));
        int temp = n;

        while (temp != 0) {
            mask = mask << 1;
            mask |= 1;
            temp >>= 1;
        }


        // System.out.println("ans = " + Integer.toBinaryString(ans));

        return mask ^ n;
    }

    public int smallestNumber(int n) {
        int temp = n;
        int mask = 0;
        while (temp > 0) {
            mask <<= 1;
            mask |= 1;
            temp >>= 1;

        }

        return n | mask;
    }




    public static void main(String[] args) {
        BitwiseANDOfNumbersRange s = new BitwiseANDOfNumbersRange();
      /*  System.out.println("s = " + s.smallestNumber(5));
        System.out.println("s = " + s.smallestNumber(10));*/
      /*  System.out.println("s = " + s.smallestNumber(10));
        System.out.println("s = " + s.smallestNumber(3));*/
       /* System.out.println("s = " + s.flipBitUsingXor(4));
        System.out.println("s = " + s.flipBitUsingXor(3));
        System.out.println("s = " + s.flipBitUsingXor(5));*/

       /* System.out.println("s = " + s.binaryGap(22));
        System.out.println("s = " + s.binaryGap(8));
        System.out.println("s = " + s.binaryGap(5));*/
        //  System.out.println("s = " + s.bitwiseAdd(11, 6));
        //clearSetBitUsingXorAndMasking(31);
        //System.out.println("s = " + Integer.toBinaryString(1));
        //System.out.println("s = " + Integer.toBinaryString(1 << 3));


        // setBitOnPosition(2, 19);
        //setBitOnPosition(2, 31);
        //setBitOnPosition(2, 8);


//        clearNthBit(31, 1);
//        clearNthBit(31, 0);
//        clearNthBit(31, 3);


        //    System.out.println("s = " + Integer.toBinaryString(1));
      /*  System.out.println("s1 = " + (3 << 1));
        int i = 1 << 20;
        System.out.println("s = " + Integer.toBinaryString(i));
        System.out.println("s = " + Integer.toBinaryString(i >> 16));
*/
        // System.out.println("s = " + Arrays.toString(s.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));

        /*System.out.println("s = " + Integer.toBinaryString(1));
        System.out.println("s = " + Integer.toBinaryString(0));
        System.out.println("s = " + Integer.toBinaryString(1^0));

        System.out.println(" _________________ "  );
        System.out.println("s = " + Integer.toBinaryString(4));
        System.out.println("s = " + Integer.toBinaryString(0));
        System.out.println("s = " + Integer.toBinaryString(4^0));

        System.out.println(" _________________ "  );
        System.out.println("s = " + Integer.toBinaryString(3));
        System.out.println("s = " + Integer.toBinaryString(1));
        System.out.println("s = " + Integer.toBinaryString(3^1));
        System.out.println(" _________________ "  );
        System.out.println("s = " + Integer.toBinaryString(3));
        System.out.println("s = " + Integer.toBinaryString(~3));*/

      /*  System.out.println("s = " + s.rangeBitwiseAnd(5, 7));
        System.out.println("s = " + s.rangeBitwiseAnd(0, 0));
        System.out.println("s = " + s.rangeBitwiseAnd(1, 2147483647));*/
    }

    private static void clearNthBit(int n, int post) {
        System.out.println("n = " + Integer.toBinaryString(n));
        int mask = 1;
        mask <<= post;
        System.out.println("mask = " + Integer.toBinaryString(mask));
        n &= -mask;
        System.out.println("n = " + Integer.toBinaryString(n));
    }

    private static void setBitOnPosition(int pos, int n) {
        System.out.println("Setting bit at pos = " + pos);
        System.out.println("n = " + Integer.toBinaryString(n));
        int mask = 1;
        mask <<= pos;
        System.out.println("mask = " + Integer.toBinaryString(mask));
        n |= mask;
        System.out.println("n = " + Integer.toBinaryString(n));
    }

    private static void clearSetBitUsingXorAndMasking(int n) {
        int mask = 1;
        System.out.println("xor flip bits one by one! ");
        System.out.println("n = " + Integer.toBinaryString(n));
        while (n != 0) {
            n ^= mask;
            System.out.println("xor " + Integer.toBinaryString(n));
            mask <<= 1;
        }
    }
}
