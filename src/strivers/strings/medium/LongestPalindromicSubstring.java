package strivers.strings.medium;

/**
 * @Auther : hasan.khan
 * @Created : 06-Oct-24
 * @Description : <a href="https://leetcode.com/problems/longest-palindromic-substring/description/">link</a>
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i); //check even palindrome length
            int len2 = expandFromCenter(s, i, i + 1);  // check odd palindrome length
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }


        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int left, int right) {
     //racecar
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;   // Move left pointer outwards
            right++;  // Move right pointer outwards
        }
        return right - left - 1;
     // left 0 , r =0;  c= r   -> even
     // -1      1
     // 1 -(-1) -1 = 1 ;
    // l = 0 r = 1    r != a  1- 0 -1 = 0
    // i -1
    // l =1 , r=1
    //  -1 , 2   -> 2-1-1 =0
    // l=1 r =2  2-1-1 = 0



    }


    public String longestPalindromeBrute(String s) {
        int left = 0;
        int right = s.length(); // babad
        String res = "";

        while (left < s.length()) {
            if (isPalindrome(left, right, s)) {
                // check current sub palindrome is greater then update
                if (res.length() < s.substring(left, right).length()) {
                    res = s.substring(left, right);
                    left++;
                    right = s.length();
                    continue;
                }
            } else {
                right--;
            }

            if (right == left) {
                right = s.length();
                left++;
            }
        }
        System.out.println("res = " + res);

        return res;
    }

    private boolean isPalindrome(int left, int right, String s) {
        String substring = s.substring(left, right);
        System.out.println("substring = " + substring);
        StringBuilder sub = new StringBuilder(substring);
        return substring.contentEquals(sub.reverse());
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring s = new LongestPalindromicSubstring();
        System.out.println("s = " + s.longestPalindrome("babad"));
        System.out.println("s = " + s.longestPalindrome("cbbd"));
    }
}
