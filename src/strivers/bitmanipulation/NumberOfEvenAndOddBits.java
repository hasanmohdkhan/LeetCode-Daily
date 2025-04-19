package strivers.bitmanipulation;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 01-Apr-25
 * @Description : <a href="">link</a>
 */
public class NumberOfEvenAndOddBits {
    public int[] evenOddBit(int n) {
        int[] count = new int[2];
        int i = 0;

        while (n > 0) {
            if((n & 1) == 1) count[i % 2] +=1; // check if i-th bit is set
            n >>= 1; // right swift n
            i++;
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOfEvenAndOddBits s = new NumberOfEvenAndOddBits();
        System.out.println("s = " + Arrays.toString(s.evenOddBit(50)));
        System.out.println("s = " + Arrays.toString(s.evenOddBit(2)));
        System.out.println("s = " + Arrays.toString(s.evenOddBit(5)));
    }
}
