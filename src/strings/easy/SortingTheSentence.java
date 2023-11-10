package strings.easy;

import java.util.HashMap;

/**
 * @Auther : hasan.khan
 * @Created : 30-Oct-23
 * @Description : <a href="https://leetcode.com/problems/sorting-the-sentence/submissions/">link</a>
 */
public class SortingTheSentence {
    public String sortSentence(String s) {
        String[] split = s.split(" ");

        HashMap<String, String> hashMap = new HashMap<>();

        for (String currStr : split) {
            char lastChar = currStr.charAt(currStr.length() - 1);
            hashMap.put(String.valueOf(lastChar), currStr.substring(0, currStr.length() - 1));
        }

       // System.out.println("hashMap = " + hashMap);

        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= hashMap.size(); i++) {
            if(i!= hashMap.size()) str.append(hashMap.get(String.valueOf(i))).append(" ");
            else str.append(hashMap.get(String.valueOf(i)));
        }

        return str.toString();

    }

    public static void main(String[] args) {
        SortingTheSentence sentence = new SortingTheSentence();
        System.out.println("sentence = " + sentence.sortSentence("is2 sentence4 This1 a3") +".");

    }
}
