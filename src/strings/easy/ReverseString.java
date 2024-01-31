package strings.easy;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 29-Nov-23
 * @Description : <a href='https://leetcode.com/problems/reverse-string/description/'>link</a>
 */
public class ReverseString {
    public void reverseStringBrute(char[] s) {
        char[] rev = new char[s.length];
        int index = 0;

        // System.arraycopy(s, 0, rev, 0, s.length);

        for (int i = 0; i < s.length; i++) rev[i] = s[i];


        //   System.out.println("copy = " + Arrays.toString(rev));

        //   System.out.println("s[i] = " + s[i]);
        for (int i = rev.length - 1; i >= 0; i--) s[index++] = rev[i];
        //  System.out.println("rev = " + Arrays.toString(rev));

        //System.out.println("rev = " + Arrays.toString(s));
    }

    public void reverseStringTwo(char[] s) {
        //  System.out.println("s = " + Arrays.toString(s));
        int length = s.length;
        for (int i = 0, j = length - 1; i < length / 2; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        // System.out.println("s = " + Arrays.toString(s));

    }

    public void reverseString(char[] s) {
        System.out.println("s = " + Arrays.toString(s));
        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            char temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
        System.out.println("s = " + Arrays.toString(s));

    }

    public static void main(String[] args) {
        char[] r = {'h', 'e', 'l', 'l', 'o'};
        ReverseString rev = new ReverseString();
        rev.reverseString(r);
    }


}
