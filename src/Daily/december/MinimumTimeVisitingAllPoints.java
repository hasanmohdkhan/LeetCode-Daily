package Daily.december;


/**
 * @Auther : hasan.khan
 * @Created : 03-Dec-23
 * @Description : <a href="https://leetcode.com/problems/minimum-time-visiting-all-points/description/?envType=daily-question&envId=2023-12-03">link</a>
 */
public class MinimumTimeVisitingAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        int total = 0;
        //dx1 - dx0
        for (int i = 0; i < points.length - 1; i++) {
            total += Math.max(Math.abs(points[i][0] - points[i + 1][0]), Math.abs(points[i][1] - points[i + 1][1]));
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1}, {3, 4}, {-1, 0}};
        MinimumTimeVisitingAllPoints result = new MinimumTimeVisitingAllPoints();
        System.out.println("result = " + result.minTimeToVisitAllPoints(arr));
    }

}
