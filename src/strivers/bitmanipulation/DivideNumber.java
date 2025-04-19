package strivers.bitmanipulation;

/**
 * @Auther : hasan.khan
 * @Created : 28-Mar-25
 * @Description : <a href="">link</a>
 */
public class DivideNumber {

    public int divideBrute(int dividend, int divisor) {
        int count = 0;
        int sum = 0;
        boolean isNeg = false;
        boolean isDNeg = false;

        if (divisor < 0) {
            divisor = Math.abs(divisor);
            isNeg = true;
        }

        if (dividend < 0) {
            dividend = Math.abs(dividend);
            isDNeg = true;
        }

        while (sum + divisor <= dividend) {
            count++;
            sum += divisor;
        }

        if (isDNeg) count = count * -1;

        return isNeg ? -count : count;
    }

    public int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        boolean sign = (dividend > 0) == (divisor > 0); // True if both have the same sign

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long q = 0;
        while (n >= d) {
            int count = 0;
            // d << count+1 equal to d * 2^(count+1)
            while (n >= (d << (count + 1))) count++;
            q += (1L << count); // Use long to prevent overflow
            n -= (d << count);
        }

        q = sign ? q : -q;

        if (q > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (q < Integer.MIN_VALUE) return Integer.MAX_VALUE;

        return (int) q;
    }

    public static void main(String[] args) {
        DivideNumber s = new DivideNumber();
        System.out.println("s = " + s.divide(10, 3));
        System.out.println("s = " + s.divide(7, -3));
        System.out.println("s = " + s.divide(-1, 1));
    }
}
