package strivers.binarysearch.lec1_basic;

/**
 * @Auther : hasan.khan
 * @Created : 13-Jun-24
 * @Description : <a href="">link</a>
 */
public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int low = 0;
        int high = n - 2;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) return nums[mid];

            if (((mid % 2 == 1) && (nums[mid] == nums[mid - 1])) ||
                    ((mid % 2 == 0) && (nums[mid] == nums[mid + 1]))) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        SingleElementInASortedArray s = new SingleElementInASortedArray();

        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8}; //ev,odd or odd or even
        // Output: 2 Example 2:

        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};
        int[] n = {2};
        int[] n2 = {1, 2};
        int[] n3 = {1, 3, 3};
        System.out.println("s = " + s.singleNonDuplicate(nums));
        System.out.println("s2 = " + s.singleNonDuplicate(nums2));
//        System.out.println("n3 = " + s.singleNonDuplicate(n));
//        System.out.println("n3 = " + s.singleNonDuplicate(n2));
//        System.out.println("n3 = " + s.singleNonDuplicate(n3));
    }

}
