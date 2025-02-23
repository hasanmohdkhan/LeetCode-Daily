package strivers.recurssion.study25.findsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 07-Feb-25
 * @Description : <a href="https://leetcode.com/problems/combination-sum/?envType=problem-list-v2&envId=backtracking">link</a>
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(0, target, new ArrayList<>(), res, candidates);
        return res;
    }

    private void backtracking(int idx, int target, ArrayList<Integer> curr, List<List<Integer>> res, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            curr.add(candidates[i]);
            target -= candidates[i];
            backtracking(i, target, curr, res, candidates);
            target += candidates[i];
            curr.remove(curr.size() - 1);
        }
    }


    public static void main(String[] args) {
        CombinationSum s = new CombinationSum();
        System.out.println("s = " + s.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println("s = " + s.combinationSum(new int[]{2,3,5}, 8));
        System.out.println("s = " + s.combinationSum(new int[]{8,7,4,3}, 11));
    }
}
