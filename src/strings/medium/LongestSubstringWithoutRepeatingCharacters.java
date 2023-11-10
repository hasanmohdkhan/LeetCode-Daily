package strings.medium;

import java.util.HashSet;

/**
 * @Auther : hasan.khan
 * @Created : 25-Oct-23
 * @Description : <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description/">link</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {


    /**
     * Brute force solution
     *
     * @param s string
     * @return non-repeated string length
     */
    public int lengthOfLongestSubstringBruteForce(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                //   System.out.println("j = " + s.substring(i,j));
                if (isUnique(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }

            }
        }


        return res;
    }


    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int j = 0;
        int maxLength=0;
        for (int i = 0; i < s.length(); i++) {
            char rightChar = s.charAt(i);
            chars[rightChar]++;

            while (chars[rightChar] > 1) {
                char leftChar = s.charAt(j);
                chars[leftChar]--;
                j++;
            }

            maxLength = Math.max(i-j+1, maxLength);

        }

      //  System.out.println("chars = " + Arrays.toString(chars));


        return maxLength;

    }


    public void TestWidow(int[] nums) {
        int windowSize = 3;
        for (int i = 0; i < nums.length - windowSize + 1; i++) {
            for (int j = i; j < i + windowSize; j++) {
                System.out.print(" " + nums[j]);
            }
            System.out.println();
        }

    }

    public boolean isUnique(String s, int start, int end) {
        //  System.out.println("s.length() = " + s.substring(start,end).length());
        if (s.substring(start, end).isEmpty()) return false;
        HashSet<Character> set = new HashSet<>();

        for (int i = start; i <= end; i++) {
            if (set.contains(s.charAt(i))) return false;
            set.add(s.charAt(i));
        }
        //  System.out.println("set = " + set);
        return true;
    }


    public static void main(String[] args) {
        String s = "bbbbb";
        String s1 = "abcabcbb";
        String s2 = "pwwkew";
        LongestSubstringWithoutRepeatingCharacters repeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println("repeatingCharacters = " + repeatingCharacters.lengthOfLongestSubstring(s));
        System.out.println("repeatingCharacters = " + repeatingCharacters.lengthOfLongestSubstring(s1));
        // System.out.println("repeatingCharacters = " + repeatingCharacters.lengthOfLongestSubstring(s2));

        int[] ar = {1, 2, 3, 4, 5};
        // System.out.println("ar = " + Arrays.toString(ar));
        // repeatingCharacters.TestWidow(ar);

    }
}
