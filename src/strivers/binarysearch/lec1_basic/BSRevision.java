package strivers.binarysearch.lec1_basic;

import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 15-Jun-24
 * @Description : <a href="">link</a>
 */
public class BSRevision {
    //1
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    //2
    static int findFloor(long[] arr, int n, long x) {
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] <= x) {
                ans = mid;
                low = mid + 1;
            } else high = mid - 1;

        }

        return ans;
    }

    //3
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        Arrays.sort(arr);
        int floor = getFloor(arr, n, x);
        int ceil = getCeil(arr, n, x);

        return new Pair(floor, ceil);
    }

    private int getCeil(int[] arr, int n, int x) {
        int ans = -1;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }


        }

        return ans;
    }

    private int getFloor(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] <= x) {
                ans = arr[mid];
                low = mid + 1;
            } else high = mid - 1;

        }

        return ans;
    }

    //4
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        int ans = nums.length;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {

                low = mid + 1;
            }


        }


        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] arr = {-1, -1};
        int first = getFirst(nums, target);
        if (first == -1) return arr;
        int last = getLastIndex(nums, target);

        arr[0] = first;
        arr[1] = last;

        return arr;
    }

    private int getLastIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int last = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                last = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return last;
    }

    private int getFirst(int[] nums, int target) {
        int start = 0;
        int n = nums.length;
        int end = n - 1;
        int first = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                first = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        return first;
    }

    public int searchR(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) return mid;

            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }
        }

        return -1;
    }

    public boolean searchDR(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) return true;

            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                start = start + 1;
                end = end - 1;
                continue;
            }

            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }
        }

        return false;
    }

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[start] <= nums[mid]) {
                ans = Math.min(ans, nums[start]);
                start = mid + 1;
            } else {
                end = mid - 1;
                ans = Math.min(ans, nums[mid]);
            }
        }

        return ans;
    }

    int findKRotation(int[] num, int n) {
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = num.length - 1;
        int pos = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (num[start] <= num[end]) {
                if (num[start] < ans) {
                    pos = start;
                }
                break;
            }

            if (num[start] <= num[mid]) {
                ans = Math.min(num[start], ans);
                start = mid + 1;
                pos = start;
            } else {
                end = mid - 1;
                ans = Math.min(num[mid], ans);
                pos = mid;
            }

        }


        return pos;
    }

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1]; // last element here

        int start = 0;
        int end = n - 2;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];

            if (((mid % 2 == 1) && nums[mid] == nums[mid - 1]) || ((mid % 2 == 0) && (nums[mid] == nums[mid + 1]))) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;
        int start = 1;
        int end = n - 2;

        while (start<=end){
            int mid = (start+end)/2;
            if(nums[mid]> nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            if(nums[mid] > nums[mid-1]) start = mid+1;
            else end = mid-1;
        }

            return -1;
    }

    public static void main(String[] args) {
        BSRevision bs = new BSRevision();
//        System.out.println("bs = " + bs.singleNonDuplicate(new int[]{1}));
//        System.out.println("bs = " + bs.singleNonDuplicate(new int[]{1, 1, 2}));
//        System.out.println("bs = " + bs.singleNonDuplicate(new int[]{1, 3}));
//        System.out.println("bs = " + bs.singleNonDuplicate(new int[]{1, 2, 3}));
//        System.out.println("bs = " + bs.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));

        System.out.println("bs.findPeakElement() = " + bs.findPeakElement(new int[]{1,2,3,1}));
        System.out.println("bs.findPeakElement() = " + bs.findPeakElement(new int[]{1,2,1,3,5,6,4}));




      /*  System.out.println("bs = " + bs.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println("bs = " + bs.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println("bs = " + bs.search(new int[]{-1, 0, 3, 5, 9, 12}, -1));
*/

//        System.out.println("findFloor = " + findFloor(new long[]{1, 2, 8, 10, 11, 12, 19}, 7, 0));
//        System.out.println("findFloor = " + findFloor(new long[]{1, 2, 8, 10, 11, 12, 19}, 7, 5));

        // System.out.println("getFloorAndCeil = " + bs.getFloorAndCeil(new int[]{5, 6, 8, 9, 6, 5, 5, 6}, 8, 10));

        // System.out.println("getFloorAndCeil = " + bs.getFloorAndCeil(new int[]{5, 6, 8, 9, 6, 5, 5, 6}, 8, 7));

//        System.out.println("bs.searchInsert() = " + bs.searchInsert(new int[]{1, 3, 5, 6}, 5));
//        System.out.println("bs.searchInsert() = " + bs.searchInsert(new int[]{1,3,5,6}, 2));

        //  System.out.println("bs.searchRange() = " + Arrays.toString(bs.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));

//        //  System.out.println("bs.searchR() = " + bs.searchR(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
//        System.out.println("bs.searchDR() = " + bs.searchDR(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
//        System.out.println("bs.searchDR() = " + bs.searchDR(new int[]{2, 5, 6, 0, 0, 1, 2}, 6));
//        System.out.println("bs.searchDR() = " + bs.searchDR(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
//
//        System.out.println("bs.searchDR() = " + bs.searchDR(new int[]{1, 0, 1, 1, 1}, 0));


//        System.out.println("bs.findMin() = " + bs.findMin(new int[]{3,4,5,1,2}));
//        System.out.println("bs.findMin() = " + bs.findMin(new int[]{4,5,6,7,0,1,2}));
       /* System.out.println("bs.findKRotation() = " + bs.findKRotation(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println("bs.findKRotation() = " + bs.findKRotation(new int[]{5, 1, 2, 3, 4}, 0));
        System.out.println("bs.findKRotation() = " + bs.findKRotation(new int[]{0, 1, 2, 3, 4}, 0));
        System.out.println("bs.findKRotation() = " + bs.findKRotation(new int[]{66, 67, 7, 10, 14, 19, 27, 33, 36, 40, 44, 54, 60}, 0));
*/


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
            final StringBuilder sb = new StringBuilder();
            sb.append("floor=").append(floor);

            sb.append(", ceil=").append(ceil);

            return sb.toString();
        }
    }

}
