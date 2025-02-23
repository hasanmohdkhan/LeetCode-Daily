package strivers.binarysearch.lec2;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 15-Jul-24
 * @Description : <a href="">link</a>
 */
public class L13KthElementFromTwoSortedArray {
    //TODO: Implement binary search for this

    public long kthElement(int[] arr1, int[] arr2, int n, int m, int k) {
        int[] arr = new int[arr1.length +arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr[i]= arr1[i];
        }
        int count=0;
        for (int i = arr1.length  ; i < arr.length; i++) {
            arr[i]= arr2[count++];
        }

        Arrays.sort(arr);

        return arr[k -1];
    }


    public static void main(String[] args) {
        L13KthElementFromTwoSortedArray k = new L13KthElementFromTwoSortedArray();
        System.out.println("k = " + k.kthElement(new int[]{2, 3, 6, 7, 9},
                new int[]{1, 4, 8, 10},5,4,5));
        System.out.println("k2 = " + k.kthElement(new int[]{5,5,8,8,8,9,11,11,11,11,11},
                new int[]{4,4,4,4,6,8,9,9,9,11,13},5,4,2));
    }


}
