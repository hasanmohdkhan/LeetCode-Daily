package strivers.Arrays.easy;

/**
 * @Auther : hasan.khan
 * @Created : 09-Mar-24
 * @Description : <a href="">link</a>
 */
public class KSum {

    public static int longestSubarrayWithSumK(int[] a, long k) {
        // Write your code here
        int kSum = 0;

        int length = a.length;
       /* for (int i = 0; i < length; i++) {
            int s = 0;
            for (int j = i; j < length ; j++) {
                s+=a[j];
                if(s==k){
                    kSum = Math.max(kSum, i - j + 1);
                }
            }

        }*/


        int r =0;
        int l = 0;
        int s = a[0];

        while (r < length){

            while (l <= r && s > k){
                s -= a[l];
                l++;
            }

            if(s==k){
                kSum = Math.max(kSum, r-l+1);
            }


            r++;

            if(r < length)  s += a[r];
        }



        return kSum;

    }

    public static void main(String[] args) {
        int k = 3;
        int[] a = {1, 2, 3, 1, 1, 1, 1};
        int[] b = {1 ,2 ,1, 3};
        int[] c = {2 ,2 ,4 ,1 ,2};

     //   System.out.println("a = " + longestSubarrayWithSumK(a, k));
        System.out.println("a = " + longestSubarrayWithSumK(b, 2));
        System.out.println("c = " + longestSubarrayWithSumK(c, 2));
    }
}
