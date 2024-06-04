package strivers.sorting.sort2;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 03-Mar-24
 * @Description : <a href="">link</a>
 */
public class InsertionSortRecursive {

    public static void insertionSort(int[] arr, int size) {
        insertionSort(arr, 0, size);
    }


    public static void insertionSort(int[] arr, int i, int n) {
        if (i == n) return;
        int j = i;

        while (j > 0 && arr[j - 1] > arr[j]) {
            int temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
            j--;
        }

        insertionSort(arr, i + 1, n);
    }

    public static void main(String[] args) {
        int[] a = {2, 13, 4, 1, 3, 6, 28};
        System.out.println("a = " + Arrays.toString(a));
        insertionSort(a, a.length - 1);
        System.out.println("a = " + Arrays.toString(a));
    }
}
