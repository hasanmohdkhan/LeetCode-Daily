package strivers.binarysearch.lec2;

/**
 * @Auther : hasan.khan
 * @Created : 24-Jun-24
 * @Description : <a href="">link</a>
 */
public class L5FindSmallestDivisorGivenAThreshold {


    public int smallestDivisorBrute(int[] nums, int threshold) {
        int min = 1;
        int max = (int) 1e9;

        for (int i = min; i <= max; i++) {
            int count = 0;
            for (int j : nums) count += Math.ceil((double) j / i);
            if (count <= threshold) return i;
        }

        return -1;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = getMax(nums);

        while (start <= end) {
            int mid = start +(end - start) / 2;
            if (isDivisible(nums, mid) <= threshold) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return start;
    }

    private int getMax(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int j : nums) ans = Math.max(ans,j);
        return ans;
    }

    private static int isDivisible(int[] nums, double i) {
        int count = 0;
        for (int j : nums) count += Math.ceil((double) j / i);
        return count;
    }

    public static void main(String[] args) {
        L5FindSmallestDivisorGivenAThreshold d = new L5FindSmallestDivisorGivenAThreshold();
        System.out.println("d = " + d.smallestDivisor(new int[]{1, 2, 5, 9}, 6));
        System.out.println("d2 = " + d.smallestDivisor(new int[]{44, 22, 33, 11, 1}, 5));
        System.out.println("d2 = " + d.smallestDivisor(new int[]{21212, 10101, 12121}, 1000000));
    } // 1,1,2,3
}
