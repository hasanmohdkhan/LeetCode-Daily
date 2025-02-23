package strivers.recurssion.study25;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 31-Jan-25
 * @Description : <a href="">link</a>
 */
public class PowerSubset {

    public List<List<Integer>> subsetsBackTracking(int[] nums) {
       List<List<Integer>> result  = new ArrayList<>();
       backtracking(0,nums , new ArrayList<>() , result);
       return result;
    }

    private void backtracking(int index, int[] nums, ArrayList<Integer> current, List<List<Integer>> result) {
        if(index == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        backtracking(index+1, nums,current, result);
        current.add(nums[index]);
        backtracking(index+1,nums,current,result);
        current.remove(current.size() -1);
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int noOfCombination = 1 << n;

        for (int mask = 0; mask < noOfCombination; mask++) {
            List<Integer> subset = new ArrayList<>();

            for (int i = 0; i < n; i++) {
               // System.out.println("i = " + (1<< i));
                if((mask & (1 << i)) != 0) subset.add(nums[i]);
            }
            res.add(subset);
        }

        return res;
    }

    public static void main(String[] args) {
        PowerSubset s = new PowerSubset();
        System.out.println("s = " + s.subsetsBackTracking(new int[]{1,2,3}));
        System.out.println("s = " + s.subsets(new int[]{1,2,3,4,5,6,7,8,9}));
    }


}
