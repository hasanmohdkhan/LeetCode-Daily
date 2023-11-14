package neet150.SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Auther : hasan.khan
 * @Created : 10-Nov-23
 * @Description : <a href="https://leetcode.com/problems/permutation-in-string/description/">link</a>
 */
public class PermutationInString {

    /**
     * @param s1 sting to be checked
     * @param s2  input
     * @return permutation-in-string
     */
    public boolean checkInclusionSlidingWindow(String s1, String s2) {
       /*  int left =0;
         int right =0;*/
         int window = s1.length();
      //  System.out.println("window = " + window);
        HashMap<Character ,Integer> key = new HashMap<>();
        insertIntoMap(s1, key);

        /* while (left < s2.length() && right <s2.length()){
             HashMap<Character ,Integer> wind = new HashMap<>();
             insertIntoMap(s2.substring(left, right), wind);
             System.out.println("wind = " + wind);
             System.out.println("wind = " + s2.substring(left, right));
             if(key.equals(wind)) return true;
             if(right - left  == window) left++;

             right++;
         }*/


        for (int i = 0; i < s2.length() - window +1; i++) {
            StringBuilder currStr = new StringBuilder();
            for (int j = i; j < i+window ; j++) {
               // System.out.println("-> = " + s2.charAt(j));
                currStr.append(s2.charAt(j));
            }
            HashMap<Character ,Integer> wind = new HashMap<>();
            insertIntoMap(currStr.toString(), wind);
            if(key.equals(wind)) return true;
          //  System.out.println("currStr = " + currStr);
          //  System.out.println("-> = end");
        }


        return false;
    }

    public boolean checkInclusion(String s1, String s2) {
        int window = s1.length();
        int[] check = new int[26];
        int[] input = new int[26];

        for (int i = 0; i < s1.length(); i++) check[s1.charAt(i) - 'a']++;

        for (int i = 0; i < s2.length(); i++) input[s2.charAt(i)- 'a']++;

        for (int i = 0; i < s2.length() - window; i++) {
            //if

        }

        System.out.println("check = " + Arrays.toString(check));

        System.out.println("input = " + Arrays.toString(input));


        return false;
    }

    private static void insertIntoMap(String s1, HashMap<Character, Integer> key) {
        for (int i = 0; i < s1.length(); i++) {
            key.put(s1.charAt(i), key.getOrDefault(s1.charAt(i), 0)+1);
        }
    }


    public static void main(String[] args) {
        PermutationInString ans = new PermutationInString();
        System.out.println("ans = " + ans.checkInclusion( "ab", "eidbaooo"));
       /* System.out.println("ans = " + ans.checkInclusion("a", "ab"));
        System.out.println("ans = " + ans.checkInclusion("hello", "ooolleoooleh"));
        System.out.println("ans = " + ans.checkInclusion("adc", "dcda"));*/

    }
}
