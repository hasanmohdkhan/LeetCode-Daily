package neetcodeAll.slidingWindow;

import java.util.HashSet;

/**
 * @Auther : hasan.khan
 * @Created : 03-Nov-23
 * @Description : <a href="https://leetcode.com/problems/contains-duplicate-ii/description/">link</a>
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();
        int left = 0; // pointer to keep track of window size

        for (int num : nums) {
            if (window.size() > k) {
                window.remove(nums[left]);
                left++;
            }
            if (window.contains(num)) return true;
            window.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        ContainsDuplicateII ob = new ContainsDuplicateII();
        System.out.println("ob = " + ob.containsNearbyDuplicate(nums, k));
    }
}
