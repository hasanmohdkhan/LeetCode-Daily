package strivers.Arrays.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 19-Mar-24
 * @Description : <a href="">link</a>
 */
public class TwoSum {

    public static String readBurte(int n, int[] book, int target) {

        //{4, 1, 2, 3, 1}
        for (int i = 0; i < book.length; i++) {
            for (int j = i + 1; j < book.length; j++) {
                int sum = book[i] + book[j];
                if (sum == target) {
                    return "YES";
                }

            }
        }


        return "NO";
    }

    public static String read(int n, int[] book, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < book.length; i++) { //{4, 1, 2, 3, 1} , 5
            int needed = target - book[i];

            if (map.containsKey(needed)) {
                return "YES";
            }
            map.put(book[i], i);

        }


        return "NO";
    }

    public static void main(String[] args) {
        int n = 5;
        int target = 5;
        int[] book = {4, 1, 2, 3, 1};
        System.out.println("read = " + read(n, book, target));

    }
}
