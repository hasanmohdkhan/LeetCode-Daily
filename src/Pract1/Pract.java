package Pract1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther : hasan.khan
 * @Created : 16-Dec-24
 * @Description : <a href="">link</a>
 */
public class Pract {


    public static void main(String[] args) {
        String s = "cdadcda";

      //  Character c = getMinFreq(s);

      //  System.out.println("c = " + c);

        String s1 = "asdfaghjklkjhgfdsa";

     //   getFirst(s1);

        findMin();

        findFirstAlpha();


    }

    private static void findFirstAlpha() {
        List<String> l = Arrays.asList("Alice","bob","Apple", "Orange");

        List<String> a = l.stream().filter(s -> s.startsWith("A")).collect(Collectors.toList());
        System.out.println("a = " + a);

        List<Integer> li = Arrays.asList(1,2,3,4);
        Integer reduce = li.stream().reduce(1, (a1, b) -> a1 * b);
        System.out.println("reduce = " + reduce);
        System.out.println("add = " +li.stream().reduce(0, (a1, b) -> a1 + b));

        System.out.println("longestPalindromeSubseq = " + longestPalindromeSubseq("aabaaadiiii"));
        System.out.println("longestPalindromeSubseq = " + longestPalindromeSubseq("aabaaabii"));
        System.out.println("longestPalindromeSubseq = " + longestPalindromeSubseq("bbbab"));


    }

    private static void findMin() {
        List<Integer> list = List.of(1,2,3,4,5,6);

        Optional<Integer> max = list.stream().max(Integer::compareTo);
        System.out.println("max = " + max.orElse(null));

        Optional<Integer> min = list.stream().min(Integer::compareTo);
        System.out.println("min = " + min.orElse(null));
    }

    private static void getFirst(String s) {
        Optional<Character> firstRepeating = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst();

        s.chars().mapToObj(c -> c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(integerLongEntry -> integerLongEntry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println(firstRepeating.orElse(null)); // Output: a
    }

    private static Character getMinFreq(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println("map = " + map);

        int minFreq = Integer.MAX_VALUE;
        Character res = null;


        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            Integer freq = e.getValue();
            Character key = e.getKey();

            if (freq < minFreq) {
                minFreq = freq;
                res = key;
            }
        }

        return res;
    }


    public static int longestPalindromeSubseq(String s) {
        int n = s.length();

        // Edge case: if the string is empty
        if (n == 0) return 0;

        // Create a DP array where dp[i][j] represents the LPS length for substring s[i...j]
        int[][] dp = new int[n][n];

        // Base case: every single character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Build the DP table for substrings of length 2 to n
        for (int len = 2; len <= n; len++) {  // len is the length of the substring
            for (int i = 0; i <= n - len; i++) {  // i is the starting index
                int j = i + len - 1;  // j is the ending index of the substring

                // If the characters at the two ends match, they contribute to the palindrome
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // Otherwise, we take the maximum of two possibilities:
                    // - Exclude the first character (dp[i+1][j])
                    // - Exclude the last character (dp[i][j-1])
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // The result is in dp[0][n-1], which represents the LPS of the entire string
        return dp[0][n - 1];
    }

}
