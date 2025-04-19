package Daily.year25.march;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 01-Mar-25
 * @Description : <a href="">link</a>
 */
public class Day1 {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]== nums[i+1]){
                nums[i]*=2;
                nums[i+1]=0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                int s = i;
                while (s < nums.length ){
                    if(nums[s] != 0){
                        nums[i] = nums[s];
                        nums[s] = 0;
                        break;
                    }
                    s++;
                }
            }
        }


        return nums;
    }


    public static void main(String[] args) {
        Day1 s = new Day1();
        System.out.println("s = " + Arrays.toString(s.applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
        System.out.println("s = " + Arrays.toString(s.applyOperations(new int[]{0,1})));
    }
}
