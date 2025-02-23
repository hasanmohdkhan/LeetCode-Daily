package strivers.recurssion.study25.findsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 03-Feb-25
 * @Description : <a href="">link</a>
 */
public class FindSum {

    private List<List<Integer>> findSum(int[] arr, int sum) {
        List<List<Integer>> list = new ArrayList<>();

        backtracking(0, 0, list, sum, new ArrayList<>(), arr);

        return list;
    }

    private void backtracking(int index, int initSum, List<List<Integer>> res, int sum, List<Integer> current, int[] arr) {
        if (index == arr.length) {
            if (initSum == sum) {
                res.add(new ArrayList<>(current));
            }
            return;
        }

        current.add(arr[index]);
        initSum += arr[index];
        backtracking(index + 1, initSum, res, sum, current, arr);
        initSum -= arr[index];
        current.remove(current.size() - 1);

        backtracking(index + 1, initSum, res, sum, current, arr);

    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking1(0,  target, res, new ArrayList<>(), candidates);
        return res;
    }

    private void backtracking1(int idx, int target,  List<List<Integer>> res, List<Integer> curr, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // if we have found duplicate leave it
            if(i > idx && candidates[i] == candidates[i-1]) continue;
            // current element is greater than target, so no need to continue
            if(candidates[i] > target) break;
            curr.add(candidates[i]);
            target -= candidates[i];
            backtracking1(i+1, target, res, curr, candidates);
            target += candidates[i];
            curr.remove(curr.size() - 1);
        }


    }

    public static void main(String[] args) {
        FindSum s = new FindSum();
        // System.out.println("s = " + s.findSum(new int[]{1, 2, 1}, 2));
                                                        // 1,1,2,5,6,7,10
        System.out.println("s = " + s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        //System.out.println("s = " + s.combinationSum(new int[]{2, 3, 6, 7}, 7));
         System.out.println("s = " + s.combinationSum2(new int[]{2,5,2,1,2}, 5));

    }


}
