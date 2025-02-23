package strivers.binarysearch.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 15-Aug-24
 * @Description : <a href="">link</a>
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();

        for (int target : nums1) {
            if (!list.contains(target) && bs(target, nums2)) list.add(target);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        for (int i : nums1) set1.add(i);
        for (int i : nums2)if(set1.contains(i)) intersection.add(i);


        return intersection.stream().mapToInt(i -> i).toArray();
    }

    private boolean bs(int target, int[] nums2) {
        int low = 0;
        int end = nums2.length - 1;

        while (low <= end) {
            int mid = (low + end) / 2;
            if(nums2[mid] == target ) return true;
            if(nums2[mid] < target) low = mid +1;
            else  end = mid - 1;
        }

        return false;
    }


    public static void main(String[] args) {
        Intersection inst = new Intersection();
        System.out.println("inst = " + Arrays.toString(inst.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println("inst = " + Arrays.toString(inst.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
        System.out.println("inst = " + Arrays.toString(inst.intersection(new int[]{1,2,2,1}, new int[]{1,2})));
    }
}
