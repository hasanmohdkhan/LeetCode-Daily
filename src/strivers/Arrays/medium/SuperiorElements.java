package strivers.Arrays.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 23-Mar-24
 * @Description : <a href="">link</a>
 */
public class SuperiorElements {

    public static List<Integer> superiorElementsB(int[] a) {
        List<Integer> sup = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            boolean isSup = true;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[i]) {
                    isSup = false;
                    break;
                }
            }
            if (isSup) sup.add(a[i]);

        }

        //   System.out.println("sup = " + sup);
        Collections.sort(sup);

        return sup;
    }


    public static List<Integer> superiorElements(int[] a) {
        List<Integer> sup = new ArrayList<>();

        int n = a.length;
        int max = a[n - 1];
        sup.add(max);

        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > max) {
                sup.add(a[i]);
                max = a[i];
            }
        }

        return sup;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2};
        int[] a1 = {5, 4, 3};
        int[] a2 = {1, 2, 2, 1};

        System.out.println("superiorElements() = " + superiorElements(a));
        System.out.println("superiorElements() = " + superiorElements(a1));
        System.out.println("superiorElements() = " + superiorElements(a2));
    }

}
