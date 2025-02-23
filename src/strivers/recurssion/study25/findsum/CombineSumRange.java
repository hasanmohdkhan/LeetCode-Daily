package strivers.recurssion.study25.findsum;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 11-Feb-25
 * @Description : <a href="https://leetcode.com/submissions/detail/1539084124/">link</a>
 */
public class CombineSumRange {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(1, res, new ArrayList<>(), n, k);
        return res;
    }

    private void backTracking(int idx, List<List<Integer>> res, ArrayList<Integer> curr, int n, int k) {
          if(curr.size() == k){
              res.add(new ArrayList<>(curr));
              return;
          }

        for (int i = idx; i <= n; i++) {
            curr.add(i);
            backTracking(i+1,res,curr,n,k);
            curr.remove(curr.size() -1);
        }

    }

    public static void main(String[] args) {
        CombineSumRange s = new CombineSumRange();
        System.out.println("s = " + s.combine(4, 2));
        System.out.println("s = " + s.combine(1, 1));
        //System.out.println("s = " + s.combine(1, 1));
    }
}
