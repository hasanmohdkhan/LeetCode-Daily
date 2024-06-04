package neet150.binarysearch;

/**
 * @Auther : hasan.khan
 * @Created : 04-Oct-23
 * @Description:
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (target <= matrix[i][matrix[i].length - 1]) {
                    // start binary search here
                    return binarySearch(matrix[i], target);
                }
            }
        }
        return false;
    }

    /**
     * @param matrix sorted array in ascending order
     * @param target  element need to search
     * @return true or false
     */
    private boolean binarySearch(int[] matrix, int target) {
        int start = 0;
        int end = matrix.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (target == matrix[mid]) return true;
            if (matrix[mid] < target) start = mid + 1;
            else end = mid;
        }

        return false;
    }



    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 110;

        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        System.out.println("searchMatrix = " + searchA2DMatrix.searchMatrix(matrix, target));


    }
}
