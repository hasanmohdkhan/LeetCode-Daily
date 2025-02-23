package amzanonOA.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 09-Sep-24
 * @Description : <a href="https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1">link</a>
 */
public class Sum {
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int currentSum = 0;


        for (int right = 0; right < n; right++) {
            currentSum += arr[right];

            while (currentSum > s && left < right) {
                currentSum -= arr[left];
                left++;
            }

            if (currentSum == s) {
                list.add(left + 1);
                list.add(right + 1);
                return list;
            }

        }

        list.add(-1);
        return list;
    }

    public static void main(String[] args) {
        System.out.println("List = " + subarraySum(new int[]{1, 2, 3, 7, 5}, 5, 12));
        System.out.println("List = " + subarraySum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10, 15));
        System.out.println("List = " + subarraySum(new int[]{7, 2, 1}, 3, 2));
        System.out.println("List = " + subarraySum(new int[]{}, 0, 0));
        System.out.println("List = " + subarraySum(new int[]{1}, 1, 0));
        System.out.println("List = " + subarraySum(new int[]{1, 2, 3, 4}, 4, 0));
    String s = "I/O error on POST request for \"http://10.194.83.159:9016/ulip-management/echallan/challan\": Connection timed out (Connection timed out); nested exception is java.net.ConnectException: Connection timed out (Connection timed out)";
    String s1 = "Exception While calling Integration - ECHALLAN_01 Exception: org.springframework.web.client.ResourceAccessException: I/O error on POST request for \"http://10.194.83.159:9016/ulip-management/echallan/challan\": Connection timed out (Connection timed out); nested exception is java.net.ConnectException: Connection timed out (Connection timed out)\n";
        System.out.println("s = " + s.length());
        System.out.println("s = " + s1.length());



    }

}
