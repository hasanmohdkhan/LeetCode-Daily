package strivers.binarysearch.lec1_basic;

/**
 * @Auther : hasan.khan
 * @Created : 11-Jun-24
 * @Description : <a href="">link</a>
 */
public class SearchMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } else {
                high = mid - 1;
                ans = Math.min(ans, nums[mid]);
            }

        }


        return ans;
    }

    public static void main(String[] args) {
        SearchMinimumInRotatedSortedArray mini = new SearchMinimumInRotatedSortedArray();
        int arr[] = {5, 1, 2, 3, 4};
        int[] arr1 = {1, 2, 3, 4, 5};

        System.out.println("mini = " + mini.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println("mini2 = " + mini.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println("mini3 = " + mini.findMin(new int[]{11, 13, 15, 17}));
        System.out.println("miniQ = " + mini.findMin(arr));
        System.out.println("miniQ = " + mini.findMin(arr1));
    }
}
