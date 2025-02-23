package strivers.binarysearch.lec2;

/**
 * @Auther : hasan.khan
 * @Created : 19-Jun-24
 * @Description : <a href="">link</a>
 */
public class L1FindSquareRoot {

    long floorSqrt(long x)
    {
        if(x==0 || x==1) return x;

        long start = 2;
        long end = x;
        long root = 1;

        while (start<= end) {
            long mid = (start + end) / 2;
            if (mid <= x / mid) {
                root = mid;
                start = mid + 1;
            } else end = mid - 1;
        }

        return root;
    }

    public static void main(String[] args) {
        L1FindSquareRoot s = new L1FindSquareRoot();
        System.out.println("s = " + s.floorSqrt(4));
        System.out.println("s = " + s.floorSqrt(9));
        System.out.println("s = " + s.floorSqrt(0));
        System.out.println("s = " + s.floorSqrt(1));
        System.out.println("s = " + s.floorSqrt(30));
    }

}
