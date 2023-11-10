package medium;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 17-Sep-23
 * @Description:
 */
public class TwoSum2InputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int rightIndex = numbers.length - 1;
        int leftIndex = 0;
        int[] index = new int[2];


        while (leftIndex < numbers.length) {
//            System.out.println("looping");
//            System.out.println("numbers[rightIndex] = " + numbers[rightIndex]
//                    + ", numbers[leftIndex] =" + numbers[leftIndex] + " " +
//                    ", sum ="
//                    + (numbers[rightIndex] + numbers[leftIndex]));

            if (numbers[rightIndex] + numbers[leftIndex] == target) {
                index[0] = leftIndex + 1;
                index[1] = rightIndex + 1;

                return index;
            } else if (numbers[rightIndex] + numbers[leftIndex] > target) {
                rightIndex--;

            } else {
                leftIndex++;
            }


        }


        return null;

    }


    public static void main(String[] args) {
//        int[] arr = {2, 7, 11, 15};
//        int target = 9;

        int[] arr = {2,3,4};
        int target = 6;

        TwoSum2InputArrayIsSorted sorted = new TwoSum2InputArrayIsSorted();
        System.out.println("index's = " + Arrays.toString(sorted.twoSum(arr, target)));


    }
}
