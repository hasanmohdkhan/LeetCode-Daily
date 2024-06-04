package strivers.Arrays.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 22-Mar-24 TODO: notes
 * @Description : <a href="https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/">link</a>
 */
public class NextPermutation {

    public static List<Integer> nextGreaterPermutation(List<Integer> a) {
        int n = a.size();
        int idx = -1; // initial break point

        // find the break point
        for (int i = n - 2; i >= 0; i--) {
            if (a.get(i) < a.get(i + 1)) {
                idx = i;
                break;
            }
        }

        // idx==-1 means array is sorted now reverse the array
        if (idx == -1) {
            Collections.reverse(a);
            return a;
        }

        // now find the next greater element in array and swap it with smaller element
        for (int i = n - 1; i > idx; i--) {
            if (a.get(i) > a.get(idx)) {
                int temp = a.get(i);
                a.set(i, a.get(idx));
                a.set(idx, temp);
                break;
            }
        }

        // reverse the right half
        List<Integer> list = a.subList(idx + 1, n);
        Collections.reverse(list);

        return a;
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind1 = -1;
        int ind2 = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind1 = i;
                break;
            }
        }


        if (ind1 == -1) {
            reverse(nums, 0);
        } else {
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > nums[ind1]) {
                    ind2 = i;
                    break;
                }
            }

            swap(nums, ind1, ind2);

            reverse(nums, ind1 + 1);
        }




    }

    void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length-1;

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }

    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }




    public static void main(String[] args) {
        int[] a = {3, 2, 1};
        int[] a1 = {11, 7, 13, 8, 16, 13};


        // 11 7 13 13 8 16
        // List<Integer> list =List.of(a);

        //  System.out.println("next = " + nextGreaterPermutation(list));
        //System.out.println("next = " + nextGreaterPermutation(Arrays.asList(a1)));
        NextPermutation nextPermutation = new NextPermutation();
         nextPermutation.nextPermutation(a);
        // System.out.println("a1 = " + Arrays.toString(a1));
      //  nextPermutation.reverse(a, 0);
        System.out.println("a = " + Arrays.toString(a));
        //  System.out.println("reverse = " + );

    }
}
