package Daily.december;

/**
 * @Auther : hasan.khan
 * @Created : 27-Dec-23
 * @Description : <a href="https://leetcode.com/problems/minimum-time-to-make-rope-colorful/?envType=daily-question&envId=2023-12-27">link</a>
 */
public class MinimumTimeToMakeRopeColorful {

    public int minCost(String colors, int[] neededTime) {

        int time = 0;
        int prev = 0;

        for (int i = 0; i < colors.length(); i++) {
            if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) {
                prev = 0;
            }
          //  System.out.println("i = " + i);
            int curr = neededTime[i];
            time += Math.min(prev, curr);
            prev = Math.max(prev, curr);
           // System.out.println("i = " + i+", curr = " + curr + ", prev = " + prev + ", time = " + time);
        }

        return time;
    }

    public static void main(String[] args) {
        MinimumTimeToMakeRopeColorful o = new MinimumTimeToMakeRopeColorful();
        String colors = "aabaa";
        int[] neededTime = {1, 2, 3, 4, 1};
        System.out.println("o = " + o.minCost(colors, neededTime));
    }
}
