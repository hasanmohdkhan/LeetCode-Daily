package strivers.binarysearch.practice;

/**
 * @Auther : hasan.khan
 * @Created : 17-Aug-24
 * @Description : <a href="https://leetcode.com/problems/peak-index-in-a-mountain-array/description/">link</a>
 */
public class PeakIndexInMountainArray {
    // 0,2,1,0  --   0,10,5,2
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length; //3 ->  2 > 1
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n - 1] > arr[n - 2]) return n - 1;

        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            if (arr[mid] > arr[mid - 1]) low = mid + 1;
            else high = mid - 1;
        }


        return -1;
    }

    public int peakIndexInMountainArrayB(int[] arr) {
        int ans = arr[0];
        int index = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > ans) {
                ans = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        PeakIndexInMountainArray pim = new PeakIndexInMountainArray();
        System.out.println(" Brute force ");
        System.out.println("pim = " + pim.peakIndexInMountainArrayB(new int[]{0, 1, 0}));
        System.out.println("pim = " + pim.peakIndexInMountainArrayB(new int[]{0, 2, 1, 0}));
        System.out.println("pim = " + pim.peakIndexInMountainArrayB(new int[]{0, 10, 5, 2}));
        System.out.println("pim = " + pim.peakIndexInMountainArrayB(new int[]{0, 10, 15, 2}));

        System.out.println(" BS solution ");
        System.out.println("pim = " + pim.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println("pim = " + pim.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println("pim = " + pim.peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        System.out.println("pim = " + pim.peakIndexInMountainArray(new int[]{0, 10, 15, 2}));

    }
}
