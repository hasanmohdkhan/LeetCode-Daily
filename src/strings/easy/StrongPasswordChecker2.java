package strings.easy;

import java.util.regex.Pattern;

/**
 * @Auther : hasan.khan
 * @Created : 23-Oct-23
 * @Description : <a href="https://leetcode.com/problems/strong-password-checker-ii/description/">link</a>
 */
public class StrongPasswordChecker2 {

    public boolean strongPasswordCheckerIIRegx(String password) {
        int length = password.length();
        //   System.out.println("length = " + length + ", " + password);

        if (length < 8) return false;

        String regexUpperCase = "[A-Z]"; // This regex matches any uppercase letter A to Z.
        String regexLowerCase = "[a-z]"; // This regex matches any uppercase letter a to z.
        String regexDigit = "[0-9]"; // This regex matches any uppercase letter a to z.
        String regexRepeat = "(.)\\1";
        String regexSpecial = "[-!@#$%^&*()+].*";


        boolean isUpper = Pattern.compile(regexUpperCase).matcher(password).find();
        boolean isLower = Pattern.compile(regexLowerCase).matcher(password).find();
        boolean isDigit = Pattern.compile(regexDigit).matcher(password).find();
        boolean isRepeating = Pattern.compile(regexRepeat).matcher(password).find();
        boolean isSpecial = Pattern.compile(regexSpecial).matcher(password).find();

        //   System.out.println("isRepeating = " + isRepeating);
        //   System.out.println("isSpecial = " + isSpecial);

        if (!isUpper) return false;
        if (!isLower) return false;
        if (!isDigit) return false;
        if (isRepeating) return false;
        //   System.out.println("isSpecial = " + isSpecial);
        if (!isSpecial) return false;


        return true;
    }

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        boolean isSpecial = false;
        boolean isLow = false;
        boolean isUp = false;
        boolean isDigit = false;
        String sp = "-!@#$%^&*()+";
        char prev = '.';

        char[] charArray = password.toCharArray();
        for (char currentChar : charArray) {
            if(currentChar==prev) return false;
            prev=currentChar;
            if (currentChar >= 'A' && currentChar <= 'Z') isUp = true;
            else if (currentChar >= 'a' && currentChar <= 'z') isLow = true;
            else if (currentChar >= '0' && currentChar <= '9') isDigit = true;
            else if (sp.indexOf(currentChar) != -1) isSpecial = true;
        }


        return isUp && isLow && isSpecial && isDigit;
    }

    public static void main(String[] args) {
        String s1 = "IloveLe3tcode!";
        String s2 = "Me+You--IsMyDream";
        String s3 = "1aB!";
        String s4 = "-Aa1a1a1";
        StrongPasswordChecker2 strongPasswordChecker2 = new StrongPasswordChecker2();
        System.out.println("s1 = " + strongPasswordChecker2.strongPasswordCheckerII(s1));
        System.out.println("s2 = " + strongPasswordChecker2.strongPasswordCheckerII(s2));
        System.out.println("s3 = " + strongPasswordChecker2.strongPasswordCheckerII(s3));
        System.out.println("s4 = " + strongPasswordChecker2.strongPasswordCheckerII(s4));
    }
}
