package strivers.strings;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 28-Sep-24
 * @Description : <a href="https://leetcode.com/problems/rotate-string/description/">link</a>
 */
public class RotateString {

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s+s).contains(goal);
    }

    public static void main(String[] args) {
        RotateString s = new RotateString();
        System.out.println("s = " + s.rotateString("abcde", "cdeab"));
        System.out.println("s = " + s.rotateString("abcde", "abced"));
        System.out.println("s = " + s.rotateString("abcd", "abced"));
        System.out.println("s = " + s.rotateString("defdefdefabcabc","defdefabcabcdef"));
    }

}
