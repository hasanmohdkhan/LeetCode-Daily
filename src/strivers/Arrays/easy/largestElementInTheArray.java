package strivers.Arrays.easy;

/**
 * @Auther : hasan.khan
 * @Created : 03-Mar-24
 * @Description : <a href="">link</a>
 */
public class largestElementInTheArray {

    static int largestElement(int[] arr, int n) {
        // Write your code here.
        int largest = Integer.MIN_VALUE;

        for (int j : arr) {
            if (j > largest) {
                largest = j;
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] a1 =   { 5, 9, 3, 4, 8, 4, 3 ,10};
        int i = largestElement(a1, a1.length);
        System.out.println("i = " + i);

    }
}
