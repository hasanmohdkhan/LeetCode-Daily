package strivers.binarysearch.practice;

/**
 * @Auther : hasan.khan
 * @Created : 02-Sep-24
 * @Description : <a href="https://leetcode.com/problems/valid-perfect-square/description/?envType=problem-list-v2&envId=binary-search&difficulty=EASY">link</a>
 */
public class PerfectSquare {

    public boolean isPerfectSquare(int num) {
        if(num==1) return true;
        int low =1;
        int high = num/2;

        while (low<= high){
            int mid = (low+high)/2;
            long sq = (long) mid * mid;
            if(sq == num) return true;

            if(num < sq) high = mid - 1;
            else low = mid+1;
        }

        return false;
    }


    public static void main(String[] args) {
        PerfectSquare s = new PerfectSquare();
        System.out.println("s = " + s.isPerfectSquare(16));
        System.out.println("s = " + s.isPerfectSquare(14));
        System.out.println("s = " + s.isPerfectSquare(1));
        System.out.println("s = " + s.isPerfectSquare(808201));
    }
}
