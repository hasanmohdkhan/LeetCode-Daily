package Daily.december;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 25-Dec-23
 * @Description : <a href="https://leetcode.com/problems/decode-ways/">link</a>
 */
public class DecodeWaysDP {
    public int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;  // empty string
        dp[1] = s.charAt(0) == '0' ? 0 : 1; //check for 0 if found return 0 then

        System.out.println("length = " + Arrays.toString(dp));


        for (int i = 2; i < s.length() + 1; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
                System.out.println("!=0  " + Arrays.toString(dp));
            }

            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')) {
                dp[i] += dp[i - 2];
                System.out.println("1 and 2 or < 7 = " + Arrays.toString(dp));
            }

        }


        return dp[s.length()];
    }


    public static void main(String[] args) {
        DecodeWaysDP o = new DecodeWaysDP();
        System.out.println("o = " + o.numDecodings("12"));
        System.out.println("o = " + o.numDecodings("226"));
        System.out.println("o = " + o.numDecodings("06"));
        System.out.println("o = " + o.numDecodings("10"));
        System.out.println("o = " + o.numDecodings("27"));
    }
}
