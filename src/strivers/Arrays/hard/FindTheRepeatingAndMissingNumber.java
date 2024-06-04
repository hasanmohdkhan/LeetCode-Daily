package strivers.Arrays.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 09-May-24
 * @Description : <a href="">link</a>
 */
public class FindTheRepeatingAndMissingNumber {

    int[] findTwoElement(int[] arr, int n) {
        int[] a = new int[2];
        Map<Integer, Integer> rep = new HashMap<>();

        for (int j : arr) {
            rep.put(j, rep.getOrDefault(j, 0) + 1);
            if (rep.get(j) == 2) {
                a[0] = j;
            }
        }

        for (int i = 1; i <= arr.length; i++) {
            if (!rep.containsKey(i)) a[1] = i;
        }


        return a;
    }

    public static void main(String[] args) {
        FindTheRepeatingAndMissingNumber m = new FindTheRepeatingAndMissingNumber();
        int[] a = {2, 2};
        System.out.println("m = " + Arrays.toString(m.findTwoElement(a, 2)));
        int[] aa = {1, 3, 3};
        System.out.println("m = " + Arrays.toString(m.findTwoElement(aa, 3)));
    }
}
