package strivers.recurssion.study25;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 30-Jan-25
 * @Description : <a href="https://leetcode.com/problems/generate-parentheses/description/">link</a>
 */
public class generateParanthesis {

    public List<String> generateParenthesisBrute(int n) {
        List<String> list = new ArrayList<>();
        dfs("", list, n);
        return list;
    }

    private void dfs(String s, List<String> list, int n) {
        if (n * 2 == s.length()) {
            if (isValid(s)) list.add(s);
            return;
        }
        dfs(s + ")", list, n);
        dfs(s + "(", list, n);
    }

    public static boolean isValid(String s) {
        int open = 0;
        for (char c : s.toCharArray()) {
            open += c == '(' ? 1 : -1;
            if (open < 0) return false;
        }
        return open == 0;
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        backtracking(0, 0, list, n, s);
        return list;
    }

    private void backtracking(int open, int close, List<String> list, int n, StringBuilder stack) {
        if (open == close && open == n) {
            list.add(stack.toString());
            return;
        }

        if (open < n) {
            stack.append("(");
            backtracking(open + 1, close, list, n, stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        if (close < open) {
            stack.append(")");
            backtracking(open, close + 1, list, n, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }


    public static void main(String[] args) {
        generateParanthesis s = new generateParanthesis();
        System.out.println("s = " + s.generateParenthesis(1));
        System.out.println("s = " + s.generateParenthesis(3));

    }

}
