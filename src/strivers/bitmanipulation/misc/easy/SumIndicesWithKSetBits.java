package strivers.bitmanipulation.misc.easy;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 30-Apr-25
 * @Description : <a href="">link</a>
 */
public class SumIndicesWithKSetBits {


    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum =0;
        for (int i = 0; i < nums.size(); i++) {
            if(countBit(i) == k)sum+=nums.get(i);
        }
        return sum;
    }

    private int countBit(int i) {
        int count=0;
        if(i==0) return 0;
       // System.out.println("count = " + Integer.toBinaryString(i));
        while (i != 0){
            if((i & 1) != 0) count++;
            i>>=1;
        }

        return count;
    }

    public static void main(String[] args) {
        SumIndicesWithKSetBits s = new SumIndicesWithKSetBits();
        System.out.println("s = " + s.sumIndicesWithKSetBits(Arrays.asList(5,10,1,5,2),1));
        System.out.println("s = " + s.sumIndicesWithKSetBits(Arrays.asList(4,3,2,1),2));
    }
}
