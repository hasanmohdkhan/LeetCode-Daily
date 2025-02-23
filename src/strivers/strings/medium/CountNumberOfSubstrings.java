package strivers.strings.medium;

import java.util.HashMap;

/**
 * @Auther : hasan.khan
 * @Created : 05-Oct-24
 * @Description : <a href="https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=count-number-of-substrings">link</a>
 */
public class CountNumberOfSubstrings {

    long substrCount(String S, int K) {
        return atMostK(S, K) - atMostK(S, K - 1);
    }

    private long atMostK(String s, int k) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {
            // add characters to freq
            freqMap.put(s.charAt(right), freqMap.getOrDefault(s.charAt(right), 0) + 1);

            // if we exceed K distinct characters shrink window
            while (freqMap.size() > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);

                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }
            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        CountNumberOfSubstrings s = new CountNumberOfSubstrings();
        System.out.println("s = " + s.substrCount("aba", 2));
        System.out.println("s = " + s.substrCount("abaaca", 1));
    }
}
