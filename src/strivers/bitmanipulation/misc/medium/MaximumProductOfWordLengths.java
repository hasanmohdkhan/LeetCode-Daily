package strivers.bitmanipulation.misc.medium;

/**
 * @Auther : hasan.khan
 * @Created : 27-May-25
 * @Description : <a href="https://leetcode.com/problems/maximum-product-of-word-lengths/?envType=problem-list-v2&envId=bit-manipulation">link</a>
 */
public class MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {
        int[] bit = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (int s : words[i].toCharArray()) bit[i] |= 1 << (s - 'a');
        }


        int max = Integer.MIN_VALUE;

        for (int i = 0; i < bit.length; i++) {
            for (int j = i + 1; j < bit.length; j++) {
                if ((bit[i] & bit[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }

        }

        if (max == Integer.MIN_VALUE) return 0;
        else return max;
    }

    public static void main(String[] args) {
        MaximumProductOfWordLengths m = new MaximumProductOfWordLengths();
        System.out.println("m = " + m.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
    }
}
