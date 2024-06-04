package strivers.sorting;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 27-Feb-24
 * @Description : <a href="">link</a>
 */
public class InsertionSort {

    public static void insertionSort(int[] arr, int size) {

        for (int i = 0; i <= arr.length-1; i++) {
            int j = i;

            while (j > 0 && arr[j -  1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }

        }

        /*for (int i = 0; i <= size - 1; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }*/



        System.out.println("arr = " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] a = {2, 13, 4, 1, 3, 6, 28};
        insertionSort(a, 7);
    }
}
