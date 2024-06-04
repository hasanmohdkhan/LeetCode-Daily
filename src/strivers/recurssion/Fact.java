package strivers.recurssion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 22-Feb-24
 * @Description : <a href="">link</a>
 */
public class Fact {

    public static List<Long> factorialNumbers(long n) {
        List<Long> list = new ArrayList<>();
        Long init = 1L;

        factorial(list, n, init);

        return list;
    }

    private static void factorial(List<Long> list, long n, Long init) {
        if (init > n) {
            return;
        }
        long fact = fact(init);
        if (n >= fact) {
            list.add(fact);
            factorial(list,n,init+1);
        }

    }

    private static long fact(long n) {
        if (n == 0) return 1;
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("fo = " + factorialNumbers(7));

    }
}
