package strivers.strings;

import java.util.HashMap;

/**
 * @Auther : hasan.khan
 * @Created : 18-Sep-24
 * @Description : <a href="">link</a>
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();
        //  "badc","baba"
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapS.containsKey(charS)) {
                if (mapS.get(charS) != charT) return false;
            } else {
                mapS.put(charS, charT);
            }

            if (mapT.containsKey(charT)) {
                if (mapT.get(charT) != charS) return false;
            } else {
                mapT.put(charT, charS);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings s = new IsomorphicStrings();
        System.out.println("s1 = " + s.isIsomorphic("egg", "add"));
        System.out.println("s2 = " + s.isIsomorphic("foo", "bar"));
        System.out.println("s3 = " + s.isIsomorphic("paper", "title"));
        System.out.println("s4 = " + s.isIsomorphic("badc","baba"));
    }


}
