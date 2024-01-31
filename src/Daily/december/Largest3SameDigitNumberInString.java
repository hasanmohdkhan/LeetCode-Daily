package Daily.december;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 04-Dec-23
 * @Description : <a href="">link</a>
 */
public class Largest3SameDigitNumberInString {

    public String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; i--) {
            String c = String.valueOf(i).repeat(3);
            if (num.contains(c)) {
                return c;
            }

        }

        return "";
    }



    public static void main(String[] args) {
        Largest3SameDigitNumberInString res = new Largest3SameDigitNumberInString();
        System.out.println("Res = " + res.largestGoodInteger("6777133339"));
        System.out.println("Res = " + res.largestGoodInteger("2300019"));
        System.out.println("Res = " + res.largestGoodInteger("42352338"));
    }

}
