package Daily.december;

/**
 * @Auther : hasan.khan
 * @Created : 20-Dec-23
 * @Description : <a href="https://leetcode.com/problems/buy-two-chocolates/description/?envType=daily-question&envId=2023-12-20">link</a>
 */
public class BuyTwoChocolates {

    public int buyChoco(int[] prices, int money) {
        int minCost = Integer.MAX_VALUE;
        int length = prices.length;
      /*  for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    System.out.println("p1 = " + prices[i] + "  p2 = " + prices[j]);
                    int currSum = prices[i] + prices[j];
                    minCost = Math.min(currSum, minCost);
                    System.out.println("leftOver = " + currSum + " minCost = " + minCost);
                }
            }
        }*/

        int right = 0;
        int left = 1;


        while (right <= length - 1) {
           // System.out.println("right = " + right + " left = " + left);
            if(left != length) {
                int currSum = prices[right] + prices[left];
                minCost = Math.min(currSum, minCost);
            }
            // increase on the right pointer when a left pointer reaches to length
            if (left < length - 1) {
                left++;
            } else {
                right++;
                left = right+1;
               // if(left == length -1) break;
            }
        }


        int leftOver = money - minCost;
        if (leftOver >= 0) {
            return leftOver;
        } else return money;

    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 2};
        int money = 3;
        int[] prices2 = {98, 54, 6, 34, 66, 63, 52, 39}; //,
        int money2 = 62;
        int[] prices3 = {69, 91, 78, 19, 40, 13}; //,
        int money3 = 94;
        BuyTwoChocolates result = new BuyTwoChocolates();
         System.out.println("result = " + result.buyChoco(prices, money));
        System.out.println("result = " + result.buyChoco(prices2, money2));
        System.out.println("result = " + result.buyChoco(prices3, money3));
    }


}
