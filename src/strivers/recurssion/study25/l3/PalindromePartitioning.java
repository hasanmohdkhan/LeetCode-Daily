package strivers.recurssion.study25.l3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 13-Feb-25
 * @Description : <a href="https://leetcode.com/problems/palindrome-partitioning/description/">link</a>
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backTracking(0, new ArrayList<>(), res, s);
        return res;
    }

    private void backTracking(int idx, List<String> path, List<List<String>> res, String s) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalinedrome(s, idx, i)) {
                path.add(s.substring(idx, i + 1));
                backTracking(i + 1, path, res, s);
                path.remove(path.size() - 1);
            }
        }


    }

    private boolean isPalinedrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning s = new PalindromePartitioning();
        System.out.println("s = " + s.partition("aab"));
        System.out.println("s = " + s.partition("a"));
    }
}
