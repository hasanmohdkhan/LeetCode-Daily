package strivers.binarysearch.practice;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Auther : hasan.khan
 * @Created : 30-Aug-24
 * @Description : <a href="https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/description/">link</a>
 */
public class CompareStringsByFrequencySmallestCharacter {
    public int[] numSmallerByFrequencyBrute(String[] queries, String[] words) {
        int[] wordCount = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int val = 0;
            int frequency = frequency(q);
            for (String word : words) {
                if (frequency < frequency(word)) {
                    val++;
                }
                wordCount[i] = val;
            }
        }

        return wordCount;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        // find the freq and store the result in array in sorted order
        int[] wordFreq = new int[words.length];
        int idx = 0;
        for (String s : words) {
            wordFreq[idx++] = f(s);
        }
        Arrays.sort(wordFreq);

        for (int i = 0; i < queries.length; i++) {
            int frequency = f(queries[i]);
            ans[i] = bs(wordFreq, frequency);
        }


        return ans;
    }

    private int bs(int[] wordFreq, int frequency) {
        int low = 0;
        int high = wordFreq.length -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (wordFreq[mid] <= frequency) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return wordFreq.length - low;
    }

    private int f(String q) {
        int count = 0;
        char smallestChar = 'z'+1;

        for (char c : q.toCharArray()) {
            if(c== smallestChar){
                count++;
            } else if (c < smallestChar) {
                smallestChar = c;
                count=1;
            }

        }

        return count;
    }

    private int frequency(String q) {
        int count = 0;
        char[] array = q.toCharArray();
        Arrays.sort(array);
        for (char c : array) {
            if (array[0] == c) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        CompareStringsByFrequencySmallestCharacter s = new CompareStringsByFrequencySmallestCharacter();
        System.out.println("s = " + Arrays.toString(s.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"})));
        System.out.println("s = " + Arrays.toString(s.numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"})));

        System.out.println("s = " + s.bs(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 6));


    }

}
