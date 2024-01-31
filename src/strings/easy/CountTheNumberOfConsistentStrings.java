package strings.easy;

import java.util.HashSet;

/**
 * @Auther : hasan.khan
 * @Created : 20-Nov-23
 * @Description : <a href="https://leetcode.com/problems/count-the-number-of-consistent-strings/description/">link</a>
 */
public class CountTheNumberOfConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {

        HashSet<Character> allowedMap = new HashSet<>();
        extract(allowed, allowedMap);
        int res = 0;
       // System.out.println("allowedMap = " + allowedMap);

        for (String word : words) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (!allowedMap.contains(word.charAt(i))) count++;
            }
            if (count == 0) res++;

        }


        return res;
    }

    private static void extract(String allowed, HashSet<Character> allowedMap) {
        for (int i = 0; i < allowed.length(); i++) {
            allowedMap.add(allowed.charAt(i));
        }
    }


    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};

        CountTheNumberOfConsistentStrings o = new CountTheNumberOfConsistentStrings();
        System.out.println("o = " + o.countConsistentStrings(allowed, words));
    }
}
