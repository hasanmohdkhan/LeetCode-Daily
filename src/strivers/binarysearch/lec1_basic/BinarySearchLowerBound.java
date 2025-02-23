package strivers.binarysearch.lec1_basic;

/**
 * @Auther : hasan.khan
 * @Created : 05-Jun-24
 * @Description : <a href="">link</a>
 */
public class BinarySearchLowerBound {

    static int findFloor(long arr[], int n, long x) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] <= x) {
                ans = (int) arr[mid];
                start = mid + 1;
            } else {
               end = mid-1;
               ans = (int) arr[mid];
            }

        }


        return ans;
    }

    public static void main(String[] args) {
        int N = 7;
        int x = 5;
        long arr[] = {1L, 2L, 8L, 10L, 11L, 12L, 19L};
        System.out.println("index = " + findFloor(arr, N, x));

        int N1 = 7, x1 = 0;
        long arr1[] = {1, 2, 8, 10, 11, 12, 19};
        System.out.println("index = " + findFloor(arr1, N1, x1));
    }
}
