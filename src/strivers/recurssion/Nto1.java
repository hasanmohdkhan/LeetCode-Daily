package strivers.recurssion;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 22-Feb-24
 * @Description : <a href="">link</a>
 */
public class Nto1 {

    public static int[] printNos(int x) {
        int[] arr = new int[x];
        int count = 0;
        return printN(x, arr, count);
    }

    public static int[] printN(int x, int[] arr, int count) {
      //  System.out.println("x = " + x);
        if (x == 1) {
            arr[count] = x;
            return arr;
        }
        arr[count++] = x;
        printN(x - 1, arr, count);
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("args = " + Arrays.toString(printNos(5)));
    }
}
