package Daily.december;

/**
 * @Auther : hasan.khan
 * @Created : 06-Dec-23
 * @Description : <a href="https://leetcode.com/problems/calculate-money-in-leetcode-bank/?envType=daily-question&envId=2023-12-06">link</a>
 */
public class CalculateMoneyInLeetCodeBank {

    public int totalMoney(int n) {

        int startAmt = 1;
        int res = 0;
        int daysCount = 1;

        for (int i = 1; i <= n; i++) {
            if (i % 7 == 0) {
                startAmt++;
                res+=daysCount;
                daysCount=startAmt;
            } else {
                res +=daysCount;
                daysCount++;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        CalculateMoneyInLeetCodeBank o = new CalculateMoneyInLeetCodeBank();
        System.out.println("o = " + o.totalMoney(4));
        System.out.println("o = " + o.totalMoney(10));
        System.out.println("o = " + o.totalMoney(20));
    }

}
