package Daily.december;

import tool.Analysis;

import java.util.Arrays;



/**
 * @Auther : hasan.khan
 * @Created : 26-Dec-23
 * @Description : <a href="https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/description/?envType=daily-question&envId=2023-12-26">link</a>
 */
public class NumberOfDiceRollsWithTargetSum {
    private final long mod = 1000000007;
    int[][] mamo = new int[32][1002];

    public int numRollsToTarget(int dice, int k, int target) {
        for (int i = 0; i < 32; i++) {
            Arrays.fill(mamo[i], -1);
        }
        return solved(dice, k, target);
    }

    private int solved(int dice, int k, int target) {
        if (target < 0 || dice == 0)
            return target == 0 ? 1 : 0;

        if (mamo[dice][target] != -1) return mamo[dice][target];

        int ways = 0;

        for (int face = 1; face <= k; face++) {
            ways = (ways + solved(dice - 1, k, target - face)) % (int) mod;
        }
        return mamo[dice][target] = ways;
    }

    public static void main(String[] args) {
        NumberOfDiceRollsWithTargetSum res = new NumberOfDiceRollsWithTargetSum();
        System.out.println("res = " + res.numRollsToTarget(1, 6, 3));
        System.out.println("res = " + res.numRollsToTarget(2, 6, 7));
        Analysis analysis = new Analysis();
        System.out.println("res = " + res.numRollsToTarget(30, 30, 500));
     //   System.out.println("res = " + res.numRollsToTarget(15, 15, 250));
        analysis.end();
    }
}
