package strivers.Arrays.hard;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 01-May-24
 * @Description : <a href="">link</a>
 */
public class ThreeSum {
    public List<List<Integer>> threeSumBrute(int[] nums) {
        Set<List<Integer>> dupCheck = new HashSet<>();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> currList = Arrays.asList(nums[i], nums[j], nums[k]);
                        currList.sort(null);
                        dupCheck.add(currList);
                    }
                }
            }
        }

        return new ArrayList<>(dupCheck);
    }


    public List<List<Integer>> threeSumBetter(int[] nums) {
        Set<List<Integer>> dupCheck = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> st = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int thirdNum = -(nums[i] + nums[j]);

                if (st.contains(thirdNum)) {
                    List<Integer> currList = Arrays.asList(nums[i], nums[j], thirdNum);
                    currList.sort(null);
                    dupCheck.add(currList);
                }
                st.add(nums[j]);
            }
        }


        ArrayList<List<Integer>> lists = new ArrayList<>(dupCheck);
        return lists;
    }

    public List<List<Integer>> threeSumOptimal(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
       // System.out.println("nums = " + Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> l = Arrays.asList(nums[i], nums[j], nums[k]);
                    lists.add(l);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }


            }


        }


        return lists;
    }


    public static void main(String[] args) {
        ThreeSum sum = new ThreeSum();

        int[] a = {-1, 0, 1, 2, -1, -4}; //[-4, -1, -1, 0, 1, 2]
        int[] b = {0, 1, 1};
        int[] c = {0, 0, 0, 0};
        int[] c1 = {-18, -1, -44, -48, -9, -16, -36, -13, 29, 17, -12, 9, -49};


        System.out.println("sum = " + sum.threeSumOptimal(a));
        System.out.println("sum = " + sum.threeSumOptimal(b));
        System.out.println("sum = " + sum.threeSumOptimal(c));
        System.out.println("sum = " + sum.threeSumOptimal(c1));
    }

}
