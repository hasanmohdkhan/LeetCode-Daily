package strivers.Arrays.medium;

/**
 * @Auther : hasan.khan
 * @Created : 01-Apr-24
 * @Description : <a href="https://leetcode.com/problems/subarray-sum-equals-k/">link</a>
 */
public class SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int ans = 0;
      //  System.out.println("nums = " + Arrays.toString(nums));


      /*  for (int i = 0; i < nums.length; i++) { //-1,-1,1 -> 1
            if (nums[i] == k) {
                ans++;
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == k) {// -1 + -1 =
                    ans++;
                    break;
                }
            }
        }*/

        int i =0;
        int j = nums.length - 1;

        while (i < j){
            if(nums[i]+nums[j] == k){
                ans++;
            }
            i++;
            j--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1};
        int[] ab = {1, 2, 3};
        int[] a1= {-1,-1,1};
        SubArraySumEqualsK k = new SubArraySumEqualsK();
        System.out.println("k = " + k.subarraySum(a, 2));
        System.out.println("k = " + k.subarraySum(ab, 3));
        System.out.println("k = " + k.subarraySum(a1, 0));
    }
}
