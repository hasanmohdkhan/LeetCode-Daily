package medium;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 18-Sep-23
 * @Description:
 */
public class TopKFrequentElements {
    /**
     * Brute force solution
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }


        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        int[] res = new int[k];

        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> map.get(b) - map.get(a));// sorting ascending order i.e. 1,2,3

      /*  System.out.println("map = " + map);
        System.out.println("map.keySet() = " + map.keySet());
        System.out.println("list = " + list);*/

        for (int i = 0; i < k; i++) res[i] = list.get(i);

        System.out.println("res = " + Arrays.toString(res
        ));

        return res;

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;
        TopKFrequentElements kFrequentElements = new TopKFrequentElements();
        System.out.println("Result =" + Arrays.toString(kFrequentElements.topKFrequent(arr, k)));
    }
}
