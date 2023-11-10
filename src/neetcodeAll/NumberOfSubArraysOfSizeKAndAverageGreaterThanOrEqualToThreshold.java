package neetcodeAll;

/**
 * @Auther : hasan.khan
 * @Created : 03-Nov-23
 * @Description : <a href="https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/">link</a>
 */
public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {

    public int numOfSubarrays(int[] arr, int k, int threshold) { // comp -> O(n.k) Space -> 0(1)
        int res = 0;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int avg = 0;
            for (int j = i; j < i + k; j++) {
                avg += arr[j];
            }

            if (avg / k >= threshold) res++;
            avg = 0; // reset avg
        }
        return res;
    }

    public int numOfSubarraysOptimal(int[] arr, int k, int threshold) {
        int res = 0;
        int avg = 0;
        for (int i = 0; i < k; i++) {
            avg+=arr[i];
        }
        res = checkAvg(k, threshold, avg, res);

        for (int i = k; i < arr.length; i++) {
            avg -= arr[i - k];
            avg += arr[i];
            res = checkAvg(k, threshold, avg, res);
        }

        return res;
    }

    private static int checkAvg(int k, int threshold, int avg, int res) {
        if (avg / k >= threshold) res++;
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;
        NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold ob = new NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold();
      //  System.out.println("ob = " + ob.numOfSubarrays(arr, k, threshold));

     /*   arr = new int[]{8246,1867,193,4539,2650,4721,2944,5777,8055,7502,4334,2137,3658,4156,4628,1139,7963,8035,6008,8427,1841,9169,1059,6158,9116,8052,7074,7866,584,666,192,8081,8273,2809,3017,7852,1869,3395,4649,5366,8834,9100,1643,9511,4136,3897,7193,2500,2721,8477,2887,8300,3922,579,4228,7983,4247,5362,5581,9270,8602,1944,240,6044,6036,1219,6901,2007,2123,9699,3388,390,9144,7697,5160,6442,7078,9758,8841,2064,4096,146,7362,3952,2346,4171,7598,1201,1860,9101,8979,8437,1989,5349,5148,9422,7217,1406,8414,3586,5935,7395,2257,7802,9449,3824,6874,3684,4252,3947,8985,1052,7295,2976,2045,2315,4887,307,8784,988,942,7960,747,1593,1112,7874};
        k = 1;
        threshold = 307;*/
        System.out.println("ob = " + ob.numOfSubarraysOptimal(arr, k, threshold));
    }
}
