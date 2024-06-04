package strivers.recurssion;

/**
 * @Auther : hasan.khan
 * @Created : 22-Feb-24
 * @Description : <a href="">link</a>
 */
public class NaturalNumber {


    public static long sumFirstN(long n) {
        long memo = 0;
        return sum(n, memo);
    }

    public static long sum(long x, long memo) {
        if (x == 1) {
            memo += x;
            return memo;
        }

        memo = sum(x - 1, memo) + x;
        return memo;
    }

    public static void main(String[] args) {
        System.out.println("args = " + sumFirstN(3));
          System.out.println("args = " + sumFirstN(5));
    }
}
