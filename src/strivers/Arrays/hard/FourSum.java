package strivers.Arrays.hard;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 02-May-24
 * @Description : <a href="">link</a>
 */
public class FourSum {

    public List<List<Integer>> fourSumBrute(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> curr = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            curr.sort(null);
                            set.add(curr);
                        }
                    }
                }
            }
        }


        return new ArrayList<>(set);
    }

    public List<List<Integer>> fourSumBetter(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Set<Long> st = new HashSet<>();
                for (int k = j + 1; k < nums.length; k++) {

                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = target - sum;

                    if (st.contains(fourth)) {
                        List<Integer> curr = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                        curr.sort(null);
                        set.add(curr);
                    }
                    st.add((long) nums[k]);

                }
            }
        }


        return new ArrayList<>(set);
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> and = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = nums[i];
                    sum  += nums[j];
                    sum += nums[l];
                    sum += nums[k];

                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);

                        and.add(list);
                         k++;
                         l--;

                         while (k < l && nums[k] == nums[k-1]) k++;
                         while (k < l && nums[l] == nums[l+1]) l--;

                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }

       return and;
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        int[] a = {1, 0, -1, 0, -2, 2};
        int[] b = {1000000000,1000000000,1000000000,1000000000};
        System.out.println("fs = " + fs.fourSumBetter(a, 0));
        System.out.println("fs = " + fs.fourSum(b, -294967296));
    }


    public static List<List<Integer>> fourSume(int[] nums, int target) {
        int n = nums.length; // size of the array
        List<List<Integer>> ans = new ArrayList<>();

        // sort the given array:
        Arrays.sort(nums);

        // calculating the quadruplets:
        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }

        return ans;
    }












}
