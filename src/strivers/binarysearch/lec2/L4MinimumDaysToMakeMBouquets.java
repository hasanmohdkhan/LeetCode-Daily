package strivers.binarysearch.lec2;

/**
 * @Auther : hasan.khan
 * @Created : 23-Jun-24
 * @Description : <a href="">link</a>
 */
public class L4MinimumDaysToMakeMBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
       if((m*k)> bloomDay.length ) return -1;
        int start = 0;
        int end = (int)1e9;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(bloomDay, mid, m, k))
                end = mid - 1;
            else start= mid+1;
        }

        return start;
    }

    private boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int noB = 0;

        for (int j : bloomDay) {
            if (j <= day) count++;
            else {
                noB += (count / k);
                count = 0;
            }
        }
        noB += (count / k);
        return noB >= m;
    }


    public static void main(String[] args) {
        L4MinimumDaysToMakeMBouquets bs = new L4MinimumDaysToMakeMBouquets();

        System.out.println("bs1 = " + bs.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println("bs2 = " + bs.minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
        System.out.println("bs3 = " + bs.minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
    }

}
