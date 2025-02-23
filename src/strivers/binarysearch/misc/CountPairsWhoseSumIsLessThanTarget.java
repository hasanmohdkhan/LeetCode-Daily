package strivers.binarysearch.misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 25-Jun-24
 * @Description : <a href="">link</a>
 */
public class CountPairsWhoseSumIsLessThanTarget {

    public int countPairsBrute1(List<Integer> nums, int target) {
        int count = 0;

        int i = 0;
        int j = i + 1;
        while (i <nums.size()) {
            if (nums.get(i) + nums.get(j) < target) {
                count++;
                j++;
            } else i++;
        }

        return count;
    }

    public int countPairs(List<Integer> nums, int target) {
        int start = 0;
        int end = nums.size() - 1;
        int res = 0;
        Collections.sort(nums);

        while (start < end) {
            int sum = nums.get(start) + nums.get(end);
            if (sum < target) {
                res += end - start;
                start++;
            } else {
                end--;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        CountPairsWhoseSumIsLessThanTarget p = new CountPairsWhoseSumIsLessThanTarget();
      //  System.out.println("p = " + p.countPairs(Arrays.asList(-1, 1, 2, 3, 1), 2));
        System.out.println("p = " + p.countPairsBrute1(Arrays.asList(-1, 1, 2, 3, 1), 2));
    }
}
