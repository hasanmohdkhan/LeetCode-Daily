package easy.matrix;

/**
 * @Auther : hasan.khan
 * @Created : 05-Oct-23
 * @Description: <a href="https://leetcode.com/problems/richest-customer-wealth/description/">link</a>
 */
public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        int[] sums = new int[accounts.length];
        // System.out.println("init (sums) = " + Arrays.toString(sums));
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                // System.out.println("j = " + accounts[i][j]);
                sums[i] += accounts[i][j];
            }
        }

        int max = 0;
        for (int sum : sums) if (sum > max) max = sum;

        return max;
    }

    public static void main(String[] args) {
        int[][] sample1 = {{1, 2, 3}, {3, 2, 1}};
        int[][] sample2 = {{1, 5}, {7, 3}, {3, 5}};

        RichestCustomerWealth customerWealth = new RichestCustomerWealth();
        System.out.println("sample1 = " + customerWealth.maximumWealth(sample1));
        System.out.println("sample2 = " + customerWealth.maximumWealth(sample2));

    }
}
