package Daily.year25.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 03-Mar-25
 * @Description : <a href="">link</a>
 */
public class Day3 {

    public int[] pivotArray(int[] nums, int pivot) {

        List<Integer> less = new ArrayList<>();
        List<Integer> gr = new ArrayList<>();
        List<Integer> eq = new ArrayList<>();

        int ind = 0;
        while (ind < nums.length) {
            if (nums[ind] < pivot) less.add(nums[ind]);
            if (nums[ind] > pivot) gr.add(nums[ind]);
            if (nums[ind] == pivot) eq.add(nums[ind]);
            ind++;
        }

        int f = 0;
        for (Integer item : less) nums[f++] = item;
        for (Integer value : eq) nums[f++] = value;
        for (Integer integer : gr) nums[f++] = integer;


        return nums;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        System.out.println("candidates = " + Arrays.toString(candidates));
        backtrack(0 ,new ArrayList<>(), res, candidates, target);
        return res;
    }

    private void backtrack(int index, List<Integer> curr, List<List<Integer>> res, int[] candidates, int target) {
        if (target==0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if(candidates[i]> target) break;
            curr.add(candidates[i]);
            target -= candidates[i];
            backtrack(i , curr, res, candidates, target);
            curr.remove(curr.size() - 1);
            target += candidates[i];
        }

    }

    public static void main(String[] args) {
        Day3 s = new Day3();
       /* System.out.println("s = " + Arrays.toString(s.pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)));
        System.out.println("s = " + Arrays.toString(s.pivotArray(new int[]{-3, 4, 3, 2}, 2)));
        System.out.println("s = " + Arrays.toString(s.pivotArray(new int[]{4, 0, 4, 5, -11}, 5)));*/
        //  System.out.println("s = " + Arrays.toString(s.pivotArray(new int[]{4,0,4,-11,5}, 5)));

        System.out.println("s = " + s.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }


}
