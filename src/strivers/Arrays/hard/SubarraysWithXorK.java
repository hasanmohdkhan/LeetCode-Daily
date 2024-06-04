package strivers.Arrays.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 07-May-24
 * @Description :
 */
public class SubarraysWithXorK {

    public static int subarraysWithSumKBrute(int[] a, int b) {
        int res = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int xor = 0;
                for (int k = i; k <= j; k++) {
                    xor = xor ^ a[k];
                }
                if (xor == b) res++;
            }
        }

        return res;
    }

    public static int subarraysWithSumKBetter(int[] a, int b) {
        int cnt = 0;

        for (int i = 0; i < a.length; i++) {
            int xor = 0;
            for (int j = i; j < a.length; j++) {
                xor = xor ^ a[j];

                if (xor == b) cnt++;
            }
        }

        return cnt;
    }


    public static int subarraysWithSum(int[] a, int b) {
        int cnt = 0;
        int xor = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(xor, 1);

        for (int j : a) {
            xor = xor ^ j;
            int x = xor ^ b;

            if (map.containsKey(x)) {
                cnt += map.get(x);
            }

            if (map.containsKey(xor)) map.put(xor, map.get(xor) + 1);
            else map.put(xor, 1);

        }

        return cnt;
    }

    public static void main(String[] args) {
        int b = 2;
        int[] a = {1, 2, 3, 2};

        System.out.println("a = " + subarraysWithSumKBrute(a, b));
        System.out.println("a = " + subarraysWithSumKBetter(a, b));
        System.out.println("a = " + subarraysWithSum(a, b));
    }
}
