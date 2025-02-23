package strivers.binarysearch.practice;

/**
 * @Auther : hasan.khan
 * @Created : 03-Sep-24
 * @Description : <a href='https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/?envType=study-plan-v2&envId=binary-search'>link</a>
 */
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        char ans = letters[0];

        while (low <= high) {
            int mid = (low + high) / 2;

            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                ans = letters[mid];
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget s = new FindSmallestLetterGreaterThanTarget();
        System.out.println("s = " + s.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println("s = " + s.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println("s = " + s.nextGreatestLetter(new char[]{'x', 'x', 'y', 'y'}, 'z'));
    }
}
