import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 03-Sep-23
 * @Description:
 */
public class RangeSumQueryImmutable {

    public int[] getNums() {
        return nums;
    }

    private int[] nums;

    public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] n = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable obj = new RangeSumQueryImmutable(n);
        obj.sumRange(0,2);
        obj.sumRange(2, 5);
        obj.sumRange(0, 5);
        System.out.println("arr: " + Arrays.toString(obj.getNums()));


    }
}
