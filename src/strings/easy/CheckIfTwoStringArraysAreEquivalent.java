package strings.easy;

/**
 * @Auther : hasan.khan
 * @Created : 25-Oct-23
 * @Description : <a href="https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/">link</a>
 */
public class CheckIfTwoStringArraysAreEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str = new StringBuilder(word1.length);
        StringBuilder str2 = new StringBuilder(word2.length);

        for (String s : word1) {
            str.append(s);
        }

        for (String s : word2) {
            str2.append(s);
        }

        return str.toString().contentEquals(str2);
    }


    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        CheckIfTwoStringArraysAreEquivalent equivalent = new CheckIfTwoStringArraysAreEquivalent();
        System.out.println("equivalent = " + equivalent.arrayStringsAreEqual(word1, word2));
    }
}
