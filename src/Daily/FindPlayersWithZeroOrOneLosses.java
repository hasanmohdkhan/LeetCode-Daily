package Daily;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Auther : hasan.khan
 * @Created : 15-Jan-24
 * @Description : <a href="https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/">link</a>
 */
public class FindPlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        int[] losses = new int[100001];
        List<List<Integer>> list = new ArrayList<>();

        for (int[] match : matches) {
            int win = match[0];
            int loss = match[1];

            if (losses[win] == 0) {
                losses[win] = -1;
            }

            if (losses[loss] == -1) {
                losses[loss] = 1;
            } else {
                losses[loss]++;
            }
        }

        List<Integer> win = new ArrayList<>();
        List<Integer> loss = new ArrayList<>();


        for (int i = 0; i < losses.length; i++) {
            if (losses[i] == -1) win.add(i);
            else if (losses[i] == 1) loss.add(i);
        }


        list.add(win);
        list.add(loss);


        return list;
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};

        int[][] ints2 = {{2, 3}, {1, 3}, {5, 4}, {6, 4}};

        FindPlayersWithZeroOrOneLosses o = new FindPlayersWithZeroOrOneLosses();
        System.out.println("o = " + o.findWinners(ints));
        System.out.println("o2 = " + o.findWinners(ints2));

    }

}
