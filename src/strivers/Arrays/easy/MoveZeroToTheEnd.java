package strivers.Arrays.easy;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 08-Mar-24
 * @Description : <a href="">link</a>
 */
public class MoveZeroToTheEnd {

    public static int[] moveZerosB(int n, int[] a) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                for (int j = i; j < a.length; j++) {
                    if (a[j] != 0) {
                        int temp = a[j];
                        a[j] = a[i];
                        a[i] = temp;
                        break;
                    }
                }
            }
        }


        return a;
    }

    public static int[] moveZeros(int n, int[] a) {
        int i = 0;
        int j = 1;

        while (j < a.length) {// {1, 2, 0, 0, 2, 3};
           if(a[i]==0){
               if(a[j]==0){
                   System.out.println("j = " + j);
                   if( j == a.length-1) break;
                   j++;
               }
               int temp = a[i];
               a[i] = a[j];
               a[j] = temp;
           }else {
               i++;
               j++;
           }
          //  System.out.println("i = " + i+ " , j = "+j);

        }


        return a;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1};
        int[] nums1 = {1, 2, 0, 0, 2, 3};
        int[] nums2 = {7 ,93 ,0 ,8 ,15 ,0 ,0 ,0 ,0 ,0 ,26 ,0 ,0 ,0 ,43 ,90 ,2 ,0 ,0 ,0 ,58 ,94 ,77 ,45 ,59 ,19 ,0 ,0 ,98 ,0 ,0 ,0 ,0 ,0 ,88 ,0 ,0 ,0};
        int k = 6;
        System.out.println("moveZeros() = " + Arrays.toString(moveZeros(k, nums2)));
    }
}
