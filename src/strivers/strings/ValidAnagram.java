package strivers.strings;

import java.util.HashMap;

/**
 * @Auther : hasan.khan
 * @Created : 29-Sep-24
 * @Description : <a href="https://leetcode.com/problems/valid-anagram/description/">link</a>
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        return sMap.entrySet().equals(tMap.entrySet());
    }

    public static void main(String[] args) {
        ValidAnagram s = new ValidAnagram();
        System.out.println("s = " + s.isAnagram("anagram", "nagaram"));
        System.out.println("s = " + s.isAnagram("rat", "car"));
    }
}
