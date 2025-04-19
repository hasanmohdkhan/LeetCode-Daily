package strivers.bitmanipulation.misc;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 08-Apr-25
 * @Description : <a href="">link</a>
 */
public class CountPairsOfSimilarStrings {

    public int similarPairs(String[] words) {
        int res = 0;
        int[] freq = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                mask |= 1 << (c - 'a');
                // (c - 'a') gives the index of the character in the alphabet (0 for 'a', 25 for 'z')
                // 1 << (c - 'a') sets the corresponding bit for that character
                // |= adds the bit to the mask (i.e., marks the character as present)
                System.out.println("mask = " + Integer.toBinaryString(mask));
            }
            System.out.println();
            freq[i] = mask;

        }
        System.out.println("freq = " + Arrays.toString(freq));

        for (int i = 0; i < freq.length; i++) {
            for (int j = i + 1; j < freq.length; j++) if (freq[i] == freq[j]) res++;
        }


        return res;
    }

    public static void main(String[] args) {
        CountPairsOfSimilarStrings s = new CountPairsOfSimilarStrings();
        System.out.println("s = " + s.similarPairs(new String[]{"aba", "aabb", "abcd", "bac", "aabc", "akxz", "akxxz"}));
    }

}
