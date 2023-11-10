package arrays.easy;

/**
 * @Auther : hasan.khan
 * @Created : 15-Oct-23
 * @Description : <a href="https://leetcode.com/problems/number-of-good-pairs/description/">Link</a>
 */
public class NumberOfGoodPairs {

   /* public int numIdenticalPairs(int[] nums) {
        int count = 0;
        int[] countArr = new int[nums.length];

        for (int  i =0 ; i< nums.length; i++) {
            countArr[i]++;
        }

        System.out.println("countArr = " + Arrays.toString(countArr));

        for (int i = 0; i < countArr.length; i++) {
            int n = countArr[i];
            count+= n*(n-1)/2;
        }

      *//*  System.out.println("count = " + count);
        System.out.println("map = " + map);*//*

        return count;
        // 2*3-> 6/2 -> 3.. +1

    }*/

    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        int[] countArr = new int[101];

        for (int num : nums) {
            countArr[num]++;
        }
        //  System.out.println("countArr = " + Arrays.toString(countArr));

        for (int n : countArr) {
            count += n * (n - 1) / 2;
        }

        //   System.out.println("count = " + count);
        // System.out.println("map = " + map);

        return count;

    }

    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 1, 1, 3};
        int[] arr = {1,2,3};
        //  int[] arr = {1,1,1,1};
        NumberOfGoodPairs pairs = new NumberOfGoodPairs();
        System.out.println("pairs = " + pairs.numIdenticalPairs(arr));

    }
}
