package Daily.december;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 19-Dec-23
 * @Description : <a href="https://leetcode.com/problems/image-smoother/description/?envType=daily-question&envId=2023-12-19">link</a>
 */
public class ImageSmoother {

    public int[][] imageSmoother(int[][] img) {
        int rowLen = img.length;
        int colLen = img[0].length;

        int[][] res = new int[rowLen][colLen];

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                int sum = 0;
                int count = 0;
                for (int x = row - 1; x < row + 2; x++) {
                    for (int y = col - 1; y < col + 2; y++) {
                        if (0 <= x && x < rowLen && 0 <= y && y < colLen) {
                            sum += img[x][y];
                            count += 1;
                        }
                    }
                }
                res[row][col] = sum / count;
            }
        }


        return res;
    }

    public int[][] imageSmoother1(int[][] img) {
        // Save the dimensions of the image.
        int m = img.length;
        int n = img[0].length;

        // Create a new image of the same dimension as the input image.
        int[][] smoothImg = new int[m][n];

        // Iterate over the cells of the image.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Initialize the sum and count
                int sum = 0;
                int count = 0;

                // Iterate over all plausible nine indices.
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        // If the indices form valid neighbor
                        if (0 <= x && x < m && 0 <= y && y < n) {
                            sum += img[x][y];
                            count += 1;
                        }
                    }
                }

                // Store the rounded down value in smoothImg[i][j].
                smoothImg[i][j] = sum / count;
            }
        }

        // Return the smooth image.
        return smoothImg;
    }

    public static void main(String[] args) {
        int[][] img = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] img2 = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
        int[][] img3 = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
        ImageSmoother s = new ImageSmoother();
        System.out.println("s = " + Arrays.deepToString(s.imageSmoother(img3)));
       // System.out.println("s = " + Arrays.deepToString(s.imageSmoother(img2)));
    }

}
