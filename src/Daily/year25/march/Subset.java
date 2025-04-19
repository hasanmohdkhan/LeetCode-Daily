package Daily.year25.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 06-Mar-25
 * @Description : <a href="">link</a>
 */
public class Subset {

    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        Arrays.sort(nums);
        backTrack1(0, new ArrayList<>(), subset, nums);
        return subset;
    }

    private void backTrack1(int index, ArrayList<Integer> temp, List<List<Integer>> subset, int[] nums) {
        subset.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            backTrack1(i + 1, temp, subset, nums);
            temp.remove(temp.size() - 1);
        }


    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, new ArrayList<>(), res, nums);
        return res;
    }

    public void backtrack(int index, List<Integer> temp , List<List<Integer>> res ,int[] nums){
        res.add(new ArrayList<>(temp));

        for (int i= index ; i< nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);

            backtrack(i+1, temp, res, nums);
            temp.remove(temp.size() -1);
        }

    }

    public static void main(String[] args) {
        Subset s = new Subset();
        //  System.out.println("s = " + s.subsets2(new int[]{1, 2, 3}));
        //  System.out.println("sm = " + s.subsets(new int[]{1, 2, 3}));
        //  System.out.println("s = " + s.subsetsS(new int[]{1, 2, 3}));
        System.out.println("s = " + s.subsetsWithDup(new int[]{1, 2, 2}));

       //  [[],[1],[1,2],[1,2,2],[2],[2,2]]
    }
}
