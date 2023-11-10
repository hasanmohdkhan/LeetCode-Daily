package easy.grid;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 09-Oct-23
 * @Description :
 */
public class DeleteGreatestValueInEachRow {

    public int deleteGreatestValue(int[][] grid) {
        for (int[] ints : grid) Arrays.sort(ints);
        int res = 0;
        int colNum = grid[0].length;

        for (int col = 0; col < colNum; col++) {
            int max = 0;
            for (int row =0 ; row < grid.length ; row++) {
              //  System.out.println(" " + grid.length);
                max = Math.max(max, grid[row][col]);
            }
            res+=max;
           // System.out.println("--");

        }
      //  System.out.println("res = " + res);

        return res;
    }

    public void matrixTravser(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        System.out.println("Row-Major Order (Left-to-Right, Top-to-Bottom):");

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int element = grid[row][col];
                // Perform operations on the element as needed
                System.out.print(element + " "); // Print the element, for example
            }
            System.out.println(); // Move to the next row
        }

        System.out.println("Column-Major Order (Top-to-Bottom, Left-to-Right):");

        for (int col = 0; col < numCols; col++) {
            for (int row = 0; row < numRows; row++) {
                int element = grid[row][col];
                // Perform operations on the element as needed
                System.out.print(element + " "); // Print the element, for example
            }
            System.out.println(); // Move to the next column
        }
    }


    public static void main(String[] args) {
        int[][] mat = {{1, 2, 4}, {3, 3, 1}};
        DeleteGreatestValueInEachRow deleteGreatestValueInEachRow = new DeleteGreatestValueInEachRow();
        System.out.println("mat1 = " + deleteGreatestValueInEachRow.deleteGreatestValue(mat));
       //   deleteGreatestValueInEachRow.matrixTravser(mat);

    }
}
