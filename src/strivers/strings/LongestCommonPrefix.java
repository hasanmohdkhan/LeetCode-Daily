package strivers.strings;

/**
 * @Auther : hasan.khan
 * @Created : 17-Sep-24
 * @Description : <a href="https://leetcode.com/problems/longest-common-prefix/description/">link</a>
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            for (String s : strs) {
                if (i == s.length() || s.charAt(i) != str.charAt(i)) return sb.toString();
            }
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        LongestCommonPrefix p = new LongestCommonPrefix();
        System.out.println("p = " + p.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println("p = " + p.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
