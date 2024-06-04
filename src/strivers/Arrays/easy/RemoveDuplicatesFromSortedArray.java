package strivers.Arrays.easy;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Auther : hasan.khan
 * @Created : 05-Mar-24
 * @Description : <a href="https://www.codingninjas.com/studio/problems/remove-duplicates-from-sorted-array_1102307?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">link</a>
 * @Description : <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/">link</a>
 */
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] arr, int n) {
        Set<Integer> set = new HashSet<>();

        for (int j : arr) {
            set.add(j);
        }

        return set.size();
    }

    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new TreeSet<>();

        for (int j : nums) {
            set.add(j);
        }

        int count=0;

        for (Integer i : set){
            nums[count++] = i;
        }

        return set.size();
    }

    public static void main(String[] args) {
     //   int[] a = {1, 2, 2, 2, 3};
        int[] a = {-3,-1,0,0,0,3,3};
        System.out.println("a = " + removeDuplicates(a, a.length));
        System.out.println("a = " + new RemoveDuplicatesFromSortedArray().removeDuplicates(a));

    }
}
