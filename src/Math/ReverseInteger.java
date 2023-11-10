package Math;

/**
 * @Auther : hasan.khan
 * @Created : 09-Nov-23
 * @Description : <a href="https://leetcode.com/problems/reverse-integer/description/">link</a>
 */
public class ReverseInteger {
    public int reverse(int x) {
        int reverse = 0;
        boolean isNegative = x < 0;

        if(isNegative) {
            x = x * -1;
        }

        while (x >= 1) {
            int digit = x % 10;
            x = x / 10;
            //✅ Always check before multiplication
            // Integer.MIN_VALUE = -2147483648
            // Integer.MAX_VALUE = 2147483647

            //💡 We compare -214748364 not last digit i.e., 8. By dividing by 10 removing the last digit and
            //comparing the remainder separately.
            if (reverse < Integer.MIN_VALUE/10 /*|| reverse == Integer.MIN_VALUE/10 && digit < -8*/) {
                return 0;
            }

            //💡 We compare 2147483647 not last digit i.e., 7. By dividing by 10 removing the last digit and
            //comparing the remainder separately.
            if (reverse > Integer.MAX_VALUE/10 || reverse == Integer.MAX_VALUE/10 && digit > 7) {
                return 0;
            }
            //💡 2nd easy solution
           /* if (reverse < Integer.MIN_VALUE/10) {
                return 0;
            }
            //💡 2nd easy solution
            if (reverse > Integer.MAX_VALUE/10) {
                return 0;
            }*/

            reverse = reverse * 10 + digit;

        }

        if (isNegative) reverse = reverse * -1;

        return reverse;
    }


    public static void main(String[] args) {
        ReverseInteger res = new ReverseInteger();
        // int x = -1223433444;
        //  System.out.println("res = " + res.reverse(Integer.MAX_VALUE + 1));
        // System.out.println("res = " + res.reverse(Integer.MIN_VALUE - 1));
        System.out.println("res = " + res.reverse(42));
        System.out.println("res = " + res.reverse(-42));
        System.out.println("res = " + res.reverse(1534236469));
        // System.out.println("res = " + res.reverse(42));
        // System.out.println("res = " + res.reverse(23));
    }

}
