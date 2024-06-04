package strivers.Arrays.medium;

/**
 * @Auther : hasan.khan
 * @Created : 20-Mar-24
 * @Description : <a href="">link</a>
 */
public class BuySellStock {

    public static int bestTimeToBuyAndSellStock(int []prices) {
        // Write your code here.
        int min = Integer.MAX_VALUE;
        int totalProfit = 0;

        for (int price : prices) {
            if (price < min) min = price;

            if (price - min > totalProfit) {
                totalProfit = price - min;
            }


        }


        return totalProfit;
    }

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 4, 3, 6};
        System.out.println("bestTimeToBuyAndSellStock() = " + bestTimeToBuyAndSellStock(a));
    }

}
