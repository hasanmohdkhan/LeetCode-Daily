package strivers.binarysearch.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 29-Aug-24
 * @Description : <a href="https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/">link</a>
 */
public class KthSmallest {

    public int kthSmallestBrute(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : matrix) {
            for (int colum : row) {
                list.add(colum);
            }
        }
        Collections.sort(list);
        // System.out.println("list = " + list);


        return list.get(k - 1);
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            int count = countLessThanEqualToMid(matrix, n, mid);

            if(count < k) {
                low = mid+1;
            }else {
                ans = mid;
                high = mid - 1;
            }
        }


        return ans;
    }

    private int countLessThanEqualToMid(int[][] matrix, int n, int mid) {
        int count = 0;
        int row = n - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += row + 1; // row is index-is-0-based
                col++;
            } else row--;

        }

        return count;
    }

    public static void main(String[] args) {
        KthSmallest k = new KthSmallest();
        System.out.println("k = " + k.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
        System.out.println("k = " + k.kthSmallest(new int[][]{{-5}}, 1));
        System.out.println("k = " + k.kthSmallest(new int[][]{{1, 2}, {1, 3}}, 2));
    }
}
