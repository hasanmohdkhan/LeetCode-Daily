package strivers.sorting;

/**
 * @Auther : hasan.khan
 * @Created : 27-Feb-24
 * @Description : <a href="">link</a>
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr, int n) {

        int length = arr.length;

        for (int i = length; i >= 0; i--) {
            for (int j = 0; j < length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

      //  System.out.println("arr = " + Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int[] a = {2, 13, 4, 1, 3, 6, 28};
        bubbleSort(a, 7);
    }
}
