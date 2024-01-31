package CodingPatterns;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 31-Jan-24
 * @Description : <a href="">link</a>
 */
public class DP {

    public static int fib(int n) {
        return fib(n, new HashMap<>());
    }

    public static int fib(int n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1) return n;

        if (memo.containsKey(n)) return memo.get(n);

        int result = fib(n - 1) + fib(n - 2);

        memo.put(n, result);

        return result;
    }

    public static int triFib(int n) {
        return triFib(n, new HashMap<>());
    }

    public static int triFib(int n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1) return n;

        if (n == 2) {
            return 1;
        }

        if(memo.containsKey(n)) return memo.get(n);

        int result = triFib(n - 1) + triFib(n - 2) + triFib(n - 3);
        memo.put(n, result);
        return result;
    }


    public static void main(String[] args) {
       /* System.out.println("fib(1) = " + fib(1));
        System.out.println("fib(2) = " + fib(2));
        System.out.println("fib(3) = " + fib(3));
        System.out.println("fib(4) = " + fib(4));
        System.out.println("fib(8) = " + fib(8));
        System.out.println("fib(10) = " + fib(10));
        System.out.println("fib(13) = " + fib(13));
        System.out.println("fib(40) = " + fib(40));
        System.out.println("fib(50) = " + fib(50));*/

        System.out.println("triFib(1) = " + triFib(1));
        System.out.println("triFib(2) = " + triFib(2));
        System.out.println("triFib(3) = " + triFib(3));
        System.out.println("triFib(5) = " + triFib(5));
        System.out.println("triFib(8) = " + triFib(8));
        System.out.println("triFib(13) = " + triFib(13));
    }


}
