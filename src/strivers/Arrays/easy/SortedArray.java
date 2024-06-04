package strivers.Arrays.easy;

/**
 * @Auther : hasan.khan
 * @Created : 03-Mar-24
 * @Description : <a href="https://www.codingninjas.com/studio/problems/ninja-and-the-sorted-check_6581957?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=DISCUSS">link</a>
 */
public class SortedArray {

    public static int isSorted(int n, int[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) return 0;
        }

        return 1;

    }

    public static boolean isSortedLeetCode(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
          //  System.out.println(a[i] + ",  " + a[(i + 1) % a.length] + " , i = " + (i + 1) % a.length);
            if (a[i] > a[(i + 1) % a.length]) {
                count++;
            }

        }

        return count <= 1;

    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {14, 12, 14, 1, 0, 9, 1};
        int[] a = {3, 4, 5, 1, 2};
        System.out.println("isSorted() = " + isSortedLeetCode(a));
        System.out.println("isSorted() = " + isSortedLeetCode(a1));
        System.out.println("isSorted() = " + isSortedLeetCode(a2));
    }

}
