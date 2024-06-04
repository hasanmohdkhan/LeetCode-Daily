package strivers.Arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther : hasan.khan
 * @Created : 26-Mar-24
 * @Description : <a href="">link</a>
 */
public class LongestSequence {

    public static int longestSuccessiveElements(int[] a) {
        int lastSmaller = Integer.MIN_VALUE;

        if (a.length == 0) return 0;

        int max = 0;
        int count = 0;

        Arrays.sort(a);
        /// System.out.println("a = " + Arrays.toString(a));

        for (int j : a) {

            if (j - 1 == lastSmaller) {

                count += 1;
                lastSmaller = j;
            } else if (j != lastSmaller) {

                count = 1;
                lastSmaller = j;
            }
            max = Math.max(count, max);

        }

        return max;
    }

    //optimal solution
    public static int longestSuccessiveElementsUsingSet(int[] a) {
        int longest = 0;

        Set<Integer> set = new HashSet<>();

        for (int j : a) set.add(j);


        for (int it : set) {
            if (!set.contains(it - 1)) { // starting points
                int count = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    count++;
                }
                longest = Math.max(longest, count);

            }


        }

        return longest;
    }


    public static void main(String[] args) {
        int[] a = {5, 8, 3, 2, 1, 4};
        int[] b = {15, 6, 2, 1, 16, 4, 2, 29, 9, 12, 8, 5, 14, 21, 8, 12, 17, 16, 6, 26, 3};

        // System.out.println("longestSuccessiveElements() = " + longestSuccessiveElements(a));
        // System.out.println("longestSuccessiveElements() = " + longestSuccessiveElements(b));

        System.out.println("longestSuccessiveElements() = " + longestSuccessiveElementsUsingSet(a));
        System.out.println("longestSuccessiveElements() = " + longestSuccessiveElementsUsingSet(b));
    }
}
