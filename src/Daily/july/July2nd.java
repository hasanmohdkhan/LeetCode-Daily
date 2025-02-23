package Daily.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 02-Jul-24
 * @Description : <a href="">link</a>
 */
public class July2nd {

    public int[] intersectB(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        for (int j : nums1) {
            for (int k : nums2) {
                if (j == k) {
                    list.add(k);
                    break;
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return intersect(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> l = new ArrayList<>();
        int start = 0;
        for (int k : nums1) {
            int res = bs(nums2, k, start);
            if (res != -1) {
                l.add(k);
                start = res+1;
            }
        }

        return l.stream().mapToInt(Integer::intValue).toArray();
    }

    private int bs(int[] nums2, int k, int start) {
        int end = nums2.length - 1;
        int index = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums2[mid] == k) {
                index = mid;
                end = mid - 1;
            }
            if (nums2[mid] < k) start = mid + 1;
            else end = mid - 1;

        }
        return index;
    }


    public static void main(String[] args) {
        July2nd s = new July2nd();
        System.out.println("s = " + Arrays.toString(s.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println("s = " + Arrays.toString(s.intersect(new int[]{1, 2, 2, 1}, new int[]{2})));
        System.out.println("s = " + Arrays.toString(s.intersect(new int[]{1, 2}, new int[]{1, 1})));
        System.out.println("s = " + Arrays.toString(s.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

}
