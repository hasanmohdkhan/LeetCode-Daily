package strivers.binarysearch.practice;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 01-Sep-24
 * @Description : <a href="https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/">link</a>
 */
public class MaximumGroups {

    public int maximumGroups(int[] grades) {
        int low = 0;
        int high = grades.length;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2; // no. of group that can be formed
            int sum = mid * (mid + 1) / 2;  // sum of student in mid-group using math formula for sum of n number

            if (sum <= grades.length) {
                ans = mid;
                low = mid + 1;
            } else high = mid - 1;

        }
        return ans;
    }


    public static void main(String[] args) {
        MaximumGroups s = new MaximumGroups();
        System.out.println("s = " + s.maximumGroups(new int[]{10,6,12,7,3,5}));
        System.out.println("s = " + s.maximumGroups(new int[]{8,8}));
    }

}
