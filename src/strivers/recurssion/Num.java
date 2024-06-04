package strivers.recurssion;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 22-Feb-24
 * @Description : <a href="">link</a>
 */
public class Num {

    public static int[] printNos(int x) {
        int[] a = new int[x];
        return printNo(x, a);
    }

    private static int[] printNo(int i, int[] a) {
        if (i == 1) {
            a[i - 1] = i;
            return a;
        }

        printNo(i-1,a);
        a[i - 1] = i;
        return a;
    }

    public static void main(String[] args) {
        System.out.println("args = " + Arrays.toString(printNos(5)));
    }

}
