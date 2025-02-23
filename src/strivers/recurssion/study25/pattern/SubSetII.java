package strivers.recurssion.study25.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 09-Feb-25
 * @Description : <a href="">link</a>
 */
public class SubSetII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(0, new ArrayList<>(), res, nums);
        return res;
    }

    private void backTracking(int index, ArrayList<Integer> curr, List<List<Integer>> res, int[] nums) {
        res.add(new ArrayList<>(curr));

        for (int i = index; i < nums.length; i++) {
            if( i != index  && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            backTracking(i+1 ,curr, res, nums);
            curr.remove(curr.size() - 1);

        }

    }

    public static void main(String[] args) {
        SubSetII s = new SubSetII();
        System.out.println("s = " + s.subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println("s = " + s.subsetsWithDup(new int[]{0}));
    }
}
