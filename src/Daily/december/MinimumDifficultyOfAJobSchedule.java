package Daily.december;

/**
 * @Auther : hasan.khan
 * @Created : 29-Dec-23
 * @Description : <a href="">link</a>
 */
public class MinimumDifficultyOfAJobSchedule {
    int[][] cache = new int[301][11];

    public int minDifficulty(int[] jobDifficulty, int d) {
        int len = jobDifficulty.length;
        if (len < d) return -1; // BASE CASE: d should not be less than jobDifficulty size

        for (int i = 0; i < 301; i++) for (int j = 0; j < 11; j++) cache[i][j] = -1;

        return solve(jobDifficulty, len, 0, d);
    }

    private int solve(int[] jobDifficulty, int len, int idx, int day) {
        if (day == 1) {
            int maxD = jobDifficulty[idx];
            for (int i = idx; i < len; i++) {
                maxD = Math.max(maxD, jobDifficulty[i]);
            }
            return maxD;
        }

        if (cache[idx][day] != -1) {
            return cache[idx][day];
        }

        int maxD = jobDifficulty[idx];
        int finalResults = Integer.MAX_VALUE;

        for (int i = idx; i <= len - day; i++) {
            maxD = Math.max(maxD, jobDifficulty[i]);

            int res = maxD + solve(jobDifficulty, len, i + 1, day - 1);

            finalResults = Math.min(res, finalResults);

        }


        return cache[idx][day] = finalResults;
    }

    public static void main(String[] args) {
        int[] jobDifficulty = {6, 5, 4, 3, 2, 1};
        int d = 2;
        MinimumDifficultyOfAJobSchedule o = new MinimumDifficultyOfAJobSchedule();
        System.out.println("o = " + o.minDifficulty(jobDifficulty, d));
        int[] jobDifficulty1 = {1};
        System.out.println("o = " + o.minDifficulty(jobDifficulty1, d));
        // array => sub i...0....length


    }

}
