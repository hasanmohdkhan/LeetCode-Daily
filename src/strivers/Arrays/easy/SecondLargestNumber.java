package strivers.Arrays.easy;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 03-Mar-24
 * @Description : <a href="https://www.codingninjas.com/studio/problems/ninja-and-the-second-order-elements_6581960?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">link</a>
 */
public class SecondLargestNumber {

    public static int[] getSecondOrderElements(int n, int []a) {
        int[] res = new int[2];
        Arrays.sort(a);
        res[0] = a[a.length - 2];
        res[1] = a[1];

      return  res;

    }

    public static void main(String[] args) {
       int[] a = {1, 2, 3, 4, 5};

        System.out.println("a = " + Arrays.toString(getSecondOrderElements(a.length, a)));
        int[] a1 = {1, 2};
        System.out.println("a = " + Arrays.toString(getSecondOrderElements(a1.length, a1)));

    }
}
