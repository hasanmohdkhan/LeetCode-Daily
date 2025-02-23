package strivers.strings.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 09-Oct-24
 * @Description : <a href="https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/">link</a>
 */
public class SumOfBeautyOfAllSubstrings {

    public int beautySum(String s) {

        int totalBeauty = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> freqMap = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                freqMap.put(s.charAt(j), freqMap.getOrDefault(s.charAt(j), 0) + 1);
                int maxFreq = Integer.MIN_VALUE;
                int minFreq = Integer.MAX_VALUE;


                for (Map.Entry<Character, Integer> e : freqMap.entrySet()) {
                    //  System.out.println("e = " + e);
                    int freq = e.getValue();
                    maxFreq = Math.max(freq, maxFreq);
                    minFreq = Math.min(freq, minFreq);
                }

                // System.out.println("minFreq = " + minFreq + " max = " + maxFreq);
                totalBeauty += (maxFreq - minFreq);
            }


        }


        return totalBeauty;
    }

    public static void main(String[] args) {
        SumOfBeautyOfAllSubstrings s = new SumOfBeautyOfAllSubstrings();
        System.out.println("s = " + s.beautySum("aabcb"));
        System.out.println("s = " + s.beautySum("aabcbaa"));
    }

}
