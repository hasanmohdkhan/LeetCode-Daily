package strivers.recurssion.study25;

/**
 * @Auther : hasan.khan
 * @Created : 28-Jan-25
 * @Description : <a href="https://leetcode.com/problems/powx-n/">link</a>
 */
public class Pow {

    public double myPow(double x, int n) {
        if (x == 1.0) return 1.0;

        long newN = n;
        if (n < 0) {
            x = 1 / x;
            newN = -newN;
        }

        return findPow(newN,x);

    }

    public double findPow(long n, double x){
        if(n==0) return 1;

       double half = findPow(n/2 , x);
       // Expo-national algo
       if(n %2 == 0){
           return half * half;
       }else {
           return half * half * x;
       }
    }

    public static void main(String[] args) {
        Pow p = new Pow();
        System.out.println("p = " + p.myPow(2.0, 10));
        System.out.println("p = " + p.myPow(2.10000, 3));
        System.out.println("p = " + p.myPow(2.00000, -2));
        System.out.println("p = " + p.myPow(2.00000, -2));
        System.out.println("p = " + p.myPow(2.00000, -2147483648));
    }


}
