package Daily.year24.feb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 01-Feb-24
 * @Description : <a href="https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/?envType=daily-question&envId=2024-02-01">link</a>
 */
public class DivideArrayIntoArraysWithMaxDifference {


    public int[][] divideArray(int[] nums, int k) {

        if(nums.length % 3 !=0){
            return new int[0][];
        }
        Arrays.sort(nums);
       // System.out.println("nums = " + Arrays.toString(nums));

       /* for (int i = 0; i < nums.length - 2; i+=3) {
          //  System.out.println("nums[i] = " + nums[i] + " index: "+i);
            if(nums[i+2] - nums[i] > k) return new int[0][];
        }*/

        for (int i = 0; i < nums.length - 2; i+=3) {
            if ( nums[i+2] - nums[i+1] > k) {
                return new int[0][];
            }
        }


        int[][] ans = new int[nums.length/3][3];
        int idx =0;
        for (int i = 0; i <= nums.length - 3; i+=3) {
            int subIdx = 0;
            for (int j = i; j < i+3; j++) {
                ans[idx][subIdx] = nums[j];
                subIdx++;
            }
            idx++;
        }

      //  System.out.println("ans = " + Arrays.deepToString(ans));

        return ans;
    }

    public static void main(String[] args) {
        DivideArrayIntoArraysWithMaxDifference dif = new DivideArrayIntoArraysWithMaxDifference();
        int[] a = {1, 3, 4, 8, 7, 9, 3, 5, 1};
        int[] b = {1, 3, 3, 2, 7, 3};
        int[] c = {6,10,5,12,7,11,6,6,12,12,11,7};
        Arrays.sort(c);
        System.out.println("c = " + Arrays.toString(c));

        int slice = 3;
        subArray(c, 2);
        subArray(c, slice);
        subArray(c, 6);


        //System.out.println("dif = " + Arrays.deepToString(dif.divideArray(a, 2)));
       // System.out.println("dif = " + Arrays.deepToString(dif.divideArray(b, 3)));
        //System.out.println("dif = " + Arrays.deepToString(dif.divideArray(c, 2)));
    }

    private static void subArray(int[] c, int slice) {
        System.out.println(" ----- subArray----");
        for (int i = 0; i < c.length - (slice -1); i+= slice) {
            for (int j = i; j < i + slice; j++) {
                System.out.print(" " + c[j]);
            }
            System.out.println();
        }
    }


}
