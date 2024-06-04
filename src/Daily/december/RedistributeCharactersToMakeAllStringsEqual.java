package Daily.december;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 30-Dec-23
 * @Description : <a href="https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/description/">link</a>
 */
public class RedistributeCharactersToMakeAllStringsEqual {
    public boolean makeEqual(String[] words) {
        int length = words.length;
        if (length == 1) return true;

        Map<Character, Integer> map = new HashMap<>();
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i : map.values()) {
            if (i % length != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "aabc", "bc"};
        String[] words1 = {"ab", "a"};
        String[] words2 = {"abbab"};
        String[] words3 = {"caaaaa", "aaaaaaaaa", "a", "bbb",
                "bbbbbbbbb", "bbb", "cc", "cccccccccccc",
                "ccccccc", "ccccccc", "cc", "cccc",
                "c", "cccccccc", "c"};

        RedistributeCharactersToMakeAllStringsEqual o = new RedistributeCharactersToMakeAllStringsEqual();
        System.out.println("o = " + o.makeEqual(words));
        System.out.println("o = " + o.makeEqual(words1));
        System.out.println("o = " + o.makeEqual(words3));
    }

}
