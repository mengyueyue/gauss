package test.动态规划.middle;

/**
 * Created by mengyue on 2018/9/5.
 */
public class 零钱兑换 {

    public static void main(String[] args) {

        int[] coins = new int[]{5, 3, 2, 1};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }


//    public static int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        for (int i = 1; i <= amount; i++) {
//            dp[i] = 0x7fffffff;
//            for (int j = 0; j < coins.length; j++)
//                if (i >= coins[j] && dp[i - coins[j]] != 0x7fffffff)  //①
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//        }
//        return dp[amount] == 0x7fffffff ? -1 : dp[amount];
//    }


    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = 0x7fff_fffe;
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        return dp[amount] == 0x7fff_fffe ? -1 : dp[amount];
    }
}
