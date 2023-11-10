import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Auther : hasan.khan
 * @Created : 02-Sep-23
 * @Description:
 */
class BestTimeToBuyAndSellStockTest {

    @Test
    public void testMaxProfit() {
        BestTimeToBuyAndSellStock calculator = new BestTimeToBuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expectedProfit = 5;
        int actualProfit = calculator.maxProfit(prices);
        assertEquals(expectedProfit, actualProfit);

    }

}
