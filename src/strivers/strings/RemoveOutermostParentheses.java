package strivers.strings;

/**
 * @Auther : hasan.khan
 * @Created : 08-Sep-24
 * @Description : <a href="https://leetcode.com/problems/remove-outermost-parentheses/description/">link</a>
 */
public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {  // (,(,), (, ), ), (,(, ), ),
            if ('(' == c) {
                if (count > 0) sb.append(c);
                count++;
            }
            if (')' == c) {
                if (count > 1) sb.append(c);
                count--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveOutermostParentheses s = new RemoveOutermostParentheses();
        System.out.println("s = " + s.removeOuterParentheses("(()())(())"));
        System.out.println("s = " + s.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println("s = " + s.removeOuterParentheses("()()"));
        System.out.println("s = " + s.removeOuterParentheses("(())()"));

    }
}
