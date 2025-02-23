package strivers.recurssion.study25.l3;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 14-Feb-25
 * @Description : <a href="https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/?envType=problem-list-v2&envId=backtracking">link</a>
 */
public class EqualSumSets {

    public boolean canPartitionKSubsets1(int[] nums, int k) {
        if (nums.length == 0) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;

        Arrays.sort(nums);
        reverseArray(nums);

        int target = sum / k;
        boolean[] used = new boolean[nums.length];

        return backtracking(0, 0, nums, k, target, used);
    }

    private boolean backtracking(int start, int initSum, int[] nums, int k, int target, boolean[] used) {
        if (k == 0) return true;
        if (initSum == target) return backtracking(0, 0, nums, k - 1, target, used);

        for (int i = start; i < nums.length; i++) {
            if (used[i] || initSum + nums[i] > target) continue;
            used[i] = true;
            if (backtracking(i + 1, initSum + nums[i], nums, k, target, used)) return true;
            used[i] = false;
        }

        return false;
    }

    public void reverseArray(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }


    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        reverseArray(nums);

        boolean[] used = new boolean[nums.length];
        int target = sum/k;

        return backtracking2(0, 0, nums, k, target, used);

    }

    private boolean backtracking2(int idx, int intSum, int[] nums, int k, int target, boolean[] used) {
        if (k == 0) return true;
        if (intSum == target) return backtracking2(0, 0, nums, k - 1, target, used);

        for (int i = idx; i < nums.length; i++) {
            if (used[i] ||  intSum + nums[i] > target) continue;
            used[i] = true;
            if (backtracking2(i + 1, intSum + nums[i] , nums, k, target, used)) return true;
            used[i] = false;
            if(intSum==0) break;
        }

        return false;
    }

    public static void main(String[] args) {
        EqualSumSets s = new EqualSumSets();
        System.out.println("s = " + s.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println("s = " + s.canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4));
        System.out.println("s = " + s.canPartitionKSubsets(new int[]{1,2,3,4}, 3));
    }


}
