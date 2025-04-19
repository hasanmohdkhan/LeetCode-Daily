package strivers.recurssion.study25;

/**
 * @Auther : hasan.khan
 * @Created : 05-Mar-25
 * @Description : <a href="">link</a>
 */
public class MaximumBitwiseORSubsets {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums) maxOr |= num;
        return backtrack(0, 0, nums, maxOr);
    }

    private int backtrack(int index, int currentOr, int[] nums, int maxOr) {
        if (index == nums.length) {
            if (currentOr == maxOr) return 1;
            else return 0;
        }
        int withOut = backtrack(index + 1, currentOr, nums, maxOr);
        int withIn = backtrack(index + 1, currentOr | nums[index], nums, maxOr);

        return withIn + withOut;
    }


    public static void main(String[] args) {
        MaximumBitwiseORSubsets s = new MaximumBitwiseORSubsets();
        System.out.println("s = " + s.countMaxOrSubsets(new int[]{3, 1}));
        System.out.println("s = " + s.countMaxOrSubsets(new int[]{2, 2, 2}));
        System.out.println("s = " + s.countMaxOrSubsets(new int[]{3, 2, 1, 5}));
    }
}
