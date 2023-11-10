package easy.matrix;

/**
 * @Auther : hasan.khan
 * @Created : 07-Oct-23
 * @Description: <a href="https://leetcode.com/problems/matrix-diagonal-sum/description/">Link</a>
 */
public class MatrixDiagonalSum {

    public int diagonalSum(int[][] mat) {
        //   mat[i= ][j = (length-1)-1 ] -> [i][2]
        // [2][0], [1][1], [0][2] -> row col
        int col = mat[0].length - 1;

        int row = 0;

  // brute force solution
       /* for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (i == j) {
                    sum += mat[i][j];
                    //System.out.println(" i==j = " + mat[i][j]);
                }
                if (row < mat.length) {
                    // System.out.println("row: "+row + ", col"+col );
                    if (row != col) {sum += mat[row][col];}

                    if (col != 0) col -= 1;
                    row += 1;
                }
            }

        }*/
        int sum = 0;
        int start = 0;
        int end = mat[0].length - 1;
        int i = 0;

        while (start < mat.length && end >= 0) {
            sum+=mat[i][start]+mat[i][end]; // 0,0  + 0,2
            if (start == end) { // 1,1
                sum -= mat[start][end]; // 1,1
            }
            i++;
            start++;
            end--;
        }

        return sum;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] matrix2 = {{1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};
        int[][] matrix3 = {{5}};

        MatrixDiagonalSum matrixDiagonalSum = new MatrixDiagonalSum();
        System.out.println("matrixDiagonalSum = " + matrixDiagonalSum.diagonalSum(matrix));
        System.out.println("matrixDiagonalSum = " + matrixDiagonalSum.diagonalSum(matrix2));
        System.out.println("matrixDiagonalSum = " + matrixDiagonalSum.diagonalSum(matrix3));

    }
}
