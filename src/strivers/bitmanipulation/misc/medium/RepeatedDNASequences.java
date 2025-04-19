package strivers.bitmanipulation.misc.medium;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 12-Apr-25
 * @Description : <a href="https://leetcode.com/problems/repeated-dna-sequences/description/?envType=problem-list-v2&envId=bit-manipulation">link</a>
 */
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) return new ArrayList<>();

        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        int winSize = 10;

        for (int i = 0; i <= s.length() - winSize; i++) {
            String substring = s.substring(i, i + winSize);
            if (!seen.add(substring)) {
                // System.out.println("i = " + substring);
                repeated.add(substring);
            }
        }

        return new ArrayList<>(repeated);
    }

    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) sum += i;

        if (sum < k) {
            return sum;
        } else {
            if (sum % k == 0) return 0;
            else {
                return sum % k;
            }
        }
    }


    public int findClosest(int x, int y, int z) {

        if (Math.abs(z - x) == Math.abs(z - y)) return 0;
        else if (Math.abs(z - x) < Math.abs(z - y)) return 1;
        else {
            return 2;
        }


    }
    TreeSet<String>  res  =  new TreeSet<>();
    public String smallestPalindrome(String s) {
        if (s.length() == 1) return s;
        System.out.println("s = " + s);
        boolean[] used = new boolean[s.length()];
        backtrack(new StringBuilder(), used, s);
        System.out.println("res = " + res);
        String best = "";

        for (String s1 : res) {
            if (s1.compareTo(s) < 0) {
                best = s1;
            } else {
                break; // since res is sorted
            }
        }
        System.out.println("best = " + best);
        return res.isEmpty() ? "" : res.first();
    }

    private void backtrack(StringBuilder temp, boolean[] used, String s) {
        if (temp.length() == s.length() && isPalinedrome(s)) {
          //  System.out.println("temp = " + temp);
            res.add(temp.toString());
            return;
        }


        for (int i = 0; i < s.length(); i++) {
            // System.out.println("temp = " + temp);
            if (used[i]) continue;
            temp.append(s.charAt(i));
            used[i] = true;
            backtrack(temp, used, s);

            temp.deleteCharAt(temp.length() - 1);
            used[i] = false;

        }


    }

    private boolean isPalinedrome(String s) {
       int start =0; int end = s.length()-1;
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RepeatedDNASequences dna = new RepeatedDNASequences();

        System.out.println("dna = " + dna.smallestPalindrome("babab"));
      //  System.out.println("dna = " + dna.smallestPalindrome("daccad"));

       /* System.out.println("dna = " + dna.findClosest(2,7,4));
        System.out.println("dna = " + dna.findClosest(2,5,6));
        System.out.println("dna = " + dna.findClosest(1,5,3));*/

      /*  System.out.println("dna = " + dna.minOperations(new int[]{3, 9, 7}, 5));
        System.out.println("dna = " + dna.minOperations(new int[]{4, 1, 3}, 4));
        System.out.println("dna = " + dna.minOperations(new int[]{3, 2}, 6));*/



       /* System.out.println("dna = " + dna.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println("dna = " + dna.findRepeatedDnaSequences("AAAAAAAAAAA"));*/
    }


}
