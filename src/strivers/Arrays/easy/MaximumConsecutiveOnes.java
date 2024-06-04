package strivers.Arrays.easy;

/**
 * @Auther : hasan.khan
 * @Created : 09-Mar-24
 * @Description : <a href="">link</a>
 */
public class MaximumConsecutiveOnes {


    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }

        }
        max = Math.max(max, count);
        return max;
    }

    public static int traffic(int n, int m, int[] vehicle) {
        int count = 0;
        int res = 0;
        int leftIdx = 0;

        for (int rightIdx = 0; rightIdx < vehicle.length; rightIdx++) {
            if (vehicle[rightIdx] == 0) count++;

            while (count > m) {
                if (vehicle[leftIdx] == 0) count--;
                leftIdx++;
            }
            res = Math.max(res, rightIdx - leftIdx + 1);

        }


        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 0, 1, 1, 1};
        int[] a1 = {0 ,1 ,0 ,0 ,1, 0};

        int[] a2 = {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0};
        // System.out.println("a = " + new MaximumConsecutiveOnes().findMaxConsecutiveOnes(a1));
     //   System.out.println("traffic() = " + traffic(25, 17, a2));
      //  System.out.println("traffic() = " + traffic(6, 3, a1));
        int[] a3 = {0 ,1 ,1};
        System.out.println("traffic() = " + traffic(3, 1, a3));

    }
}
