package strivers.strings.medium;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 29-Sep-24
 * @Description : <a href="https://leetcode.com/problems/sort-characters-by-frequency/description/">link</a>
 */
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new LinkedList<>(freq.entrySet());

        Collections.sort(list, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> e : list) {
           // sortedMap.put(e.getKey(), e.getValue());
            if(e.getValue() > 1) {
                sb.append(String.valueOf(e.getKey()).repeat(Math.max(0, e.getValue())));
            }else {
                sb.append(e.getKey());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency s = new SortCharactersByFrequency();
        System.out.println("s = " + s.frequencySort("tree"));
        System.out.println("s = " + s.frequencySort("cccaaa"));
        System.out.println("s = " + s.frequencySort("Aabb"));
    }


}
