package strivers.Arrays.medium;

/**
 * @Auther : hasan.khan
 * @Created : 20-Mar-24
 * @Description : <a href="">link</a>
 */
public class SubArraySum {

    public static long maxSubarraySumNJ(int[] arr, int n) {
        /*if (arr.length == 0) {
            return 0;
        }*/

        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int j=0 ; j< arr.length ; j++) {
            sum += arr[j];
           // max = Math.max(sum, max);
            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }

        }

        if (max < 0) max = 0;

        return max;

    }


    public static long maxSubarraySum(int[] arr, int n) {
        if (arr.length == 0) {
            return 0;
        }

        if (arr.length == 1) {
            return arr[0];
        }


        int max =Integer.MIN_VALUE;
        int sum = 0;
        for (int j=0 ; j< arr.length ; j++) {
            sum += arr[j];
            // max = Math.max(sum, max);
            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }

        }

       // if (max < 0) max = 0;

        return max;

    }

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        int[] a1 = {-7, -8, -16, -4, -8, -5, -7, -11, -10, -12, -4, -6, -4, -16, -10};

        int[] a2 = {6, 10, 20, -30, 40, -50, 60}; //46 - 50 => 4

        int[] b = {-2,-1};
       // System.out.println(" = " + maxSubarraySum(a1, a1.length));
        System.out.println(" = " + maxSubarraySum(a, a.length));
        System.out.println(" = " + maxSubarraySum(b, b.length));
       // System.out.println(" = " + maxSubarraySum(a2, a2.length));


    }

}
