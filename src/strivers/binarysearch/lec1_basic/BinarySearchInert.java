package strivers.binarysearch.lec1_basic;

/**
 * @Auther : hasan.khan
 * @Created : 06-Jun-24
 * @Description : <a href="">link</a>
 */
public class BinarySearchInert {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        int ans = nums.length;

        while (start<= end){
            int mid = (start+end)/2;
           // System.out.println("mid = " + mid + ", s = "+start +" , e= "+end );

            if (nums[mid] >= target){
                ans = mid;
                end = mid - 1;
            }else {
                start = mid+1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        BinarySearchInert bsi = new BinarySearchInert();
        int[] nums = {1, 3, 5, 6};
        int target = 5;

        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;

        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;

        int[] n = {1,3,5,6};

        System.out.println("bsi = " + bsi.searchInsert(nums,target));
        System.out.println("bsi = " + bsi.searchInsert(nums2,target2));
        System.out.println("bsi = " + bsi.searchInsert(nums3,target3));
        System.out.println("bsi = " + bsi.searchInsert(n,0));
    }
}
