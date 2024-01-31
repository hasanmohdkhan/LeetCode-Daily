package Daily.december;

import java.util.HashMap;

/**
 * @Auther : hasan.khan
 * @Created : 16-Dec-23
 * @Description : <a href="https://leetcode.com/problems/valid-anagram/description/">link</a>
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character , Integer> sMap = new HashMap<>();
        HashMap<Character , Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
        }
        System.out.println("sMap = " + sMap);

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }
        System.out.println("tMap = " + tMap);
       // System.out.println("isEqual = " + tMap.entrySet().equals(sMap.entrySet()));


        
        return tMap.entrySet().equals(sMap.entrySet());
    }


    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        ValidAnagram o = new ValidAnagram();
        System.out.println("o = " + o.isAnagram(s, t));
        s = "rat";
        t = "car";

        System.out.println("o = " + o.isAnagram(s, t));
    }
}
