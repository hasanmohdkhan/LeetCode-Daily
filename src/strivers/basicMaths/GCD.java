package strivers.basicMaths;

/**
 * @Auther : hasan.khan
 * @Created : 20-Feb-24
 * @Description : <a href="">link</a>
 */
public class GCD {

    private int calcGCD(int n, int m) {
       // if (m == null) return -1;

       /* int gcd = 1;

        for (int i = 1; i <= Math.min(n, m); i++) {

            if (n % i == 0 && m % i == 0) {
                gcd = i;
            }

        }

        return gcd;*/

        // Write your code here.



        if (m ==0)

            return n;

      return  calcGCD(m,n%m);

    }

    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println("gcd = " + gcd.calcGCD(9,6));
        System.out.println("gcd = " + gcd.calcGCD(2,5));
    }
}
