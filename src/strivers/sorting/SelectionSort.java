package strivers.sorting;

/**
 * @Auther : hasan.khan
 * @Created : 27-Feb-24
 * @Description : <a href="">link</a>
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int indx = i;

            for (int j = indx; j < arr.length ; j++) {
                    if(arr[j] < arr[indx]){
                        indx = j;
                    }

            }

            int temp = arr[i];
            arr[i] = arr[indx];
            arr[indx] = temp;

        }

       // System.out.println("arr = " + Arrays.toString(arr));

    }

    public static void main(String[] args) {
        int[] a = {8, 6, 2, 5, 1};
        selectionSort(a);

    }
}
