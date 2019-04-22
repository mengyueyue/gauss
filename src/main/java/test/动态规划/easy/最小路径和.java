package test.动态规划.easy;

import java.util.Arrays;

/**
 * Created by mengyue on 2018/9/27.
 */
public class 最小路径和 {


    public static void main(String[] args) {

        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 3;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 5;
        grid[1][2] = 1;
        grid[2][0] = 4;
        grid[2][1] = 2;
        grid[2][2] = 1;
        System.out.println(Arrays.deepToString(grid));
        System.out.println(minPathSum(grid));
        System.out.println(Arrays.deepToString(grid));
    }


    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (i != 0 && j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else if (i == 0 && j == 0) {
                    grid[i][j] = grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
                            + grid[i][j];
                }
            }
        }

        return grid[m - 1][n - 1];
    }
}
