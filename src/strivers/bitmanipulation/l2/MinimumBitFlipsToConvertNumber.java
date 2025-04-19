package strivers.bitmanipulation.l2;

/**
 * @Auther : hasan.khan
 * @Created : 29-Mar-25
 * @Description : <a href="https://leetcode.com/problems/minimum-bit-flips-to-convert-number/">link</a>
 */
public class MinimumBitFlipsToConvertNumber {
    public int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        return  Integer.bitCount( ans);
    }


    public static void main(String[] args) {
        MinimumBitFlipsToConvertNumber s = new MinimumBitFlipsToConvertNumber();
        System.out.println("s = " + s.minBitFlips(10,7));
    }


}
