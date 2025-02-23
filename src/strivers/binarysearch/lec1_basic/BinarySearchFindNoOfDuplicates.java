package strivers.binarysearch.lec1_basic;

/**
 * @Auther : hasan.khan
 * @Created : 08-Jun-24
 * @Description : <a href="">link</a>
 */
public class BinarySearchFindNoOfDuplicates {

    int count(int[] arr, int n, int x) {
        int first = -1;
        int last = -1;

        first = findFirst(arr, x, first);
        last = findlast(arr, x, last);
        if(first == -1 && last == -1) return 0;

        return (last - first)+1;
    }

    private int findlast(int[] arr, int x, int last) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == x) {
                last = mid;
                start = mid + 1;
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }


        }


        return last;
    }

    private int findFirst(int[] arr, int x, int first) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == x) {
                first = mid;
                end = mid - 1;
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return first;
    }

    public static void main(String[] args) {
        BinarySearchFindNoOfDuplicates fd = new BinarySearchFindNoOfDuplicates();
        int n = 7;
        int x = 2;
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        System.out.println("fd = " + fd.count(arr, n, x));


        int n1 = 2;
        int x1 = 10;
        int[] arr1 = {10,11};
        System.out.println("fd1 = " + fd.count(arr1, n1, x1));

        int n2 = 7;
        int x2 = 4;
        int[] arr2 = {1, 1, 2, 2, 2, 2, 3};
        System.out.println("fd2 = " + fd.count(arr2, n2, x2));

    }
}
