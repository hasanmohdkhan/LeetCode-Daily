package neetcodeAll.arrayAndhashing;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 02-Nov-23
 * @Description : <a href="https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/">link</a>
 */
public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElementsBruteForce(int[] arr) {
        int[] res = new int[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                //   System.out.print(" " + arr[j]);
                max = Math.max(max, arr[j]);
            }

            //   System.out.println("\nmax = " + max + ", i = " + i);
            if (i == arr.length - 1) {
                // System.out.println("-> i = " + i);
                res[i] = -1;
            } else {
                res[i] = max;
            }
            max = 0;

        }

        // System.out.println("res = " + Arrays.toString(res));

        return res;
    }

    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        int rightMax = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println("arr[" + i + "] = " + arr[i]);
            int max = Math.max(rightMax, arr[i]); // -1 , 1 -> 1  2. -> 1,6 = 6
            res[i] = rightMax;  //->  res[5] = -1  // 2. -> res[4] = 6
            rightMax = max;    //  rightMax = 1  // 2. -> rightMax = 1
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};
        ReplaceElementsWithGreatestElementOnRightSide onRightSide = new ReplaceElementsWithGreatestElementOnRightSide();
        System.out.println("onRightSide = " + Arrays.toString(onRightSide.replaceElements(arr)));

    }
}
