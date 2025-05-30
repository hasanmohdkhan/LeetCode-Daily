package strivers.bitmanipulation.misc.medium;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 09-May-25
 * @Description : <a href="">link</a>
 */
public class MaxiNumberOfSubArray {

    public int maxSubarrays(int[] nums) {
        if (nums.length == 0) return 0;

        int ans = 0;
        int target = nums[0];
        for (int i = 1; i < nums.length; i++) target &= nums[i];

        if (target != 0) return 1;

        //  System.out.println("nums = " + Arrays.toString(nums));
        // System.out.println("target = " + target);

        int curr = Integer.MAX_VALUE;
        for (int num : nums) {
            curr &= num;
            if (curr == 0) {
                ans++;
                curr = Integer.MAX_VALUE;
            }
        }


        return ans;
    }


    public int maxFreqSum(String s) {

        // successes
        //'a', 'e', 'i', 'o', or 'u'©leetcode
        HashMap<Character, Integer> vol = new HashMap<>();
        HashMap<Character, Integer> cons = new HashMap<>();

        Set<Character> vo = new HashSet<>();
        vo.add('a');
        vo.add('e');
        vo.add('i');
        vo.add('o');
        vo.add('u');

        for (char v : s.toCharArray()) {
            if (vo.contains(v)) {
                vol.put(v, vol.getOrDefault(v, 0) + 1);
            }
        }
        //  System.out.println("vol = " + vol);

        int volM = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> m : vol.entrySet()) {
            volM = Math.max(volM, m.getValue());
        }
        //  System.out.println("volM = " + volM);


        for (char v : s.toCharArray()) {
            if (!vo.contains(v)) {
                cons.put(v, cons.getOrDefault(v, 0) + 1);
            }
        }

        // System.out.println("cons = " + cons);


        int conM = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> m : cons.entrySet()) {
            conM = Math.max(conM, m.getValue());
        }
        if (conM == Integer.MIN_VALUE) conM = 0;
        if (volM == Integer.MIN_VALUE) volM = 0;
        // System.out.println("con = " + conM);


        return conM + volM;
    }

    public int minOperations(int[] nums) {
        List<Integer> m = new ArrayList<>(); // 0,2  // 3,1,2,1
        int mini = nums[0];
        m.add(mini);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= mini) {
                mini = nums[i];
                m.add(mini);
            }
        }
        //System.out.println("m = " + m);

        int x = 0;
        int zx = 0;
        int minn = nums.length;
        for (int i = m.size() - 1; i >= 0; i--) {
            if (x == m.get(i)) {
                zx++;
            } else {
                x = m.get(i);
                zx++;
            }

            minn = Math.min(x + (nums.length - zx), minn);
        }


        return minn;
    }


    public int minDeletion(String s, int k) {
        HashMap<Character, Integer> uni = new HashMap<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            uni.put(c, uni.getOrDefault(c, 0) + 1);
        }
        System.out.println("uni = " + uni);

        if (uni.size() <= k) return 0;

        ArrayList<Integer> list = new ArrayList<>(uni.values());
        System.out.println("list = " + list);
        Collections.sort(list);
        System.out.println("list = " + list);

        int dst = list.size();
        int i = 0;
        while (dst > k) {
            count += list.get(i);
            i++;
            dst--;
        }

        System.out.println("count = " + count);

        return count;
    }




    public static void main(String[] args) {
        MaxiNumberOfSubArray s = new MaxiNumberOfSubArray();

        System.out.println("s = " + s.minDeletion("aabb", 2));
        System.out.println("s = " + s.minDeletion("yyyzz", 1));
        System.out.println("s = " + s.minDeletion("abc", 2));
        System.out.println("s = " + s.minDeletion("fgcww", 2));

     /*   System.out.println("s = " + s.minOperations(new int[]{0,2}));
        System.out.println("s = " + s.minOperations(new int[]{3,1,2,1}));
        System.out.println("s = " + s.minOperations(new int[]{1,2,1,2,1,2}));
        System.out.println("s = " + s.minOperations(new int[]{4,4}));*/
       /* System.out.println("s = " + s.maxFreqSum("successes"));
        System.out.println("s = " + s.maxFreqSum("aeiaeia"));
*/

        /*  *//*  System.out.println("s = " + s.maxSubarrays(new int[]{1, 0, 2, 0, 1, 2}));
        System.out.println("s = " + s.maxSubarrays(new int[]{5, 7, 1, 3}));*//*
         *//* System.out.println("s = " + s.maxSubarrays(new int[]{0, 0}));
        System.out.println("s = " + s.maxSubarrays(new int[]{1, 0}));
        System.out.println("s = " + s.maxSubarrays(new int[]{1, 1}));*//*
        System.out.println("s = " + s.maxSubarrays(new int[]{22,21,29,22}));*/
    }

}
