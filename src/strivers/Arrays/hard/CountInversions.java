package strivers.Arrays.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 01-Jun-24
 * @Description : <a href="">link</a>
 */
public class CountInversions {


    public static long mergeSort(long[] arr, int low, int high) {
        // break condition
        long cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2;

        cnt += mergeSort(arr, low, mid);//right
        cnt += mergeSort(arr, mid + 1, high);//left
        cnt += merge(arr, low, mid, high);
        return cnt;
    }

    private static long merge(long[] arr, int low, int mid, int high) {
        List<Long> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        long cnt = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1);
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


        System.out.println("temp = " + temp);

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return cnt;
    }

    static long inversionCount(long[] a, long n) {
        // Count the number of pairs:
        return mergeSort(a, 0, (int) (n - 1));
    }

    public static void main(String[] args) {
        //  int[] a = {8, 5, 1, 4, 0, 40, 1, 3, 7, 3};
        long[] a = {2, 4, 1, 3, 5};
        long cnt = inversionCount(a, a.length);

        System.out.println("cnt = " + cnt);
    }

}
