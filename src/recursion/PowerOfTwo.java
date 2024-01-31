package recursion;

/**
 * @Auther : hasan.khan
 * @Created : 31-Jan-24
 * @Description : <a href="https://leetcode.com/problems/power-of-two/description/">link</a>
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;

        while (n != 1) {
            if (n % 2 != 0) return false;
            else {
                n /= 2;
                // System.out.println("n = " + n);
            }

        }
        return true;
    }


    public boolean isPowerOfThree(int n) {

        if (n == 0 || n < 0) return false;

        while (n!=1){
            if(n%3!= 0) return false;
            n/=3;

        }

        return true;
    }

    public boolean isPowerOfFour(int n) {
        if (n == 0 || n < 0) return false;

        while (n!=1){
            if(n%4!= 0) return false;
            n/=4;

        }

        return true;
    }

    public static void main(String[] args) {
        PowerOfTwo p = new PowerOfTwo();
       /* System.out.println("p = " + p.isPowerOfTwo(1));
        System.out.println("p = " + p.isPowerOfTwo(16));
        System.out.println("p = " + p.isPowerOfTwo(3));
        System.out.println("p = " + p.isPowerOfTwo(134217727));*/

       /* System.out.println("p.isPowerOfThree(-1) = " + p.isPowerOfThree(-1));
        System.out.println("p.isPowerOfThree(0) = " + p.isPowerOfThree(0));
        System.out.println("p.isPowerOfThree(1) = " + p.isPowerOfThree(1));
        System.out.println("p.isPowerOfThree(27) = " + p.isPowerOfThree(27));*/
        System.out.println("p.isPowerOfFour() = " + p.isPowerOfFour(16));
        System.out.println("p.isPowerOfFour() = " + p.isPowerOfFour(5));
        System.out.println("p.isPowerOfFour() = " + p.isPowerOfFour(1));


    }


}
