package strivers.binarysearch.lec1_basic;



/**
 * @Auther : hasan.khan
 * @Created : 04-Jun-24
 * @Description : <a href="">link</a>
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) start = mid + 1;
            else end = mid-1;
        }

        return -1;
    }


    public int searchR(int[] nums, int target) {
        return binary(nums, 0, nums.length, target);
    }

    private int binary(int[] nums, int start, int end, int target) {
        if (start >= end) return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target) return mid;
        else if (target > nums[mid]) return binary(nums, mid + 1, end, target);
        return binary(nums, start, mid, target);
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] a = {-1, 0, 3, 5, 9, 12};
        System.out.println("bs = " + bs.search(a, 9));
        System.out.println("bs = " + bs.search(a, 13));
        System.out.println("bs = " + bs.search(a, 12));
    }

}
