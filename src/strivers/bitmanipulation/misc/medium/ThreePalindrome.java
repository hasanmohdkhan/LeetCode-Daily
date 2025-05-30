package strivers.bitmanipulation.misc.medium;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 13-May-25
 * @Description : <a href="">link</a>
 */
public class ThreePalindrome {

    public int countPalindromicSubsequence(String s) {
        Set<String> res = new HashSet<>();

       /* for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                for (int k = j + 1; k < s.length(); k++) {
                    StringBuilder s1 = new StringBuilder("" + s.charAt(i) + s.charAt(j) + s.charAt(k));
                    int st = 0;
                    int e = s1.length() - 1;
                    while (st < e) {
                        if (s1.charAt(st) != s1.charAt(e)) break;
                        res.add(s1.toString());
                        //    System.out.println("s1 = " + s1);
                        st++;
                        e--;
                    }

                }
            }
        }*/

        int start = 0;
        int mid = start + 1;
        int end = mid + 1;
        int n = s.length();


        while (start < n - 2) {
            //  System.out.println("start = " + start + " mid = " + mid + " end = " + end);
            StringBuilder s1 = new StringBuilder("" + s.charAt(start) + s.charAt(mid) + s.charAt(end));
            int st = 0;
            int e = s1.length() - 1;
            while (st < e) {
                if (s1.charAt(st) != s1.charAt(e)) break;
                res.add(s1.toString());
                //    System.out.println("s1 = " + s1);
                st++;
                e--;
            }

            end++;
            if (end >= s.length()) {
                mid++;
                end = mid + 1;
            }

            if (mid >= s.length() - 1) {
                start++;
                mid = start + 1;
                end = mid + 1;
            }


        }


        // System.out.println("res = " + res);
        return res.size();
    }

    public int minDeletion(String s, int k) {
        int res = 0;
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char a : s.toCharArray()) freq.put(a, freq.getOrDefault(a, 0) + 1);
        if (freq.size() <= k) return 0;

        List<Integer> f = new ArrayList<>(freq.values());
        Collections.sort(f);

        int dst = f.size();

        for (Integer integer : f) {
            if (dst > k) {
                res += integer;
                dst--;
            }

        }


        return res;
    }




    public static void main(String[] args) {
        ThreePalindrome s = new ThreePalindrome();



        // System.out.println("s = " + s.countPalindromicSubsequence("aabca"));
        // System.out.println("s = " + s.minDeletion("abc", 2));
        // System.out.println("s = " + s.minDeletion("aabb", 2));

      /*  String[] strings = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        String s1 = "abcw";

        for (Character a : s1.toCharArray()) {
            for (Character b : strings[0].toCharArray()) {
                System.out.println( a + " ^ "+ b + " --- xor = " + (a ^ b ));

            }

        }
*/

      /*  System.out.println("s = " + s.countPalindromicSubsequence("adc"));
        System.out.println("s = " + s.countPalindromicSubsequence("bbcbaba"));*/
    }
}
