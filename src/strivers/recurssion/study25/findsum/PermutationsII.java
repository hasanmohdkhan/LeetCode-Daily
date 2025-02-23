package strivers.recurssion.study25.findsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 06-Feb-25
 * @Description : <a href="">link</a>
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];

        backtracking(used ,new ArrayList<>(), res, nums);
        return res;
    }

    public void backtracking(boolean[] used , List<Integer> curr , List<List<Integer>> res, int[] nums){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }


        for(int i=0 ; i< nums.length; i++ ){
            if(used[i]) continue;
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            curr.add(nums[i]);
            backtracking(used,curr, res, nums);
            curr.remove(curr.size()-1);
            used[i] = false;
        }

    }

    public static void main(String[] args) {
        PermutationsII p = new PermutationsII();
        System.out.println("p = " + p.permuteUnique(new int[]{1,1,2}));
        System.out.println("p = " + p.permuteUnique(new int[]{1,2,3}));
    }
}
