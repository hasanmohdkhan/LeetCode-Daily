package strivers.bitmanipulation.misc;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 11-Apr-25
 * @Description : <a href="">link</a>
 */
public class ConstructTheMinimumBitwiseArrayI {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] res = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            for (int x = 0; x < nums.get(i); x++) {
                if ((x | (x + 1)) == nums.get(i)) {
                    res[i] = x;
                    break;
                }
            }
            if(res[i] == 0) res[i] = -1;
        }

      //  System.out.println("res = " + Arrays.toString(res));

        return res;
    }

    public static void main(String[] args) {
        ConstructTheMinimumBitwiseArrayI s = new ConstructTheMinimumBitwiseArrayI();
        System.out.println("s = " + Arrays.toString(s.minBitwiseArray(List.of(2, 3, 5, 7))));
        System.out.println("s = " + Arrays.toString(s.minBitwiseArray(List.of(11, 13, 31))));
    }
}
