package strivers.binarysearch.lec1_basic;

/**
 * @Auther : hasan.khan
 * @Created : 09-Jun-24
 * @Description : <a href="">link</a>
 */
public class SearchInRotatedSortedArrayI {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) return mid;

            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }

        }

        return -1;
    }



    public static void main(String[] args) {
        SearchInRotatedSortedArrayI br = new SearchInRotatedSortedArrayI();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        // System.out.println("br = " + br.search(nums, target));

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        // Output: -1

        // System.out.println("br = " + br.search(nums2, target2));

        int[] nums3 = {1,0,1,1,1};
        int target3 = 0;


        System.out.println("br = " + br.search(nums3, target3));
    }
}
