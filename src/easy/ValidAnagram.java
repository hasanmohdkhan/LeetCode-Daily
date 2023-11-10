package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Auther : hasan.khan
 * @Created : 14-Sep-23
 * @Description:
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        // length should be the same for further processing
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> sHashMap = new HashMap<>();
        HashMap<Character, Integer> tHashMap = new HashMap<>();
        //   System.out.println("s = " + s);
        addToHashmap(s, sHashMap);
        addToHashmap(t, tHashMap);
        //   System.out.println("sHashMap = " + sHashMap);
        //  System.out.println("tHashMap = " + tHashMap);

        return sHashMap.equals(tHashMap);
    }

    /**
     * Using sorting method
     *
     * @param s string 1
     * @param t string 2
     * @return Anagram or not
     */
    public boolean isAnagramSort(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

//  O(n log(n)) : The sorting algorithm is a Dual-Pivot Quicksort by Vladimir Yaroslavskiy
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        System.out.println("sArr = " + Arrays.toString(sArr));
        System.out.println("tArr = " + Arrays.toString(tArr));

        return Arrays.equals(tArr,sArr);

    }


    private static void addToHashmap(String s, HashMap<Character, Integer> sHashMap) {
        for (int i = 0; i < s.length(); i++) {
            if (!sHashMap.containsKey(s.charAt(i))) {
                sHashMap.put(s.charAt(i), 1);
            } else {
                Integer count = sHashMap.get(s.charAt(i));
                count++;
                sHashMap.put(s.charAt(i), count);
            }

        }
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        ValidAnagram validAnagram = new ValidAnagram();

        boolean anagram = validAnagram.isAnagram(s, t);
        System.out.println("anagram = " + anagram);
        System.out.println("anagram2 = " + validAnagram.isAnagramSort(s,t));


    }
}
