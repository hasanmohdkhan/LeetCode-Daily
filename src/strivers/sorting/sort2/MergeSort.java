package strivers.sorting.sort2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 27-Feb-24
 * @Description : <a href="">link</a>
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int low, int high) {
       // System.out.println("low = " + low + "  high " + high);
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);

        // System.out.println("sorted = " + Arrays.toString(arr));

    }

    private static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }


        // only left array has elements now
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // only right array has elements now
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }


        // now put sorted value in arr
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }


    }

    public static void main(String[] args) {
        int[] a = {2, 13, 4, 1, 3, 6, 28};
        System.out.println("a = " + Arrays.toString(a));
        mergeSort(a, 0, a.length - 1);
        System.out.println("sorted = " + Arrays.toString(a));
    }
}
