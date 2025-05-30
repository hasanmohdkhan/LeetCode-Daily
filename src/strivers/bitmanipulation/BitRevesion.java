package strivers.bitmanipulation;

/**
 * @Auther : hasan.khan
 * @Created : 21-Apr-25
 * @Description : <a href="">link</a>
 */
public class BitRevesion {

    public int hammingWeight(int n) {
        //System.out.println("n = " + Integer.bitCount(n));
        int count = 0;
        while (n > 0) {
            System.out.println("n = " + Integer.toBinaryString(n));
            // n & 1, if both are 1 bit is set.
            if ((n & 1) != 0) count++;
            n >>= 1;

        }

        //  System.out.println("count = " + count);

        return count;
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & n - 1) == 0;
    }

    public char findTheDifference(String s, String t) {
        int sT = 0;
        int tT = 0;
        for (int i = 0; i < s.length(); i++) {
            sT ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            tT ^= t.charAt(i);
        }


        return (char) (sT ^ tT);
    }

    public int missingNumber(int[] nums) {
        int eXor = 0;
        int eRange = 0;
        for (int num : nums) {
            eXor ^= num;
        }

        for (int i = 0; i <= nums.length; i++) {
            eRange ^= i;
        }


        return (eXor ^ eRange);

    }

    public static void main(String[] args) {
        BitRevesion b = new BitRevesion();

        System.out.println("b = " + b.missingNumber(new int[]{3, 0, 1}));
        System.out.println("Integer.toBinaryString(3) = " + Integer.toBinaryString(3));


      /*  System.out.println("b = " + b.findTheDifference("abcd",  "abcde"));
        System.out.println("b = " + b.hammingWeight(11));
        System.out.println("b = " + b.isPowerOfTwo(11));
        System.out.println("b = " + b.isPowerOfTwo(16));
        System.out.println("b = " + b.isPowerOfTwo(3));
        System.out.println("b = " + b.isPowerOfTwo(2432));*/
    }

}
