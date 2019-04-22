package test.动态规划.middle;

/**
 * Created by mengyue on 2018/8/21.
 */
public class 最小路径和 {


    public static void main(String[] args) {

        int[][] grid = new int[3][3];
        int[] first = new int[]{1, 3, 1};
        int[] secon = new int[]{1, 5, 1};
        int[] three = new int[]{4, 2, 1};
        grid[0] = first;
        grid[1] = secon;
        grid[2] = three;

        System.out.println(minPathSum(grid));

    }


    public static int minPathSum(int[][] grid) {
        return dfs(0, 0, grid);
    }

    public static int dfs(int i, int j, int[][] grid) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (i < grid.length - 1 && j < grid[0].length - 1) {
            int r1 = grid[i][j] + dfs(i + 1, j, grid);
            int r2 = grid[i][j] + dfs(i, j + 1, grid);
            return Math.min(r1, r2);
        }

        if (i < grid.length - 1) {
            return grid[i][j] + dfs(i + 1, j, grid);
        }

        if (j < grid[0].length - 1) {
            return grid[i][j] + dfs(i, j + 1, grid);
        }

        return 0;
    }



//    /**
//     *
//     * 思想：任何一个点 都是由 左点或者是上点 通过 向右或向下移动过来的，
//     *  所以根据动态规划的思想来说，想求到这一点的最小路径，那么在到达我的上一步之前，他的路径也应该是最短的
//     *  所以这个坐标就可以转化为 每一个点记录 从{0,0}点到这一点的最短路径是多少
//     *
//     * @param grid
//     * @return
//     */
//    public static int minPathSum(int[][] grid) {
//        int m = grid.length, n = grid[0].length;
//        int dp[][] = new int[m][n];
//        dp[0][0] = grid[0][0];
//        //为什么要有这两个for循环呢？
//        /**
//         * 因为 如果一直向下走的话，那么{0,0}点距{0,m}点的距离，就是{0,0}点加到{0,m}点的距离
//         */
//        for (int i = 1; i < m; ++i) {
//            dp[i][0] = grid[i][0] + dp[i - 1][0];
//        }
//        for (int i = 1; i < n; ++i) {
//            dp[0][i] = grid[0][i] + dp[0][i - 1];
//        }
//        //为什么从{1,1}点开始 ，因为一直想右或向下的值通过上面的两个for已经求出
//        for (int i = 1; i < m; ++i) {
//            for (int j = 1; j < n; ++j) {
//                //grid[i][j] 这一点距离的值 加上 不论是左点还是上点 这两个点的最小路径 的和 就等于 {i,j}这一点到{0,0}点的最短路径
//                dp[i][j] = grid[i][j] + Integer.min(dp[i - 1][j], dp[i][j - 1]);
//            }
//        }
//        return dp[m - 1][n - 1];
//    }
}
