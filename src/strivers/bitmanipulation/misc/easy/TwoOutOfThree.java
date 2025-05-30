package strivers.bitmanipulation.misc.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 01-May-25
 * @Description : <a href="">link</a>
 */
public class TwoOutOfThree {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list = new ArrayList<>();
        int[] bit = new int[101];
        updateBits(nums1, bit, 0);
        updateBits(nums2, bit, 1);
        updateBits(nums3, bit, 2);

        for (int i : bit) {
            System.out.print(" " + Integer.toBinaryString(i));
            // System.out.println();
        }


        for (int i = 0; i < bit.length; i++) {
            if (Integer.bitCount(bit[i]) > 1) list.add(i);
        }

        // System.out.println("bit = " + Arrays.toString(bit));

        // System.out.println("list = " + list);

        return list;
    }

    private void updateBits(int[] num, int[] bit, int bitPosition) {
        for (int j : num) {
            bit[j] |= 1 << bitPosition;
            System.out.print(" " + Integer.toBinaryString(bit[j]));
        }
        System.out.println("i ====");
    }

    public static void main(String[] args) {
        TwoOutOfThree s = new TwoOutOfThree();
        int[] a = new int[]{2, 3, 1, 6, 7};
        int[] x = new int[a.length + 1];

        for (int i = 0; i < a.length; i++) {
            x[i + 1] = a[i] ^ x[i];
        }
        System.out.println("x = " + Arrays.toString(x));

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                System.out.println("j == " + j);
                if (x[i] == x[j + 1]) {
                    count += j - i;
                    System.out.println("j = " + j +  "  i = "+i);
                    System.out.println("j = " + count);
                }
            }
        }


//        System.out.println("s = " + s.twoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2, 3}, new int[]{3}));
//        System.out.println("s = " + s.twoOutOfThree(new int[]{3, 1}, new int[]{2, 3}, new int[]{1, 2}));
//        System.out.println("s = " + s.twoOutOfThree(new int[]{1, 2, 2}, new int[]{4, 3, 3}, new int[]{5}));
//        System.out.println("s = " + s.twoOutOfThree(new int[]{2, 2}, new int[]{2,2}, new int[]{2}));

    }


}
