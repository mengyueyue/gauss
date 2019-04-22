package 动态规划.easy;


/**
 * Created by mengyue on 2018/7/29.
 */


public class 买卖股票的最佳时机 {

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意你不能在买入股票前卖出股票。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     * <p>
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @param args
     */
    public static void main(String[] args) {

        //int[] array = new int[]{7, 1, 5, 3, 6, 4};
        int[] array = new int[]{2, 7, 1, 5, 3, 8, 4};
        System.out.println(maxProfit(array));

    }

    /**
     * 暴力循环 不好不好
     * 时间发杂度O(N2)
     *
     * @param prices
     * @return
     */

//    public static int maxProfit(int[] prices) {
//        // write your code here
//        int Max = 0;
//        if (prices == null || prices.length == 0)
//            return 0;
//
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i; j < prices.length; j++)
//                Max = Math.max(Max, prices[j] - prices[i]);
//        }
//        return Max;
//    }


    /**
     * 下面这个很棒 直接分析到问题的关键 ，找最低和最高，其实就是这股票的最大利润
     * <p>
     * 这提虽然是找最低最高 但并不是全局的最低和最高 ,而是最低一定要在最高的前面
     * <p>
     * minbuy = Math.min(minbuy, prices[i]) 这段代码能始终保持找到全局最小的数
     * <p>
     * <p>
     * result = Math.max(result, prices[i] - minbuy)
     * 的 prices[i] - minbuy 能够确保 [4 8 1] 这种情况 也就是全局最低并不是最终最低的情况
     * 当 index = 3 时 , 此时minbuy的值是 1 而prices[i]的值也是 1 ,所在它并不会在 Math.max中胜出
     * <p>
     * 最后的结果是: Math.max(4 , 1 - 1) ,所以结果是4 , 而不是 7
     */

    public static int maxProfit(int[] prices) {
        // write your code here
        int result = 0;
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minbuy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 最小的购买，最大的卖
            minbuy = Math.min(minbuy, prices[i]);
            result = Math.max(result, prices[i] - minbuy);
        }
        return result;
    }
}
