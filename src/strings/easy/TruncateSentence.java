package strings.easy;

/**
 * @Auther : hasan.khan
 * @Created : 24-Oct-23
 * @Description : <a href="https://leetcode.com/problems/truncate-sentence/">link</a>
 */
public class TruncateSentence {

    public String truncateSentence(String s, int k) {
        StringBuilder builder = new StringBuilder();
        String regex = " ";
        String[] split = s.split(regex);
      //  System.out.println("split = " + Arrays.toString(split));

        for (int i = 1; i <= k; i++) {
            builder.append(split[i-1]);
            // System.out.println("i = " + i+ " w:"+split[i-1]);
            if(i!=k) builder.append(regex);
        }


        return builder.toString();
    }


    public static void main(String[] args) {
       /* String s = "Hello how are you Contestant";
        int k = 4;  */
        String s = "chopper is not a tanuki";
        int k = 5;
        TruncateSentence sentence = new TruncateSentence();
        System.out.println("sentence = .." + sentence.truncateSentence(s, k) +".");
    }
}
