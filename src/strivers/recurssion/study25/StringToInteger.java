package strivers.recurssion.study25;

/**
 * @Auther : hasan.khan
 * @Created : 26-Jan-25
 * @Description : <a href="https://leetcode.com/problems/string-to-integer-atoi/description/">link</a>
 */
public class StringToInteger {

    public int myAtoiBrute(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        boolean isNeg = false;
        int res = 0;
        if (s.indexOf("-") == 0 || s.indexOf("+") == 0 || s.indexOf("0") == 0) {
            if (s.indexOf("-") == 0) isNeg = true;
            s = s.substring(1);
        }
        // if (s.indexOf("0") == 0) s = s.substring(1);


        // 42 or 42
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).matches("\\d")) {
                int digit = s.charAt(i) - '0';
                if (res > (Integer.MAX_VALUE / 10) || res == Integer.MAX_VALUE / 10 && digit > 7) {
                    return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                res = res * 10 + digit;
            } else {
                break;
            }
        }

        return isNeg ? -res : res;
    }

    public int myAtoi(String s) {
        s = s.trim();
        boolean isNeg = false;
        int ans = 0;
        int idx = 0;
        if (s.isEmpty()) return 0;

        if (s.charAt(0) == '-') {
            isNeg = true;
            idx++;
        } else if (s.charAt(0) == '+') {
            idx++;
        }
        return convertStrToInt(s, isNeg, ans, idx);
    }

    private int convertStrToInt(String s, boolean isNeg, int ans, int idx) {

        if (idx >= s.length() || !Character.isDigit(s.charAt(idx))) {
            return isNeg ? -ans : ans;
        }

        ans = ans * 10 + (s.charAt(idx) - '0');

        if (ans > Integer.MAX_VALUE/10) {
            return Integer.MAX_VALUE;
        }
        if (isNeg == true && (ans * -1) < Integer.MIN_VALUE/10) return Integer.MIN_VALUE;


        return convertStrToInt(s, isNeg, ans, idx + 1);
    }

    public static void main(String[] args) {
        StringToInteger s = new StringToInteger();
        System.out.println("s = " + s.myAtoiBrute("42"));
        System.out.println("s =" + s.myAtoi(" -042"));
        System.out.println("s = " + s.myAtoi("1337c0d3"));
        System.out.println("s = " + s.myAtoi(""));
        System.out.println("s = " + s.myAtoi(" "));
        System.out.println("s = " + s.myAtoi("   +0 123"));
        System.out.println("s = " + s.myAtoi("+"));
    }

}
