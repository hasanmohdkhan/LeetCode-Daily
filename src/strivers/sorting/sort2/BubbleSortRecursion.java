package strivers.sorting.sort2;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 03-Mar-24
 * @Description : <a href="">link</a>
 */
public class BubbleSortRecursion {


    private static void bubbleSort(int[] a, int n) {

        if (n == 1) return;

        for (int i = 0; i <= n - 2; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
        bubbleSort(a, n-1);
    }

    public static void main(String[] args) {
        int[] a = {41 ,467 ,334 ,500 ,169 ,724 ,478 ,358 ,962 ,464};
        bubbleSort(a, a.length);
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("a = " +"41 169 334 358 464 467 478 500 724 962 ");
    }


}
