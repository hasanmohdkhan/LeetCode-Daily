package strivers.binarysearch.practice;

/**
 * @Auther : hasan.khan
 * @Created : 24-Aug-24
 * @Description : <a href="https://leetcode.com/problems/h-index-ii/description/">link</a>
 */
public class HIndexII {

    public int hIndexBrute(int[] citations) {
        for (int h = citations.length; h > 0; h--) {
            int res = 0;  // Moved this inside the loop

            for (int citation : citations) {
                if (citation >= h) res++;
            }

            if (res >= h) return h;  // Ensure exactly h papers have at least h citations
        }

        return 0;
    }

    public int hIndex(int[] citations) {
        int low = 0;
        int high = citations.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int h = citations.length - mid;

            if (citations[mid] < h) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return citations.length - low;
    }

    private int bs(int[] citations, int key) {
        int low = 0;
        int high = citations.length - 1;

        while (low <= high){
            int mid = (low+high)/2;

            if(citations[mid] == key){
                return citations.length - mid ;
            }
            if(citations[mid] < key){
                low = mid+1;
            }else high = mid -1;
        }

        return  citations.length - low;
    }


    public static void main(String[] args) {
        HIndexII h = new HIndexII();
        System.out.println("h = " + h.hIndex(new int[]{0, 1, 3, 5, 6}));
        System.out.println("h = " + h.hIndex(new int[]{1, 2, 100}));
        System.out.println("h = " + h.hIndex(new int[]{1, 1}));
        System.out.println("h = " + h.hIndex(new int[]{100}));
        System.out.println("h = " + h.hIndex(new int[]{7,7,7,7,7,7,7}));

    }

}
