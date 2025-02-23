package strivers.binarysearch.lec1_basic;

/**
 * @Auther : hasan.khan
 * @Created : 12-Jun-24
 * @Description : <a href="">link</a>
 */
public class BinarySearchFindRoationPosition {

    int findKRotation(int[] arr, int n) {
        int pos = -1;
        int low = 0;
        int high = n - 1;
        int lowest = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            if(arr[low] <= arr[high]){
                if(arr[low]< lowest) {
                    pos = low;
                }
                break;
            }

            if (arr[low] <= arr[mid]) {
                lowest = Math.min(lowest, arr[low]);
                pos = low;
                low = mid + 1;

            } else {
                high = mid - 1;
                lowest = Math.min(lowest, arr[mid]);
                pos= mid;
            }

        }
       // System.out.println("pos = " + pos);


        return pos;
    }


    public static void main(String[] args) {
        BinarySearchFindRoationPosition bsr = new BinarySearchFindRoationPosition();
        int arr[] = {5, 1, 2, 3, 4};
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {66, 67, 7, 10, 14, 19, 27, 33, 36, 40, 44, 54, 60};
        System.out.println("bsr = " + bsr.findKRotation(arr, arr.length));

        System.out.println("bsr2 = " + bsr.findKRotation(arr1, arr1.length));
        System.out.println("bsr3 = " + bsr.findKRotation(arr2, arr2.length));
    }


}
