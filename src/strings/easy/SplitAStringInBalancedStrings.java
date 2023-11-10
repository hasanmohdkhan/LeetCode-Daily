package strings.easy;

/**
 * @Auther : hasan.khan
 * @Created : 20-Oct-23
 * @Description : <a href="https://leetcode.com/problems/split-a-string-in-balanced-strings/description/">Link</a>
 */
public class SplitAStringInBalancedStrings {

    public int balancedStringSplit(String s) {
        int res = 0;
        int countL = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') countL++;
            else countL--;
            if (countL==0) res++;
        }
        return res;

    }

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        String s1 = "RLRRRLLRLL";
        String s2 = "LLLLRRRR";
        SplitAStringInBalancedStrings balancedStrings = new SplitAStringInBalancedStrings();
        System.out.println("balancedStrings = " + balancedStrings.balancedStringSplit(s));
        System.out.println("balancedStrings = " + balancedStrings.balancedStringSplit(s1));
        System.out.println("balancedStrings = " + balancedStrings.balancedStringSplit(s2));

    }
}
