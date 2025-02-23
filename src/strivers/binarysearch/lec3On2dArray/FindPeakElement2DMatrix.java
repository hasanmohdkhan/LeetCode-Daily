package strivers.binarysearch.lec3On2dArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther : hasan.khan
 * @Created : 21-Jul-24
 * @Description : <a href="">link</a>
 */
public class FindPeakElement2DMatrix {

    public int[] findPeakGridBrute(int[][] arr) {
        List<Integer> res = new ArrayList<>();

        int n = arr.length;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                res.add(anInt);
            }
        }

        Collections.sort(res);
        System.out.println("res = " + res.get((n * arr[0].length)/2));
        return new int[1];
    }


    public int[] findPeakGrid(int[][] arr) {
       int n = arr.length;
       int m = arr[0].length;

       int low =0;
       int high = m - 1;

       while (low<= high){
           int mid= (low+high)/2;
           int maxRowIndex = getMaxElementIndex(arr, n, m, mid);
           int left = mid - 1 >= 0 ? arr[maxRowIndex][mid -1] : -1;
           int right = mid+1 < m ? arr[maxRowIndex][mid+1] : -1;


           if(arr[maxRowIndex][mid] > left && arr[maxRowIndex][mid] > right){
               return new int[]{maxRowIndex, mid};
           } else if (arr[maxRowIndex][mid] < left) {
               // low   left  mid  right  high
              high = mid - 1;
           }else {
               low = mid+1;
           }

       }

        return new int[]{-1,-1};
    }

    private int getMaxElementIndex(int[][] arr, int n, int m, int col) {
       int index = -1;
       int maxValue = -1;

        for (int i = 0; i < n; i++) {
            if(arr[i][col] > maxValue){
                maxValue = arr[i][col];
                index = i;
            }

        }
        return index;
    }


    public static int[] rotate(int[] arr) {
        int last = arr[arr.length - 1];
        int s2last = arr[arr.length - 2]; // 1 2 3 4 5  -> 4 5 1 2 3

        for (int i = arr.length -1 ; i > 1 ; i--) {
            arr[i] = arr[i-2];
        }

        arr[0]= s2last;
        arr[1] = last;


        return arr;
    }


    public static void main(String[] args) {
        FindPeakElement2DMatrix s = new FindPeakElement2DMatrix();
       // System.out.println("s = " + Arrays.toString(rotate(new int[]{1, 2, 3, 4, 5})));
        System.out.println("s = " + Arrays.toString(s.findPeakGrid(new int[][]{{1, 4}, {3, 2}})));
    }

}
