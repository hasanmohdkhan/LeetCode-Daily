package arrays.easy;

/**
 * @Auther : hasan.khan
 * @Created : 13-Oct-23
 * @Description : <a href="https://leetcode.com/problems/sum-of-all-odd-length-subarrays/description/">Link</a>
 */
public class SumOfAllOddLengthSubArrays {

    /**
     * Brute Force
     *
     * @param arr arr
     * @return sum
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int total = 0;

        for (int left = 0; left < arr.length; left++) {
            int currentSum = 0;
            for (int right = left; right < arr.length; right++) {
                currentSum += arr[right];
             //   System.out.println("Right= "+left +" right = " + right  );
                int cal = right - left + 1; // left+1 may be next index?
                if (cal % 2 == 1) {
                    total += currentSum;
                //    System.out.println("total  = " + total + " curr: "+currentSum);
                 //   System.out.println("if = " + cal + " , odd: "+cal%2 + " , val "+arr[right]);
                }
            }
           // System.out.println("-----");

        }



        return total;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};
        SumOfAllOddLengthSubArrays sum = new SumOfAllOddLengthSubArrays();
        System.out.println("sum = " + sum.sumOddLengthSubarrays(arr));

    }
}
