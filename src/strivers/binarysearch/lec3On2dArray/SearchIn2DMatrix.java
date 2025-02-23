package strivers.binarysearch.lec3On2dArray;

/**
 * @Auther : hasan.khan
 * @Created : 18-Jul-24
 * @Description : <a href="https://leetcode.com/problems/search-a-2d-matrix/">link</a>
 */
public class SearchIn2DMatrix {

    public boolean searchMatrixBetter(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            boolean isFound = callBinarySearch(ints, target);
            if (isFound) return true;
        }
        return false;
    }
    private boolean callBinarySearch(int[] matrix, int target) {
        int start =0;
        int end = matrix.length -1;

        while (start<= end){
            int mid = (start+end)/2;

            if(matrix[mid]== target) return true;
             // 1   5   .. 7... 10
            if(matrix[mid] < target){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row =0;
        int n = matrix.length;
        int col = matrix[0].length - 1;

       while (row < n && col >=0 ){

         if(matrix[row][col] == target) return true;
         if(matrix[row][col] < target) row++;
         else col--;

       }


        return false;
    }

    public static void main(String[] args) {
        SearchIn2DMatrix s = new SearchIn2DMatrix();
        System.out.println("s = " + s.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},3));
        System.out.println("s = " + s.searchMatrix(new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}},13));

        System.out.println("s = " + s.searchMatrix(new int[][]{{-1,3}},3));
    }


}
