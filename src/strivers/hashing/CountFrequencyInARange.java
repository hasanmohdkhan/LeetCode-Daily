package strivers.hashing;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Auther : hasan.khan
 * @Created : 24-Feb-24
 * @Description : <a href="">link</a>
 */
public class CountFrequencyInARange {

    public static int[] countFrequency(int n, int x, int []nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[n];

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

     //   System.out.println("map = " + map);

        for (int i = 1; i <=n; i++) {
            if(map.containsKey(i)){
                res[i-1]= map.get(i);
            }
        }
       // System.out.println("res = " + Arrays.toString(res));



        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 1, 9, 2, 7};
        System.out.println("countFrequency() = " + Arrays.toString(countFrequency(6,9,a)));
    }
}
