package strivers.Arrays.easy;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 05-Mar-24
 * @Description : <a href="https://www.codingninjas.com/studio/problems/left-rotate-an-array-by-one_5026278">link</a>
 */
public class LeftRotateAnArrayByOne {

    static int[] rotateArray(int[] arr, int n) {
        int idx = arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
       // System.out.println("arr = " + Arrays.toString(arr));
        arr[arr.length -1 ] = idx;

        return arr;
    }

    public static void main(String[] args) {
        int a = 5;
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("arr = " + Arrays.toString(rotateArray(arr, a)));

    }
}
