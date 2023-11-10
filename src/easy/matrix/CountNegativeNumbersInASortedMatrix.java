package easy.matrix;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 10-Oct-23
 * @Description : <a href="https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/">Link</a>
 */
public class CountNegativeNumbersInASortedMatrix {


    /**
     * n - row loop
     * m - col loop
     * brute force solution: O(n*m)
     *
     * @param grid 2d matrix
     * @return negative number
     */
    public int countNegativesBruteSolution(int[][] grid) {
        int colNum = grid[0].length;
        int total = 0;
        for (int[] ints : grid) {
            for (int col = 0; col < colNum; col++) {
                System.out.println(" " + ints[col]);
                if (ints[col] < 0) total += 1;
            }
            System.out.println();
        }


        return total;
    }

    /**
     * solution: binary search row: log(n) and we have m row
     * time complexity: m * log(n)
     * space complexity: O(1)
     *
     * @param grid 2d matrix
     * @return negative number
     */
    public int countNegatives(int[][] grid) {
        int total = 0;
        for (int[] ints : grid) {
           // System.out.println("i = " + Arrays.toString(ints));
            Arrays.sort(ints);
            total += binarySearchForNegative(ints);
        }
        return total;
    }

    private int binarySearchForNegative(int[] grid) {
        int start = 0;
        int end = grid.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            //if (grid[mid] == target) return mid -> no need to find the target
            if (grid[mid] < 0) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }

    private int binarySearch(int[] grid, int target) {
        System.out.println("grid = " + Arrays.toString(grid));
        int left = 0;
        int right = grid.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (grid[mid] == target)  return mid;
            if (grid[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        // not found
        return -1;
    }


    public static void main(String[] args) {
        int[][] mat = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        CountNegativeNumbersInASortedMatrix count = new CountNegativeNumbersInASortedMatrix();

        int[] ints = mat[0];
        // Arrays.sort(ints);
        System.out.println("BS = " + count.binarySearch(ints,-1));
        System.out.println("BS = " + count.binarySearch(ints,4));

        System.out.println("count = " + count.countNegatives(mat));

        //System.out.println("count = " + );


    }
}
