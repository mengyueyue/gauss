package test.动态规划.hard;

import java.util.Arrays;

/**
 * Created by mengyue on 2019-08-05.
 */
public class 戳气球 {

    /**
     * https://www.cnblogs.com/grandyang/p/5006441.html
     *
     * @param args
     */

    public static void main(String[] args) {

        int[] nums = {3, 1, 5, 8};
        maxCoins(nums);

    }


    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] N = new int[n + 2];
        int[][] dp = new int[n + 2][n + 2];

        System.out.println("step 1");
        printArray(dp);

        N[0] = 1;
        N[n + 1] = 1;
        for (int i = 1; i <= n; ++i)
            N[i] = nums[i - 1];


        System.out.println("step 2");
        printArray(N);


        // 这道题遍历的重点在于 i和j的范围

        // [3] -> [1] -> [5] -> [8] -> [3, 1] -> [1, 5] -> [5, 8] -> [3, 1, 5] -> [1, 5, 8] -> [3, 1, 5, 8]

        // 我们通过打印可以看出(i,j)的遍历顺序为
        /**
         *
         * 1-1 --> [3]
         * 2-2 --> [1]
         * 3-3 --> [5]
         * 4-4 --> [8]
         * 1-2 --> [3, 1]
         * 2-3 --> [1, 5]
         * 3-4 --> [5, 8]
         * 1-3 --> [3, 1, 5]
         * 2-4 --> [1, 5, 8]
         * 1-4 --> [3, 1, 5, 8]
         */
        /**
         * k的取值范围为
         * --- 在 i j的限制数据范围为1个大小时候的情况
         * k的值为：1
         * k的值为：2
         * k的值为：3
         * k的值为：4
         * --- 在 i j的限制数据范围为2个大小时候的情况
         * k的值为：1
         * k的值为：2
         *
         * k的值为：2
         * k的值为：3
         *
         * k的值为：3
         * k的值为：4
         *  --- 在 i j的限制数据范围为3个大小时候的情况
         * k的值为：1
         * k的值为：2
         * k的值为：3
         *
         * k的值为：2
         * k的值为：3
         * k的值为：4
         *  --- 在 i j的限制数据范围为4个大小时候的情况
         * k的值为：1
         * k的值为：2
         * k的值为：3
         * k的值为：4
         *
         */

        for (int m = 1; m <= n; ++m) {
            //System.out.println("m的值为：" + m);
            for (int i = 1; i <= n - m + 1; ++i) {
                // 因为i的值等于=n-m+1
                //j在
                int j = i + m - 1;
                //System.out.println("i和j的值为：" + i + "-" + j);
                /**
                 *
                 * i和j的值 来限制k可以取值的范围
                 *
                 * 所以k的初始值为i,终点值为j
                 *
                 */
                for (int k = i; k <= j; ++k) {
                    System.out.println("k的值为：" + k);
                    dp[i][j] = Math.max(dp[i][j], N[i - 1] * N[k] * N[j + 1] + dp[i][k - 1] + dp[k + 1][j]);
                }
            }
        }

        System.out.println("step 3");
        printArray(dp);

        /**
         *
         * todo 为什么最终的结果在[1][n]这个位置呢
         */
        return dp[1][n];
    }


    private static void printArray(int[][] array) {
        System.out.println(Arrays.deepToString(array));
    }

    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));

    }
}
