package strivers.recurssion.study25.findsum;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 05-Feb-25
 * @Description : <a href="https://leetcode.com/problems/permutations/?envType=problem-list-v2&envId=backtracking">link</a>
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] bol = new boolean[nums.length];
        backtracking(bol, res, new ArrayList<>(), nums);
        return res;
    }

    public void backtracking(boolean[] bol, List<List<Integer>> res, List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
           if(res.contains(curr)) return;
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (bol[i]) continue; //skip if duplicate
            bol[i] = true;
            curr.add(nums[i]);
            backtracking(bol, res, curr, nums);
            bol[i] = false;
            curr.remove(curr.size() - 1);
        }
    }


    public static void main(String[] args) {
        Permutations s = new Permutations();
        System.out.println("s = " + s.permute(new int[]{1, 2, 3}));
        System.out.println("s = " + s.permute(new int[]{1,1,2}));
    }
}
