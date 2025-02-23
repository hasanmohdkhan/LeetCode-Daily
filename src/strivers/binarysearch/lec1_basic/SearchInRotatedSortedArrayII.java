package strivers.binarysearch.lec1_basic;

/**
 * @Auther : hasan.khan
 * @Created : 10-Jun-24
 * @Description : <a href="">link</a>
 */
public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return true;

            //edge case
            if(nums[start]== nums[mid] && nums[mid]== nums[end]){
                start = start+1;
                end = end -1;
                continue;
            }


            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {// 5      6        10
                if (nums[mid] <= target && target <= nums[end]) start = mid + 1;
                 else end = mid - 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII II = new SearchInRotatedSortedArrayII();

        int[] a = {1,0,1,1,1};
        System.out.println("II = " + II.search(a,0));
    }
}
