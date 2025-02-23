package contest;

/**
 * @Auther : hasan.khan
 * @Created : 30-Jun-24
 * @Description : <a href="">link</a>
 */
public class June30th24 {

    public int maxHeightOfTriangle(int red, int blue) {
        if (red == 1 && blue == 1) return 1;

        if (red == 1 || blue == 1) {
            if (red >= 2 || blue >= 2) return 2;
        }

        int res = 0;

        int n = red + blue;

       // if(red > blue)



        for (int i = 1; i <= n; i++) {
            int y = (i * (i + 1)) / 2;
            if (y <= n) res = i;

            if (i % 2 == 0) {
                red -= i;
                if (red <= 0) break;
            } else // odd
            {
                blue -= i;
                if (blue <= 0) break;
            }

        }


        return res;
    }

    public int maxHeightOfTriangle1(int red, int blue) {
        // Initialize dp array with -1 to indicate states that haven't been computed
        int[][] dp = new int[red + 1][blue + 1];

        // Iterate over all possible values of r and b
        for (int r = 0; r <= red; r++) {
            for (int b = 0; b <= blue; b++) {
                // Initialize dp[r][b] to -1 to indicate it hasn't been computed yet
                dp[r][b] = -1;
            }
        }

        // Base case: dp[0][0] = 0, no balls means no triangle
        dp[0][0] = 0;

        // Iterate over all possible heights of the triangle
        for (int height = 1; height <= red + blue; height++) {
            // Try to form the next row with red balls
            for (int r = red; r >= height; r--) {
                if (dp[r - height][blue] != -1) {
                    dp[r][blue] = Math.max(dp[r][blue], height + dp[r - height][blue]);
                }
            }

            // Try to form the next row with blue balls
            for (int b = blue; b >= height; b--) {
                if (dp[red][b - height] != -1) {
                    dp[red][b] = Math.max(dp[red][b], height + dp[red][b - height]);
                }
            }
        }

        // The result is stored in dp[red][blue]
        return dp[red][blue];
    }


    public static void main(String[] args) {
        June30th24 j = new June30th24();
        System.out.println("j = " + j.maxHeightOfTriangle(1, 1));
        System.out.println("j = " + j.maxHeightOfTriangle(2, 4));
        System.out.println("j = " + j.maxHeightOfTriangle(10, 1));
        System.out.println("j = " + j.maxHeightOfTriangle(9, 3));
        System.out.println("j = " + j.maxHeightOfTriangle(2, 4));
    }
}
