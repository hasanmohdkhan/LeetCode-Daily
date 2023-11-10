package easy;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 04-Sep-23
 * @Description:
 */
public class CountingBits {

    public int[] countBits(int n) {
        int[] result = new int[n+1];

        for (int i = 0; i <=n; i++) {
            result[i] = convertToBits(i);
        }
        System.out.println("Arrays(result) = " + Arrays.toString(result));
        return result;
    }

    private static int convertToBits(int n) {
        int bit = 0;
        while (n > 0) {
            bit += n % 2;
            n = n / 2;
        }
       // System.out.println("bits: "+bit);
        return bit;
    }

    public int[] countBitsByManipulation(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        System.out.println("countingBits = " +  Arrays.toString(countingBits.countBitsByManipulation(2)));
        countingBits.countBits(5);

        System.out.println("binary :"+ Integer.toBinaryString(2));
        System.out.println("binary :"+ (2>>1));

    }
}
