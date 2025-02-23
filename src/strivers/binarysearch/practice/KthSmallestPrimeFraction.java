package strivers.binarysearch.practice;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 20-Aug-24
 * @Description : <a href="https://leetcode.com/problems/k-th-smallest-prime-fraction/">link</a>
 */
public class KthSmallestPrimeFraction {

    public int[] kthSmallestPrimeFractionBruteForce(int[] arr, int k) {
        if (arr.length == 2) return arr;

        List<int[]> a = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                a.add(new int[]{arr[i], arr[j]});
            }
        }

       /* Collections.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Double.compare((double)a[0] / a[1], (double)b[0] / b[1]);
            }
        });*/

        a.sort(Comparator.comparingDouble(a2 -> (double) a2[0] / a2[1]));


        return a.get(k - 1);
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double low = 0.0;
        double high = 1.0;

        while (low <= high) {
            double mid = (low + high) / 2.0;
            int[] result = getResult(arr, n, mid);

            if (result[0] == k) return new int[]{arr[result[1]], arr[result[2]]};

            else if (result[0] < k) {
                low = mid;
            } else high = mid;

        }

        return null;
    }

    /**
     *  We can perform a binary search on the possible values of the fractions (between 0 and 1).
     *  For each mid-point mid in this range, we'll count how many fractions are less than or equal to mid
     * and also keep track of the largest fraction that is less than or equal to mid.
     * <h1> Count Fractions Using a Two-Pointer Approach: <h1>
     *  For each value of mid in the binary search, use a two-pointer approach to count how many
     *  fractions arr[i] / arr[j] are less than or equal to mid. If the count is less than k,
     *  move the search to the right; otherwise, move the search to the left.
     */
    private static int[] getResult(int[] arr, int n, double mid) {
        double maxFraction = 0.0;
        int maxI = 0;
        int maxJ = 0;
        int count = 0;

        int j = 1; // Pointer for denominator

        for (int i = 0; i < n - 1; i++) {// Pointer for numerator
            // Move the denominator pointer j as far right as possible while fraction arr[i] / arr[j] <= mid
            while (j < n && (double) arr[i] / arr[j] > mid) j++;
            count += n - j;

            if (j < n && (double) arr[i] / arr[j] > maxFraction) {
                maxFraction = (double) arr[i] / arr[j];
                maxI = i;
                maxJ = j;
            }
        }
        return new int[]{count, maxI, maxJ};
    }

    public static void main(String[] args) {
        KthSmallestPrimeFraction k = new KthSmallestPrimeFraction();
        System.out.println("k = " + Arrays.toString(k.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
        System.out.println("k = " + Arrays.toString(k.kthSmallestPrimeFraction(new int[]{1, 7}, 1)));
    }
}
