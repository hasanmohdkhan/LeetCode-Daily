package strivers.recurssion.study25.pattern;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Auther : hasan.khan
 * @Created : 08-Feb-25
 * @Description : <a href="">link</a>
 */
public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        if (nums.length == 0) return "";
        int n = nums.length;
        Set<String> numsSet = new HashSet<>();
        for (String s : nums) numsSet.add(s);
        char[] chars = new char[n];
        return backtracking(chars, 0, numsSet);

    }

    private String backtracking(char[] s, int idx, Set<String> numSet) {
        if (idx == s.length) {
            String bin = new String(s);
            return numSet.contains(bin) ? "" : bin;
        }

        s[idx] = '1';
        String s1 = backtracking(s,  idx + 1, numSet);
        if (!s1.isEmpty()) return s1;

        s[idx] = '0';
        return backtracking(s, idx + 1, numSet);

    }

    public static void main(String[] args) {
        FindUniqueBinaryString s = new FindUniqueBinaryString();
        System.out.println("s = " + s.findDifferentBinaryString(new String[]{"01", "10"}));
        System.out.println("s = " + s.findDifferentBinaryString(new String[]{"00", "01"}));
        System.out.println("s = " + s.findDifferentBinaryString(new String[]{"111", "011", "001"}));
    }

}
