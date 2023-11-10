package easy.matrix;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 08-Oct-23
 * @Description : <a href="https://leetcode.com/problems/flipping-an-image/description/">Link</a>
 */
public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i< image.length; i++) {
           // System.out.print(" " + Arrays.toString(image[i]));
            int[] rev = reverseRow(image[i]);
            image[i]= rev;
           // System.out.println("rev[i] = " + Arrays.toString(rev));
//            System.out.println();
        }
        return image;
    }

    private int[] reverseRow(int[] length) {
        int[] rev = new int[length.length];
        int startIndex = 0;
        for (int i = length.length - 1; i >= 0; i--) {
            rev[startIndex] = length[i];
            if(rev[startIndex]==0) rev[startIndex] = 1;
            else rev[startIndex] = 0;
            startIndex++;
        }
        return rev;
    }


    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        FlippingAnImage flippingAnImage = new FlippingAnImage();
        System.out.println("flippingAnImage = " + Arrays.deepToString(flippingAnImage.flipAndInvertImage(mat)));

    }
}
