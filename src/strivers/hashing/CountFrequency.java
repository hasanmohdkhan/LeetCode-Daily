package strivers.hashing;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;


/**
 * @Auther : hasan.khan
 * @Created : 24-Feb-24
 * @Description : <a href="">link</a>
 */
public class CountFrequency {

    public static int[] getFrequencies(int[] nums) {
       TreeMap<Integer, Integer> map = new TreeMap<>();
       // Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        System.out.println("res = " + map);

        int minCount = Integer.MAX_VALUE;
        int maxCount = 0;
        int minElement = 0;
        int maxElement = 0;

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int v = e.getValue();
            int k = e.getKey();

            if (v > maxCount) {
                maxCount = v;
                maxElement = k;
            }

            if (v < minCount) {
                minCount = v;
                minElement = k;
            }

        }
        // System.out.println("maxElement = " + maxElement);
        // System.out.println("minElement = " + minElement);

        res[0] = maxElement;
        res[1] = minElement;

        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 1, 4};
        int[] a1 = {10, 10, 10, 3, 3, 3};
        int[] a2 = {12 ,17 ,16 };
        System.out.println("getFrequencies() = " + Arrays.toString(getFrequencies(a)));
        System.out.println("getFrequencies() = " + Arrays.toString(getFrequencies(a1)));
        System.out.println("getFrequencies() = " + Arrays.toString(getFrequencies(a2)));
    }
}
