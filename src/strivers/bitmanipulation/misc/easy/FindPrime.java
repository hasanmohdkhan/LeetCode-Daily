package strivers.bitmanipulation.misc.easy;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @Auther : hasan.khan
 * @Created : 12-May-25
 * @Description : <a href="">link</a>
 */
public class FindPrime {

    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            if (isPrime(Integer.bitCount(i))) count++;
        }

        return count;
    }


    public boolean isPrime(int n) {
        return n == 2 || n == 3 || n == 5 || n == 7 || n == 11 || n == 13 || n == 17 || n == 19;
    }


    public long sumOfLargestPrimes(String s) {
        TreeSet<Long> p = new TreeSet<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
               // System.out.println("sub = " + sub);
                if (sub.length() > 1 && sub.charAt(0) == '0') continue;
                Long m = Long.parseLong(sub);
                if (isPrimeN(m)) {
                    p.add(m);
                }
            }
        }
        System.out.println("p = " + p);

        ArrayList<Long> list = new ArrayList<>(p.descendingSet());

       System.out.println("p = " + list);
        long sum = 0;
        for (int i = 0; i < Math.min(3, list.size()); i++) {
            sum += list.get(i);
        }

        //System.out.println("sum = " + sum);

        return sum;

    }

    private boolean isPrimeN(long num) {

        if (num < 2) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; (long) i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        FindPrime s = new FindPrime();

         System.out.println("s = " + s.sumOfLargestPrimes("12234"));
           System.out.println("s = " + s.sumOfLargestPrimes("111"));
        System.out.println("s = " + s.sumOfLargestPrimes("6259"));
        System.out.println("s = " + s.sumOfLargestPrimes("6735992919"));
        // 6 x
        // 62
        System.out.println("s.isPrimeN() = " + s.isPrimeN(69));


        /* System.out.println("s = " + s.countPrimeSetBits(6, 10));
        System.out.println("s = " + s.countPrimeSetBits(10, 15));
        System.out.println("s = " + s.countPrimeSetBits(990, 1048));*/
    }

}
