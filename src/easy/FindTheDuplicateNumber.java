package easy;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 05-Sep-23
 * @Description:
 */
public class FindTheDuplicateNumber {


    /**
     * Complexity O(n^2) brute force approach
     *
     * @param nums array
     * @return duplicate number present in the array with modifying(array)
     */
    public int findDuplicateTwoLoops(int[] nums) {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int currentValueToBeCheck = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (currentValueToBeCheck == nums[j]) {
                    return currentValueToBeCheck;
                }
            }

        }


        return 0;
    }

    /**
     * Complexity -> O(n)
     *
     * @param nums array
     * @return duplicate number present in the array with modifying(array)
     */
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }

        return 0;
    }


    /**
     * Complexity -> O(n) runTime 2 ms better than set implementation
     *
     * @param nums array
     * @return duplicate number present in the array with modifying(array)
     */
    public int findDuplicateCountingFrequency(int[] nums) {
        int[] freqCountArray = new int[nums.length];

        for (int num : nums) {
            //nums[i]  get the value at i ->
            freqCountArray[num]++; // nums[i] -> 3 and freqCountArray -> [0, 0, 0, 1, 0]
            // System.out.println("freqCountArray = " + Arrays.toString(freqCountArray));
            if (freqCountArray[num] > 1) {
                return num;
            }

        }

        return 0;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};

        FindTheDuplicateNumber number = new FindTheDuplicateNumber();
        System.out.println("duplicate = " + number.findDuplicate(arr));
        int[] ints = {3, 1, 3, 4, 2};
        System.out.println("duplicate = " + number.findDuplicate(ints));
        System.out.println("duplicateFreq = " + number.findDuplicateCountingFrequency(ints));


    }

}
