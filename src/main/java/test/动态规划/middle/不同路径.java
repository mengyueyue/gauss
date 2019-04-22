package test.动态规划.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mengyue on 2018/11/26.
 */
public class 不同路径 {

    //https://leetcode.com/problems/unique-paths/discuss/22954/0ms-5-lines-DP-Solution-in-C++-with-Explanations
    public static void main(String[] args) {

        System.out.println(uniquePaths(4, 3));
    }


//    public static int uniquePaths(int cols, int rows) {
//        int[][] dp = new int[rows][cols];
//
//        for (int row = 0; row < rows; row++)
//            dp[row][0] = 1;
//
//        for (int col = 0; col < cols; col++)
//            dp[0][col] = 1;
//
//        for (int i = 1; i < rows; i++)
//            for (int j = 1; j < cols; j++)
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//
//        return dp[rows - 1][cols - 1];
//    }


    public static int uniquePaths(int cols, int rows) {
        int[] cur = new int[cols];
        int[] pre = new int[cols];

        for (int i = 0; i < cols; i++) {
            pre[i] = 1;
            cur[i] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                cur[j] = cur[j - 1] + pre[j];
            }
            pre = cur;
        }

        return cur[cols - 1];
    }
}
