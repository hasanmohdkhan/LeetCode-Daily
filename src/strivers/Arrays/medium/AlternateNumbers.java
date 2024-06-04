package strivers.Arrays.medium;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 21-Mar-24
 * @Description : <a href="">link</a>
 */
public class AlternateNumbers {

    public static int[] alternateNumbersBrute(int[] a) {
        int idx = a.length / 2;

        int[] p = new int[idx];
        int[] n = new int[idx];
        int pc = 0;
        int nc = 0;

        for (int j : a) {
            if (j < 0) {
                n[nc++] = j;
            } else {
                p[pc++] = j;
            }
        }

        if (a[0] < 0) {
            a[0] = p[0];
        }


        for (int i = 0; i <idx; i++) {
            a[2*i] = p[i];
            a[(2*i)+1] = n[i];
        }

        return a;
    }


    public static int[] alternateNumbers(int[] a) {
        int posIdx=0;
        int negIdx=1;

        for (int i = 0; i < a.length; i++) {
           // if

        }



       return a;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, -4, -5};
        int[] b = {1, 2, -3, -1, -2, 3};
        int[] c = {-2, -3, 4, 5};

        System.out.println("alternateNumbers() = " + Arrays.toString(alternateNumbers(a)));
        System.out.println("alternateNumbers() = " + Arrays.toString(alternateNumbers(b)));
        System.out.println("alternateNumbers() = " + Arrays.toString(alternateNumbers(c)));
    }//4 -2 5 -3
}
