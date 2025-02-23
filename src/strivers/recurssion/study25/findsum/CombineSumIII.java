package strivers.recurssion.study25.findsum;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 10-Feb-25
 * @Description : <a href="https://leetcode.com/submissions/detail/1538212527/">link</a>
 */
public class CombineSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(1, 0, new ArrayList<>(), res, k,n);
        return res;
    }

    private void backTracking(int idx, int initSum, ArrayList<Integer> curr, List<List<Integer>> res, int k, int n) {
        if(initSum > n) return;
        if(curr.size() == k  && initSum == n){
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < 10; i++) {
            initSum += i;
            curr.add(i);
            backTracking(i+1, initSum, curr,res,k, n);
            initSum-=i;
            curr.remove(curr.size() -1);
        }

    }

    public static void main(String[] args) {
        CombineSumIII s = new CombineSumIII();
        System.out.println("s = " + s.combinationSum3(3,7));
        System.out.println("s = " + s.combinationSum3(3,9));
        System.out.println("s = " + s.combinationSum3(4,1));
    }


}
