package strings.hard;

import java.util.regex.Pattern;

/**
 * @Auther : hasan.khan
 * @Created : 23-Oct-23
 * @Description : <a href="https://leetcode.com/problems/strong-password-checker/description/">link</a>
 */
public class StrongPasswordChecker {

    public int strongPasswordChecker(String password) {
        int length = password.length();
        System.out.println("length = " + length + ", " + password);
        int step = 0;
        if (length <= 9) {
            step++;
        }
        String regexUpperCase = "[A-Z]"; // This regex matches any uppercase letter A to Z.
        String regexLowerCase = "[a-z]"; // This regex matches any uppercase letter a to z.
        String regexDigit = "[0-9]"; // This regex matches any uppercase letter a to z.
        String regexRepeat = "(.)\\1\\1";


       boolean isUpper = Pattern.compile(regexUpperCase).matcher(password).find();
       boolean isLower = Pattern.compile(regexLowerCase).matcher(password).find();
       boolean isDigit = Pattern.compile(regexDigit).matcher(password).find();
       boolean isRepeating = Pattern.compile(regexRepeat).matcher(password).find();

       // System.out.println("isLower = " + isLower);

       if(!isUpper)step++;
       if(!isLower)step++;
       if(!isDigit)step++;
       if(!isRepeating)step++;


        return step;
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "aA1";
        String s3 = "1337C0d3";
        StrongPasswordChecker strongPasswordChecker = new StrongPasswordChecker();
        System.out.println("s1 = " + strongPasswordChecker.strongPasswordChecker(s1));
        System.out.println("s2 = " + strongPasswordChecker.strongPasswordChecker(s2));
        System.out.println("s3 = " + strongPasswordChecker.strongPasswordChecker(s3));
    }
}
