package strings.easy;

import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 31-Oct-23
 * @Description : <a href="https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/description/">link</a>
 */
public class CheckIfAStringIsAnAcronymOfWords {

    public boolean isAcronym(List<String> words, String s) {
        StringBuilder str = new StringBuilder();
        for (String word : words) {
            str.append(word.charAt(0));
        }
        return str.toString().equals(s);
    }

    public static void main(String[] args) {
        String[] words = {"alice", "bob", "charlie"};
        String s = "abc";

        String[] words2 = {"an","apple"};
        String s2 = "a";

        CheckIfAStringIsAnAcronymOfWords acronym = new CheckIfAStringIsAnAcronymOfWords();
        System.out.println("acronym = " + acronym.isAcronym(List.of(words), s));
        System.out.println("acronym = " + acronym.isAcronym(List.of(words2), s2));


    }
}
