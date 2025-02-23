package strivers.binarysearch.lec1_basic;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 06-Jun-24
 * @Description : <a href="">link</a>
 */
public class BinarySearchUpperBound {

    Pair getFloorAndCeil(int[] arr, int n, int x) {
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        int floor = -1;
        int ceil = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == x) {
                floor = arr[mid];
                ceil = arr[mid];
                break;
            }
          else  if (arr[mid] < x) {
                floor = arr[mid];
                start = mid + 1;
            }
            else {
                end = mid-1;
                ceil = arr[mid];
            }
        }

        return new Pair(floor, ceil);
    }

    public static void main(String[] args) {
        BinarySearchUpperBound s = new BinarySearchUpperBound();
        int N = 8;
        int X = 10;
        int[] arr = {5, 6, 8, 9, 6, 5, 5, 6};

        int n = 23;
        int x = 42;
        int[] arr1 = {85,24,40,10,66,16,6,54,93,42,6,98,49,100,98,23,59,48,17,56,64,94,77};

        System.out.println("s = " + s.getFloorAndCeil(arr, N, X));
        System.out.println("s2 = " + s.getFloorAndCeil(arr1, n, x));
    }

    class Pair {
        int floor, ceil;

        Pair() {
            this.floor = 0;
            this.ceil = 0;
        }

        Pair(int floor, int ceil) {
            this.floor = floor;
            this.ceil = ceil;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Pair{");
            sb.append("floor=").append(floor);
            sb.append(", ceil=").append(ceil);
            sb.append('}');
            return sb.toString();
        }
    }
}
