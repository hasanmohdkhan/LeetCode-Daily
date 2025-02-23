package strivers.binarysearch.lec2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 25-Jun-24
 * @Description : <a href="">link</a>
 */
public class KthMissingPositiveNumber {

    public int findKthPositiveBrute(int[] arr, int k) {
        for (int j : arr) if (j <= k) k++;
        return k;
    }

    public int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2; // it will act as index here
            //2, 3, 4, 7, 11 -> 0,1,2,3,4
            int missing = arr[mid] - (mid + 1);
            if (missing < k) start = mid + 1;
            else end = mid - 1;
        }

       // return start+k;
        return end+k+1;
    }

    public static void main(String[] args) {
        KthMissingPositiveNumber k = new KthMissingPositiveNumber();
        System.out.println("k = " + k.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println("k = " + k.findKthPositive(new int[]{1, 2, 3, 4}, 2));
        System.out.println("k = " + k.findKthPositive(new int[]{1, 2}, 1));
    }
}
