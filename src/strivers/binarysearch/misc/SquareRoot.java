package strivers.binarysearch.misc;

/**
 * @Auther : hasan.khan
 * @Created : 12-Jun-24
 * @Description : <a href="">link</a>
 */
public class SquareRoot {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int ans = -1;
        int start = 1;
        int end = x;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid <= x/mid) {
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        SquareRoot sr = new SquareRoot();

        System.out.println("sr = " + sr.mySqrt(4));
        System.out.println("sr2 = " + sr.mySqrt(8));
        System.out.println("sr2 = " + sr.mySqrt(49));
    }
}
