package test.动态规划.hard;

/**
 * Created by mengyue on 2018/8/28.
 */
public class 买卖股票的最佳时机III {


    public static void main(String[] args) {
        int[] array = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(array));
    }

    public static int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int sell1 = 0, sell2 = 0;

        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }

        return sell2;
    }
}
