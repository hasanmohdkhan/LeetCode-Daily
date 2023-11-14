package strings.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther : hasan.khan
 * @Created : 11-Nov-23
 * @Description : <a href="https://leetcode.com/problems/unique-morse-code-words/description/">link</a>
 */
public class UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        HashMap<Character, String> map = new HashMap<>();

        char c = 'a';
        for (String string : morse) {
            map.put(c++, string);
        }
        Set<String> set = new HashSet<>();

        for (String word : words) {
            // System.out.println(""+words[i]);
            char[] s = word.toCharArray();
            StringBuilder str = new StringBuilder();
            for (Character a : s) {
                if (map.containsKey(a)) {
                    str.append(map.get(a));
                }
            }
            set.add(str.toString());


        }

        return set.size();
    }

    public static void main(String[] args) {
        String[] s = {"gin", "zen", "gig", "msg"};
        UniqueMorseCodeWords o = new UniqueMorseCodeWords();
        System.out.println("o = " + o.uniqueMorseRepresentations(s));
    }
}
