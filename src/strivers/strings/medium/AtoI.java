package strivers.strings.medium;

/**
 * @Auther : hasan.khan
 * @Created : 03-Oct-24
 * @Description : <a href="https://leetcode.com/problems/string-to-integer-atoi/description/">link</a>
 */
public class AtoI {

    public int myAtoi(String s) {
        s = s.trim();
        boolean isNegative = false;
        int res = 0;

        if (s.contains("-") && s.indexOf("-") == 0 || s.contains("+") && s.indexOf("+") == 0) {
            if(s.contains("-")) isNegative = true;
            s = s.substring(1);
        }

        if (s.indexOf("0") == 0) s = s.substring(1);


        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).matches("\\d")) {
                int digit = s.charAt(i) - '0';

                if(res> (Integer.MAX_VALUE/10) || (res == (Integer.MAX_VALUE/10 ) && digit > 7 )){
                    return  isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }


                res = (res * 10) + digit;
            }else {
                break;
            }
        }


        return isNegative ? -res : res;

    }


    public static void main(String[] args) {
        AtoI a = new AtoI();
        System.out.println("a = " + a.myAtoi("-42"));
        System.out.println("a = " + a.myAtoi(" -042"));
        System.out.println("a = " + a.myAtoi("1337c0d3"));
        System.out.println("a = " + a.myAtoi("0-1"));
        System.out.println("a = " + a.myAtoi("-91283472332"));
        System.out.println("a = " + a.myAtoi("+1"));
        System.out.println("a = " + a.myAtoi("   -042"));
    }
}
