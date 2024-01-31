package Daily.december;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 11-Dec-23
 * @Description : <a href="https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/description/?envType=daily-question&envId=2023-12-11">link</a>
 */
public class ElementAppearingMoreThan25PercentInSortedArray {
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int j : arr) {
            freq.put(j, freq.getOrDefault(j, 0) + 1);
        }
       // System.out.println("freq = " + freq);
       // System.out.println("total = " + arr.length);

        for(Integer  i: freq.keySet() ){
          //  System.out.println("i = " + i);
            double percent = ((double) freq.get(i) /arr.length)*100 ;
           // System.out.println("percent = " + percent);
            if(percent > 25.00){
                return i;
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        int[] ar = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        int[] ar1 = {1,2,3,3};
        ElementAppearingMoreThan25PercentInSortedArray o = new ElementAppearingMoreThan25PercentInSortedArray();
        System.out.println("o = " + o.findSpecialInteger(ar));
        System.out.println("o = " + o.findSpecialInteger(ar1));
    }
}
