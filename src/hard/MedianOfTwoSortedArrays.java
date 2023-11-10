package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 09-Sep-23
 * @Description:
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int zeroCount = 0;

        for (int i : nums1) {
            if (i == 0) {
                zeroCount++;
            }
            list.add(i);
        }
        for (int j : nums2) {
            if (j == 0) {
                zeroCount++;
            }
            list.add(j);
        }

        if (nums1.length == 0) {
            list.add(0);
        }

        if (nums2.length == 0) {
            list.add(0);
        }


        Collections.sort(list);
        //  System.out.println(Arrays.toString(list.toArray()));

        int size = list.size();
        if (size == zeroCount) {
            return 0.0;
        }

        if (size % 2 == 0) {
            System.out.println("even");
            double v1 = size / 2.0;
            double v2 = v1 + 1;
            double v = (v1 + v2) / 2.0;
            // System.out.println("v = " + v);
            return v;
        } else {
            System.out.println("odd");
            double v = (size + 1) / 2.0;
            //System.out.println("v = " + list.get((int) v));
            return v;
        }

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num3 = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, num3, 0, nums1.length);
        System.arraycopy(nums2, 0, num3, nums1.length, nums2.length);
        Arrays.sort(num3);
        System.out.println("Arrays.toString(num3) = " + Arrays.toString(num3));

        if (num3.length % 2 == 0) {
            System.out.println("even");
            double v1 = num3[num3.length / 2];
            System.out.println("v1 = " + v1);
            double v2 = num3[(num3.length/2)-1];
            System.out.println("v2 = " + v2);
            double ans = (double) (v1+v2) / 2;
            return ans;
        } else {
            return(double)num3[num3.length/2];
        }

    }


    public static void main(String[] args) {

        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        System.out.println("result =  " + median.findMedianSortedArrays(nums1, nums2));


        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};

        System.out.println("result =  " + median.findMedianSortedArrays(nums3, nums4));

        int[] nums5 = {1};
        int[] nums6 = {};

        System.out.println("result =  " + median.findMedianSortedArrays(nums5, nums6));


    }


}
