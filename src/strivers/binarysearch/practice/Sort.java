package strivers.binarysearch.practice;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 14-Aug-24
 * @Description : <a href="">link</a>
 */
public class Sort {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
       // System.out.println("nums = " + Arrays.toString(nums));
        List<Integer> integers = new ArrayList<>();

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
//            System.out.println("mid = " + mid + " , " + nums[mid]);
//            System.out.println("low = " + low);
//            System.out.println("high = " + high);

            if (nums[mid] == target) {
                int firstIndex = mid;
                int lastIndex = mid;

                
                while (firstIndex > 0 && nums[firstIndex - 1] == target) {
                    firstIndex--;
                }

                while (lastIndex < nums.length - 1 && nums[lastIndex + 1] == target) {
                    lastIndex++;
                }


                for (int i = firstIndex; i <= lastIndex; i++) {
                    integers.add(i);
                }
                break;

            }
            if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        Collections.sort(integers);

        return integers;
    }

    public static void main(String[] args) {
        Sort s = new Sort();
        System.out.println("s = " + s.targetIndices(new int[]{1, 2, 5, 2, 3}, 3));
        System.out.println("s = " + s.targetIndices(new int[]{1, 2, 5, 2, 3}, 2));
        System.out.println("s = " + s.targetIndices(new int[]{1, 2, 5, 2, 3}, 5));
        System.out.println("s = " + s.targetIndices(new int[]{100, 1, 100}, 100));
    }
}
