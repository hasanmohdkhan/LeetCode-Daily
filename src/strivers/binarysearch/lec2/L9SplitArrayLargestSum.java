package strivers.binarysearch.lec2;

/**
 * @Auther : hasan.khan
 * @Created : 05-Jul-24
 * @Description : <a href="">link</a>
 */
public class L9SplitArrayLargestSum {

    public int splitArrayBrute(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i : nums) {
            high += i;
            low = Math.max(low, i);
        }
        for (int i = low; i <= high; i++) if (isPossible(nums, i) == k) return i;

        return low;
    }

    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i : nums) {
            high += i;
            low = Math.max(low, i);
        }

      while (low<=high){
            int mid = (low+high)/2;
            if (isPossible(nums, mid) > k) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }

        return low;
    }


    private int isPossible(int[] nums, int limit) {
        int currentMax = 0;
        int count = 1;

        for (int e : nums) {
            if (currentMax + e <= limit) {
                currentMax += e;
            } else {
                count++;
                currentMax = e;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        L9SplitArrayLargestSum s = new L9SplitArrayLargestSum();
        System.out.println("s = " + s.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println("s = " + s.splitArray(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println("s = " + s.splitArray(new int[]{2, 16, 14, 15}, 2));
    }

}
