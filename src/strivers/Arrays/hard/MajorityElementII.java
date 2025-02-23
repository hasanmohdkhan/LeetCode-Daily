package strivers.Arrays.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther : hasan.khan
 * @Created : 30-Apr-24
 * @Description : <a href="">link</a>
 */
public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int freq = (int) (nums.length / 3) + 1;

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (!m.containsKey(num)) m.put(num, 1);
            else m.put(num, m.getOrDefault(num, 1) + 1);
            if (m.get(num) > freq && !list.contains(num)) list.add(num);
        }

        list.sort((o1, o2) -> 0);
        return list;
    }

    public List<Integer> majorityElementMooreVoting(int[] nums) {
        int cnt1 = 0;
        int cnt2 = 0;

        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (cnt1 == 0 && el2 != num) {
                cnt1 = 1;
                el1 = num;
            } else if (cnt2 == 0 && el1 != num) {
                cnt2 = 1;
                el2 = num;
            } else if (el1 == num) {
                cnt1++;
            } else if (el2 == num) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }

        }

        // manually checking here
        cnt1 = 0;
        cnt2 = 0;

        for (int num : nums) {
            if (el1 == num) cnt1++;
            if (el2 == num) cnt2++;
        }

        int mini = (int) (nums.length / 3) + 1;

        List<Integer> l = new ArrayList<>();

        if ( cnt1 >= mini && el1 != Integer.MIN_VALUE) l.add(el1);
        if ( cnt2  >= mini && el2 != Integer.MIN_VALUE) l.add(el2);

        return l;

    }

    public static void main(String[] args) {
        MajorityElementII m = new MajorityElementII();

        int[] a = {3, 2, 3};
        int[] b = {1};
        int[] c = {1, 2};
        int[] c1 = {0, 2, 0, 0, 1};


        System.out.println("m = " + m.majorityElementMooreVoting(a));
        System.out.println("m = " + m.majorityElementMooreVoting(b));
        System.out.println("m = " + m.majorityElementMooreVoting(c));
        System.out.println("m = " + m.majorityElementMooreVoting(c1));
    }

}
