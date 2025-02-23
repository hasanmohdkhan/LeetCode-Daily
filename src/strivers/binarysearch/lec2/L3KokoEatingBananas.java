package strivers.binarysearch.lec2;

/**
 * @Auther : hasan.khan
 * @Created : 21-Jun-24
 * @Description : <a href="">link</a>
 */
public class L3KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int start = 0;
        int end = findHighInPiles(piles);

        while (start <= end) {
            int mid = (start + end) / 2;
            if (getTotalHrs(mid, piles) <= h) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }

    private int getTotalHrs(int rate, int[] piles) {
        int totalHrs = 0;
        for (int pile : piles) totalHrs += Math.ceil((double) (pile) / (double) (rate));
        return totalHrs;
    }


    private int findHighInPiles(int[] piles) {
        int ans = Integer.MIN_VALUE;
        for (int iTh : piles) ans = Math.max(ans, iTh);
        return ans;
    }


    public static void main(String[] args) {
        L3KokoEatingBananas b = new L3KokoEatingBananas();

        System.out.println("b = " + b.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println("b = " + b.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println("b = " + b.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }


}
