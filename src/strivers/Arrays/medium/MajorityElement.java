package strivers.Arrays.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 20-Mar-24
 * @Description : <a href="">link</a>
 */
public class MajorityElement {
    public static int majorityElementBrute(int[] v) {

        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;
        int idx = 0;

        for (int j : v) {
            freq.put(j, freq.getOrDefault(j, 0) + 1);
            if (freq.get(j) >= v.length / 2 && (max < freq.get(j))) {
                max = freq.get(j);
                System.out.println("m = " + max + " get " + freq.get(j));

                idx = j;
            }
        }

        // System.out.println("freq = " + idx);


        return idx;
    }

    public static int majorityElement(int[] v) {
     //TODO: Optimal Approach: Moore’s Voting Algorithm:
        int count = 0;
        Integer element = -1;


        for (int j : v) {
            if (count == 0) {
                count = 1;
                element = j;
            } else if (j == element) count++;
            else count--;

        }


        int c = 0;
        for (int j : v) {
            if (element == j) {
                c++;
            }
        }

        if(c > (v.length/2)){
            return element;
        }

        return -1;
    }


    public static void main(String[] args) {
        ///int[] a = {2, 2, 1, 3, 1, 1, 3, 1, 1};
        //  int[] a1 = {2, 2, 1, 1, 1, 2, 2};
        int[] a2 = {3, 3, 4};
        // System.out.println("s = " + majorityElement(a));
        System.out.println("s = " + majorityElement(a2));
    }


}
