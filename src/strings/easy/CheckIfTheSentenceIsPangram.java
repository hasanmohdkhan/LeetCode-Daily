package strings.easy;

import java.util.HashMap;

/**
 * @Auther : hasan.khan
 * @Created : 28-Oct-23
 * @Description : <a href="https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/">link</a>
 */
public class CheckIfTheSentenceIsPangram {

    public boolean checkIfPangram(String sentence) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < sentence.length(); i++) {
            hashMap.put(sentence.charAt(i), 1);
        }
        return hashMap.size() == 26;
    }

    public static void main(String[] args) {
        CheckIfTheSentenceIsPangram pangram = new CheckIfTheSentenceIsPangram();
        System.out.println("pangram = " + pangram.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println("pangram = " + pangram.checkIfPangram("leetcode"));
    }
}
