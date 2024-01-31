package neet150.Arrayshashing;

import java.util.HashSet;

/**
 * @Auther : hasan.khan
 * @Created : 21-Nov-23
 * @Description : <a href="https://leetcode.com/problems/longest-consecutive-sequence/">link</a>
 * @Note :<p>First store all array elements in sets then find loop the all number one by one and find the number+1 in exits or not
 * if exits then increase the count
 * <ol>
 *     <li><em>For finding sequence start -> find number -1 is not exits in set.</em></li>
 *     <li><em>For finding next sequence -> find  number+1 is exits in set.</em></li>
 * </ol>
 * </p>
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int longest = 1;
        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : nums) hashSet.add(num);
        //  System.out.println("hashSet = " + hashSet);

        for (int num : nums) {
            int count = 0;
            if (!hashSet.contains(num - 1)) {
                count++;

                while (hashSet.contains(num + 1)) {
                    num++;
                    count++;
                }

                longest = Math.max(count, longest);

            }

        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        //   int[] arr1 = {0,3,7,2,5,8,4,6,0,1};
        int[] arr1 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};

        LongestConsecutiveSequence o = new LongestConsecutiveSequence();
        System.out.println("o = " + o.longestConsecutive(arr));
        System.out.println("o = " + o.longestConsecutive(arr1));

    }


}
