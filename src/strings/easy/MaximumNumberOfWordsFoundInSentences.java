package strings.easy;

/**
 * @Auther : hasan.khan
 * @Created : 19-Oct-23
 * @Description : <a href="https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/">Link</a>
 */
public class MaximumNumberOfWordsFoundInSentences {

    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (String sentence : sentences) {
            int currCount = sentence.split(" ").length;
            if (currCount > res) res = currCount;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] arr = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        MaximumNumberOfWordsFoundInSentences sentences = new MaximumNumberOfWordsFoundInSentences();
        System.out.println("sentences = " + sentences.mostWordsFound(arr));
    }
}
