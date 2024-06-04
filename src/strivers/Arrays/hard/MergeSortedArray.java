package strivers.Arrays.hard;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 08-May-24
 * @Description : <a href="">link</a>
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }


        // merging
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                for (int k : nums2) {
                    nums1[i++] = k;
                }
            }
        }

        int merLen = nums1.length - n;
        //  System.out.println("merLen = " + merLen);


        // sorting
        int r = 0;
        int l = merLen;
        while (r < merLen) {
            if (nums1[r] < nums1[l]) {
                r++;
                continue;
            } else if (nums1[r] == nums1[l]) {
                int temp = nums1[r + 1];
                nums1[r + 1] = nums1[l];
                nums1[l] = temp;
            } else if (nums1[r] > nums1[l]) {
                int temp = nums1[r];
                nums1[r] = nums1[l];
                nums1[l] = temp;
            }


            r++;
            l++;
        }


        System.out.println("re nums1 = " + Arrays.toString(nums1));

    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;  // 3
        int j = n - 1;  // 6
        int k = m + n - 1; // 0
      //  System.out.println("k = " + k + " i "+i +" j "+j);

       // System.out.println("nums1 = " + Arrays.toString(nums1));
        while (i >=0 && j>=0 ){

            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;

        }

        while (i>=0 ){
            nums1[k] = nums1[i];
            i--;
            k--;
        }

       /* while (j>=0){
            nums1[k]=nums2[j];
            j--;
            k--;
        }*/
      //  System.out.println("nums1 = " + Arrays.toString(nums1));


    }





    public static void main(String[] args) {
        MergeSortedArray mm = new MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        mm.merge1(nums1, m, nums2, n);
        System.out.println("-> nums1 = " + Arrays.toString(nums1));
        System.out.println("2 = ");

        int[] q = {1};
        int mq = 1;
        int[] p = {};
        int np = 0;
        mm.merge1(q, mq, p, np);
        System.out.println(" nums1 = " + Arrays.toString(q));


        int[] q1 = {};
        int mq1 = 0;
        int[] p1 = {1};
        int np1 = 1;

        System.out.println(" nums1 = " + Arrays.toString(q1));
        mm.merge1(q1, mq1, p1, np1);


    }


}
