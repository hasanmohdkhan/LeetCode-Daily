package contest;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 20-Apr-25
 * @Description : <a href="">link</a>
 */
public class April202025 {

    public long calculateScore(String[] instructions, int[] values) {
        int score = 0;
        Set<Integer> visited = new HashSet<>();
        int i = 0;

        while (i < instructions.length) {
          /*  System.out.println("i = " + i);
            System.out.println("visited = " + visited);
            System.out.println("score = " + score);*/

            if (visited.contains(i)) break;
            else visited.add(i);

            if (Objects.equals(instructions[i], "add")) {
                score += values[i];
            }
            if (Objects.equals(instructions[i], "jump")) {
                i = i + values[i];
                if (i < 0 || i >= instructions.length) break;
            } else {
                i++;
            }
        }


        return score;
    }

    public static void main(String[] args) {
        April202025 s = new April202025();
        String[] instructions = {
                "add", "add", "jump", "add", "jump", "add", "jump", "add", "jump", "add",
                "jump", "jump", "add", "jump", "add", "add", "jump", "add", "add", "jump",
                "jump", "add", "jump", "add", "add", "jump", "add", "jump", "jump", "add",
                "jump", "add", "add", "jump", "add", "jump", "add", "add", "jump", "add",
                "jump", "add", "add", "jump", "add", "add", "add", "jump", "jump", "add",
                "jump", "add", "jump", "add", "add", "jump"
        };

        int[] values = {
                5, 2, 10, 3, -2, 1, 8, -3, 6, 2,
                -5, 4, 7, 2, 3, 1, 15, 1, 4, 9,
                -20, 3, 8, 6, 1, 12, -15, 5, 3, 2,
                -7, 2, 1, 13, -25, 2, 4, 2, 6, 1,
                8, 2, 2, -6, 3, 1, 4, 1, -10, 2,
                -3, 1, 5, 1, 2, -8
        };

        System.out.println("s. = " + s.calculateScore(instructions, values));

      /*  System.out.println("s = " + s.calculateScore(new String[]{"jump", "add", "add", "jump", "add", "jump"},
                new int[]{2, 1, 3, 1, -2, -3}));
        System.out.println("s = " + s.calculateScore(new String[]{"jump","add","add"}, new int[]{3,1,1}));
        System.out.println("s = " + s.calculateScore(new String[]{"jump"}, new int[]{3}));
        System.out.println("s = " + s.calculateScore(new String[]{"jump"}, new int[]{-1}));*/
    }
}
