import java.util.Arrays;

/**
 * @Auther : hasan.khan
 * @Created : 02-Sep-23
 * @Description:
 */
public class BestTimeToBuyAndSellStock {


    public int maxProfitOld(int[] prices) {
        int totalProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int currentBuy = prices[i];
            for (int j = i; j < prices.length; j++) {
                int currentSell = prices[j];
                if (currentSell > currentBuy) {
                    int currentProfit = currentSell - currentBuy;
                    if (currentProfit > totalProfit) {
                        totalProfit = currentProfit;
                    }
                }
            }

        }

        return totalProfit;
    }

    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int currentBuy : prices) {
            if (currentBuy < min) min = currentBuy;

            if (currentBuy - min > totalProfit)
                totalProfit = currentBuy - min;

        }

        return totalProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock by = new BestTimeToBuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        // low pick & index
        // sell: index start -> pick max


        System.out.println("profit : " + by.maxProfit(prices) + " ans: " + 5);
        int[] case2 = {7, 6, 4, 3, 1};
        System.out.println();
        System.out.println("profit : " + by.maxProfit(case2));
        System.out.println();
        int[] ints1 = {1, 2};
        // int[] ints = {2, 1, 4};
        int[] ints = {2, 4, 1};
        System.out.println("profit3 : " + by.maxProfit(ints1));
        System.out.println("" + Arrays.toString(ints));
        System.out.println("profit4  : " + by.maxProfit(ints)
        );


    }


}
