package strivers.sorting.sort2;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 03-Mar-24
 * @Description : <a href="">link</a>
 */
public class QuickSort {
    public static void quickSort(int[] input, int low, int high) {

        if (low < high) {

            int pIndex = partition(input, low, high);

            quickSort(input, low, pIndex - 1); // left array

            quickSort(input, pIndex + 1, high); //  right array

        }


    }

    private static int partition(int[] arr, int low, int high) {
        int p = arr[low];
        int i = low;
        int j = high;


        while (i < j) {

            while (arr[i] <= p && i <= high - 1) {
                i++;
            }

            while (arr[j] > p && j >= low + 1) {
                j--;
            }

            // swipe the current iteration index elements
            // only swiping low values i.e., only left array
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }

//        System.out.println("b s = " + Arrays.toString(arr));
//        System.out.println("i = " + i + " , v = "+arr[i]);
//        System.out.println("j = " + j + " , v = "+arr[j]);

        // swiping right array
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

       // System.out.println("a s = " + Arrays.toString(arr));

        return j;
    }

    public static void main(String[] args) {
        int[] a = {2, 13, 4, 1, 3, 6, 28};
        System.out.println("a = " + Arrays.toString(a));
        quickSort(a, 0, a.length - 1);
        System.out.println("a = " + Arrays.toString(a));
    }
}
