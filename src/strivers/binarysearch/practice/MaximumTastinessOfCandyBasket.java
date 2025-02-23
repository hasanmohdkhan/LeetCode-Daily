package strivers.binarysearch.practice;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 26-Aug-24
 * @Description : <a href="">link</a>
 */
public class MaximumTastinessOfCandyBasket {

    public int maximumTastinessMy(int[] price, int k) {
        int max = Integer.MAX_VALUE;
        Arrays.sort(price);
        System.out.println("price = " + Arrays.toString(price));

        if (price.length == 2) return Math.abs(price[0] - price[1]);

        for (int i = 0; i < price.length; i++) {
            int j = i;
            for (int l = 1; l <= k; l++) {
                // System.out.println("l = " + price[l]);
                if (j < (price.length - k)) {
                    System.out.println("l = " + price[j]);
                    j++;
                }
            }
            System.out.println(" == ");

        }



        /*for (int i = price.length - 1 ; i >= (price.length -k)  ; i--) {
            max = Math.min(Math.abs(price[i] - price[i-1]) , max);
        }*/
        //19

        return max;
    }

    public int maximumTastinessBrute(int[] price, int k) {
        Arrays.sort(price); // Sort the prices array
        int maxTastiness = 0; // Initialize maximum tastiness to 0

        // Loop over every possible subarray of length k
        for (int i = 0; i <= price.length - k; i++) {
            int minDifference = Integer.MAX_VALUE;

            // Calculate the minimum difference within this subarray of length k
            for (int j = i + 1; j < i + k; j++) {
                minDifference = Math.min(minDifference, price[j] - price[j - 1]);
            }

            // Update maximum tastiness
            maxTastiness = Math.max(maxTastiness, minDifference);
        }

        return maxTastiness;
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int low = 0;
        int high = price[price.length - 1];
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canFormBasket(price, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canFormBasket(int[] price, int k, int minDiff) {
        int count = 1;
        int last = price[0];

        for (int i = 1; i < price.length; i++) {
            if (price[i] - last >= minDiff) {
                count++;
                last = price[i];
            }
        }

        return count >= k;
    }

    public static void main(String[] args) {
        MaximumTastinessOfCandyBasket s = new MaximumTastinessOfCandyBasket();
        System.out.println("s = " + s.maximumTastiness(new int[]{13, 5, 1, 8, 21, 2}, 3));
        System.out.println("s = " + s.maximumTastiness(new int[]{1, 3, 1}, 2));
        System.out.println("s = " + s.maximumTastiness(new int[]{7, 7, 7, 7}, 2));
       /* System.out.println("s = " + s.maximumTastiness(new int[]{13,5,1,8,21,2}, 3));
        System.out.println("s = " + s.maximumTastiness(new int[]{1,3,1}, 2));
        System.out.println("s = " + s.maximumTastiness(new int[]{7,7,7,7}, 2));
        System.out.println("s = " + s.maximumTastiness(new int[]{7,7,7}, 2));
        System.out.println("s = " + s.maximumTastiness(new int[]{7,7}, 2));*/
        System.out.println("s = " + s.maximumTastiness(new int[]{34, 116, 83, 15, 150, 56, 69, 42, 26}, 6));
    }

}
