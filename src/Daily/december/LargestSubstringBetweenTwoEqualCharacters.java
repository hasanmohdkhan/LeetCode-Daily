package Daily.december;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 31-Dec-23
 * @Description : <a href="https://leetcode.com/problems/largest-substring-between-two-equal-characters/description/">link</a>
 */
public class LargestSubstringBetweenTwoEqualCharacters {

    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> set = new HashMap<>();
        int max = -1;

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (set.containsKey(key)) {
                //  System.out.println("sub = " + s.substring(set.get(key), i));
                max = Math.max(s.substring(set.get(key), i).length() - 1, max);
            }
             else  set.put(key, i);
        }
        return max;

    }


    public static void main(String[] args) {
        LargestSubstringBetweenTwoEqualCharacters o = new LargestSubstringBetweenTwoEqualCharacters();
        System.out.println("o = " + o.maxLengthBetweenEqualCharacters("aa"));
        System.out.println("o = " + o.maxLengthBetweenEqualCharacters("abca"));
        System.out.println("o = " + o.maxLengthBetweenEqualCharacters("cbzxy"));
        System.out.println("o = " + o.maxLengthBetweenEqualCharacters("cabbac"));
    }
}
