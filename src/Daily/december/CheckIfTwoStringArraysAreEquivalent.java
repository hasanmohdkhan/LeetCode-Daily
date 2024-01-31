package Daily.december;

/**
 * @Auther : hasan.khan
 * @Created : 01-Dec-23
 * @Description : <a href="https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/?envType=daily-question&envId=2023-12-01">link</a>
 */
public class CheckIfTwoStringArraysAreEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (String s : word1) {
            s1.append(s);
        }

        for (String s : word2) {
            s2.append(s);
        }


        return s1.toString().contentEquals(s2);

    }

    public static void main(String[] args) {
        String[] word1 = {"ab", "c"}, word2 = {"a", "bc"};
        CheckIfTwoStringArraysAreEquivalent r = new CheckIfTwoStringArraysAreEquivalent();
        System.out.println("r = " + r.arrayStringsAreEqual(word1, word2));
    }

}
