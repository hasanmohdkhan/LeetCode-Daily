package strivers.recurssion.study25;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther : hasan.khan
 * @Created : 28-Feb-25
 * @Description : <a href="https://leetcode.com/problems/gray-code/description/?envType=problem-list-v2&envId=backtracking">link</a>
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        // Start with 0 as the first Gray code
        list.add(0);
        visited.add(0);

        backtrack(visited, list, n, 0);
        return list;
    }

    private boolean backtrack(Set<Integer> visited, List<Integer> list, int n, int num) {
        if (list.size() == (1 << n)) return true;

        for (int i = 0; i < n; i++) {
            int currNum = num ^ (1 << i);

            if (!visited.contains(currNum)) {
                list.add(currNum);
                visited.add(currNum);
                if (backtrack(visited, list, n, currNum)) return true;

                visited.remove(currNum);
                list.remove(list.size() - 1);
            }

        }

        return false;
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(0, 0, new StringBuilder(), n, res);
        return res;
    }

    public void backtracking(int open, int close, StringBuilder s, int n, List<String> res) {
        if (open == close && open == n) {
            res.add(s.toString());
            return;
        }

        if (open < n) {
            s.append("(");
            backtracking(open + 1, close, s, n, res);
            s.deleteCharAt(s.length() - 1);
        }

        if (close < open) {
            s.append(")");
            backtracking(open, close + 1, s, n, res);
            s.deleteCharAt(s.length() - 1);
        }

    }

    public static void main(String[] args) {
        GrayCode s = new GrayCode();
        System.out.println("s = " + s.grayCode(2));
        System.out.println("s = " + s.grayCode(1));


        System.out.println("s = " + s.generateParenthesis(3));
    }
}
