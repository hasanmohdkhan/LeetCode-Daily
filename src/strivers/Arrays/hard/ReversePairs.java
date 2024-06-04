package strivers.Arrays.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 01-Jun-24
 * @Description : <a href="">link</a>
 */
public class ReversePairs {


    public static int mergeSort(int[] arr, int low, int high) {
        // break condition
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2;

        cnt += mergeSort(arr, low, mid);//right
        cnt += mergeSort(arr, mid + 1, high);//left
        cnt += reversePairs(arr, low, mid, high);

        merge(arr, low, mid, high);
        return cnt;
    }

    private static int reversePairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;

        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long)arr[i] > 2 * (long)arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;

    }

    private static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

      //  int cnt = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }


        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }


        //  System.out.println("temp = " + temp);

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

    }


    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
         // int[] a = {8, 5, 1, 4, 0, 40, 1, 3, 7, 3};
        //  int[] a = {1,3,2,3,1};
          int[] a = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
       // int[] a = {2, 4, 3, 5, 1};
        ReversePairs reversePairs = new ReversePairs();
        int cnt = reversePairs.reversePairs(a);

        System.out.println("cnt = " + cnt);
    }

}
