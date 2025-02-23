package strivers.strings.medium;

import java.util.HashMap;

/**
 * @Auther : hasan.khan
 * @Created : 02-Oct-24
 * @Description : <a href="https://leetcode.com/problems/roman-to-integer/description/">link</a>
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        int res = 0;
        int[] roman = new int[128];

        roman['I'] = 1;
        roman['V'] = 5;
        roman['X'] = 10;
        roman['L'] = 50;
        roman['C'] = 100;
        roman['D'] = 500;
        roman['M'] = 1000;

        for (int i = 0; i + 1 < s.length(); i++) {
            if (roman[s.charAt(i)] < roman[s.charAt(i + 1)]) {
                res -= roman[s.charAt(i)];
            } else {
                res += roman[s.charAt(i)];
            }
        }

        return res + roman[s.charAt(s.length() - 1)];
    }

    public static void main(String[] args) {
        RomanToInteger s = new RomanToInteger();
        System.out.println("s = " + s.romanToInt("III"));
        System.out.println("s = " + s.romanToInt("LVIII"));
        System.out.println("s = " + s.romanToInt("MCMXCIV"));
    }


}
