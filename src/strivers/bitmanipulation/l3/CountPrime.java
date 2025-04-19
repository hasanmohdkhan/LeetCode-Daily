package strivers.bitmanipulation.l3;


import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 09-Apr-25
 * @Description : <a href="">link</a>
 */
public class CountPrime {

    public int countPrimes(int n) {
        int count = 0;
        if(n <=1 ) return 0;
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        //   System.out.println("prime = " + Arrays.toString(prime));
        // 1. 0,1 are not prime
        // 2. We start from 2 <-> n-1 range
        // 3. why we are doing i * i  because every multiple of 2, 3, 4... are already occurred if we check
        // 2*2, 2*3 ... and there are repeated numbers
        // So we only do i * i ...  for example 10  if we do  4 * 4 = 16 < 10 false no need to check.
        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                // Why i * i : same logic as above we only check for n * n.
                // Why j <n : we do not need to loop up to n.
                // Why j+=i : it will multiply with number for 2 it will 2,4,8 etc.
                for (int j = i * i; j < n; j += i) {
                    //  System.out.println("i = " + i + " j = "+j);
                    prime[j] = false;
                }
            }
        }

        // System.out.println("prime = " + Arrays.toString(prime));

        for (boolean isPrime : prime) if (isPrime) count++;
        return count;
    }


    public int countPrimesB(int n) {
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
        }

        return count;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CountPrime s = new CountPrime();
       /* System.out.println("s = " + s.countPrimesB(10));
        System.out.println("s = " + s.countPrimesB(3));
*/
        System.out.println("s = " + s.countPrimes(10));
        System.out.println("s = " + s.countPrimes(30));
        System.out.println("s = " + s.countPrimes(3));
        System.out.println("s = " + s.countPrimes(0));
    }
}
