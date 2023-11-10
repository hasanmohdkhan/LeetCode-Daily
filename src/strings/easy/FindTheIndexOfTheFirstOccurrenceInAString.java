package strings.easy;

/**
 * @Auther : hasan.khan
 * @Created : 01-Nov-23
 * @Description : <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/">link</a>
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {

    public int strStrBruteForce(String haystack, String needle) {
        int fixWindow = needle.length();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < haystack.length() - fixWindow + 1; i++) {
            for (int j = i; j < i + fixWindow; j++) {
                str.append(haystack.charAt(j));
            }

            if (str.toString().contentEquals(needle)) {
              //  System.out.println("\nsubstring = " + str);
                return haystack.indexOf(needle);

            }

          //  System.out.println();
            str = new StringBuilder();

        }

        return -1;
    }

    public int strStr(String haystack, String needle) {
        int fixWindow = needle.length();
        StringBuilder str = new StringBuilder();
        System.out.println("haystack = " + haystack + " -> needle = "+needle);
        for (int i = 0; i < haystack.length() - fixWindow + 1; i++) {
            for (int j = i; j < i + fixWindow; j++) {
                str.append(haystack.charAt(j));
            }
            System.out.println("str = " + str);

            if (str.toString().contentEquals(needle)) {
                //  System.out.println("\nsubstring = " + str);
                return haystack.indexOf(needle);

            }

            //  System.out.println();
            str = new StringBuilder();

        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        String haystack1 = "leetcode", needle1 = "leeto";
        String haystack2 = "mississippi", needle2 = "issip";

        FindTheIndexOfTheFirstOccurrenceInAString inAString = new FindTheIndexOfTheFirstOccurrenceInAString();
        System.out.println("inAString.strStr() = " + inAString.strStr(haystack, needle));
        System.out.println("inAString.strStr() = " + inAString.strStr(haystack1, needle1));
        System.out.println("inAString.strStr() = " + inAString.strStr(haystack2, needle2));

    }

}
