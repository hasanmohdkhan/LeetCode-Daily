package strivers.binarysearch.practice;

/**
 * @Auther : hasan.khan
 * @Created : 22-Aug-24
 * @Description : <a href="https://leetcode.com/problems/minimum-common-value/description/">link</a>
 */
public class MinimumCommonValue {

    public int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m) return getCommon(nums2, nums1);

        for (int key : nums1) {
            if (bs(nums2, key)) return key;
        }
        //System.out.println("l = " + l);

        return -1;
    }

    private static boolean bs(int[] nums2, int key) {
        int low = 0;
        int high = nums2.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums2[mid] == key) return true;
            if (nums2[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        MinimumCommonValue s = new MinimumCommonValue();
        System.out.println("s = " + s.getCommon(new int[]{1, 2, 3}, new int[]{2, 4}));
        System.out.println("s = " + s.getCommon(new int[]{1, 2, 3, 6}, new int[]{2, 3, 4, 5}));
    }

}
