package strivers.recurssion.study25;

/**
 * @Auther : hasan.khan
 * @Created : 29-Jan-25
 * @Description : <a href="">link</a>
 */
public class CountGoodNumbers {

    public static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long numEven = (n + 1) / 2;
        long numodd = n / 2;

        long evenWay = pow(5, numEven);
        long oddWay = pow(4, numodd);

        return (int) ((evenWay * oddWay) % MOD);
    }

    private long pow(int base, long exp) {
        if (exp == 0) return 1;
        long result = pow(base, exp / 2);

        if (exp % 2 == 0) return (result * result) % MOD;
        else return (base * result *result )% MOD;

    }

    public static void main(String[] args) {
        CountGoodNumbers s = new CountGoodNumbers();
        System.out.println("s = " + s.countGoodNumbers(1));
        System.out.println("s = " + s.countGoodNumbers(4));
        System.out.println("s = " + s.countGoodNumbers(50));
    }
}
