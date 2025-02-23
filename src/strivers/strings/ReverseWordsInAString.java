package strivers.strings;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Auther : hasan.khan
 * @Created : 15-Sep-24
 * @Description : <a href="https://leetcode.com/problems/reverse-words-in-a-string/description/">link</a>
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] s1 = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = s1.length - 1; i >= 0; i--) {
            sb.append(s1[i]);
            if (i != 0) sb.append(" ");
        }

        return sb.toString();
    }

    public String reverseWordsTwoPointer(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int start = 0;
        int end = s.length() - 1;

        while (end >= 0) { // starting from back of string

            while (end >= 0 && s.charAt(end) == ' ') end--;
            start = end;

            while (start >= 0 && s.charAt(start) != ' ') start--;

            sb.append(s, start + 1, end + 1);

            if (start > 0) sb.append(" ");

            end = start;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString s = new ReverseWordsInAString();
        System.out.println("s = " + s.reverseWords("the sky is blue"));
        System.out.println("s = " + s.reverseWords("  hello world  "));
        System.out.println("s = " + s.reverseWords("a good   example"));

        System.out.println("s = " + s.reverseWordsTwoPointer("the sky is blue"));
        System.out.println("s = " + s.reverseWordsTwoPointer("  hello world  "));
        System.out.println("s = " + s.reverseWordsTwoPointer("a good   example"));
    }
}
