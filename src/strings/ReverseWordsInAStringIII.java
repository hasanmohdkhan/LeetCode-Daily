package strings;

/**
 * @Auther : hasan.khan
 * @Created : 05-Nov-23
 * @Description : <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/">link</a>
 */
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();

        String[] split = s.split(" ");

      //  System.out.println("split = " + Arrays.toString(split));
        for (String string : split) {
            str.append(new StringBuilder(string).reverse());
            str.append(" ");
        }

       // System.out.println("str = " + str);

        return  str.substring(0, str.length()-1);

    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        ReverseWordsInAStringIII o = new ReverseWordsInAStringIII();
        System.out.println("o = " + o.reverseWords(s)+".");
    }
}
