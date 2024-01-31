package Daily.december;

/**
 * @Auther : hasan.khan
 * @Created : 05-Dec-23
 * @Description : <a href="https://leetcode.com/problems/count-of-matches-in-tournament/description/?envType=daily-question&envId=2023-12-05">link</a>
 */
public class CountOfMatchesInTournament {

    public int numberOfMatches(int n) {
        int res = 0;
        int marches = 0;

        if(n==1) return 0;

        if (n / 2 != 0) {
            while (1 < n) {
                int temp = n;
                marches = n / 2;
               // System.out.println("marches = " + marches);
                n = temp - (temp / 2);
               // System.out.println("n = " + n);
                res += marches;
            }

        } else {
            while (0 < n) {
                int temp = n;

                if (n / 2 == 0) {
                    n = n / 2;
                    marches = temp - n;
                }
                res += marches;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        CountOfMatchesInTournament o = new CountOfMatchesInTournament();
        System.out.println("Res = " + o.numberOfMatches(7));
        System.out.println("Res = " + o.numberOfMatches(14));
    }


}
