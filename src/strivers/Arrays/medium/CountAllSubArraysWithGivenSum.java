package strivers.Arrays.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 28-Apr-24
 * @Description : <a href="">link</a>
 */
public class CountAllSubArraysWithGivenSum {

    public static int findAllSubarraysWithGivenSumBrute(int arr[], int s) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                //  System.out.println("sum " + sum + " arr = " + arr[j]);
                if (sum == s) {
                    count++;

                }
            }

        }


        return count;
    }

    public static int findAllSubarraysWithGivenSum(int arr[], int s) {
        Map<Integer, Integer> map = new HashMap<>(); // map<preSum , countOfPreSum>
        int preSum = 0;
        int count = 0;
        map.put(0, 1); // the initial sum of 0 will be 1


        for (int j : arr) {
            preSum += j;
            int remove = preSum - s; // calculate x-k  x-> preSum and s -> k

            // if exist key return values otherwise put in the map with value 0
            count += map.getOrDefault(remove, 0);

            // update the value of preSum if exist otherwise default will be 0
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        }
       // System.out.println("map = " + map);


        return count;
    }


    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int K = 6;
        System.out.println("sub array = " + findAllSubarraysWithGivenSum(arr, K));

    }

}
