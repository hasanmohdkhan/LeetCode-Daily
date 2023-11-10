package neetcodeAll.slidingWindow;

/**
 * @Auther : hasan.khan
 * @Created : 04-Nov-23
 * @Description : <a href="https://leetcode.com/problems/longest-repeating-character-replacement/description/">link</a>
 */
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int ans = 0;
        int max = 0;
        int left = 0;
        int[] arr = new int[26]; // for alphabet count storing


        for (int right = 0; right < s.length(); right++) {
            arr[s.charAt(right) - 'A']++;
            max = Math.max(max, arr[s.charAt(right) - 'A']);

            //check window validation
            if (right - left - max > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left);
        }


        return ans;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement res = new LongestRepeatingCharacterReplacement();
        //  System.out.println("res = " + res.characterReplacement("ABAB", 2));
        System.out.println("res = " + res.characterReplacement("AABABBA", 1));
    }
}
