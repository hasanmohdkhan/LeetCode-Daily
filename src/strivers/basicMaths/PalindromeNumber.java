package strivers.basicMaths;

/**
 * @Auther : hasan.khan
 * @Created : 20-Feb-24
 * @Description : <a href="">link</a>
 */
public class PalindromeNumber {


    public static void main(String[] args) {

        int n = 51415;

        System.out.println("rev = " + padlin(n));
        System.out.println("rev = " + padlin(2301));
        System.out.println("rev = " + padlin(121));


    }

    private static boolean padlin(int n) {
        int temp = n;
        int rev = 0;

        while (temp> 0){
            int last = temp%10;
            rev = rev * 10 + last;
            temp/=10;
        }

        return rev==n;
    }
}
