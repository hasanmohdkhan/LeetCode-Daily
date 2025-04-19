package Daily.year25.march;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 02-Mar-25
 * @Description : <a href="">link</a>
 */
public class Day2 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> res = new TreeMap<>();

        for (int[] ints : nums1) res.put(ints[0], ints[1]);

        for (int[] ints : nums2) {
            if (res.containsKey(ints[0])) res.put(ints[0], res.get(ints[0]) + ints[1]);
            else res.put(ints[0], ints[1]);
        }

        int[][] ans = new int[res.size()][2];
        int i = 0;

        for (Map.Entry<Integer, Integer> map : res.entrySet()) {
            ans[i][0] = map.getKey();
            ans[i][1] = map.getValue();
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Day2 s = new Day2();
        //   System.out.println("s = " + Arrays.deepToString(s.mergeArrays(new int[][]{{1, 2}, {2, 3}, {4, 5}}, new int[][]{{1, 4}, {3, 2}, {4, 1}})));
        System.out.println("s = " + s.subsets(new int[]{1, 2, 3}));

    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(0, new ArrayList<>(), res, nums);
        return res;
    }

    private void backtracking(int index, List<Integer> curr, List<List<Integer>> res, int[] nums) {
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        backtracking(index + 1, curr, res, nums);
        curr.add(nums[index]);
        backtracking(index + 1, curr, res, nums);
        curr.remove(curr.size() - 1);

    }
}
