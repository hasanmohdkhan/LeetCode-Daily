package strivers.linkedlist.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 07-Jan-25
 * @Description : <a href="https://leetcode.com/problems/last-visited-integers/">link</a>
 */
public class LastVisited {
    public List<Integer> lastVisitedIntegers(int[] num) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> seen = new ArrayList<>();
        int k = 0;

        for (int val : num) {
            if (val == -1) {
                k++;
                if (k <= seen.size()) {
                    ans.add(seen.get(k - 1));
                } else {
                    ans.add(-1);
                }
            } else {
                seen.add(0,val);
                k = 0;
            }
           // System.out.println("seen = " + seen);

        }

        return ans;
    }


    public static void main(String[] args) {
        LastVisited s = new LastVisited();
        System.out.println("s = " + s.lastVisitedIntegers(new int[]{1, 2, -1, -1, -1}));
        System.out.println("s = " + s.lastVisitedIntegers(new int[]{1, -1, 2, -1, -1}));
    }
}
