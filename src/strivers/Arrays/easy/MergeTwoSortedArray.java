package strivers.Arrays.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 08-Mar-24
 * @Description : <a href="">link</a>
 */
public class MergeTwoSortedArray {

    public static List<Integer> sortedArray(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();

        for (int j : a) {
            if (!list.contains(j)) {
                list.add(j);
            }
        }

        for (int j : b) {
            if (!list.contains(j)) {
                list.add(j);
            }
        }

        Collections.sort(list);

        return list;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 6};
        int[] b = {2, 3, 5};
        System.out.println("b = " + sortedArray(a, b));
    }
}
