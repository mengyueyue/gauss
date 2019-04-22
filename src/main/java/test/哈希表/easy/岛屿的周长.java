package test.哈希表.easy;

/**
 * Created by mengyue on 2018/8/24.
 */
public class 岛屿的周长 {


    /**
     *
     *
     *
     *
     *
     * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

     示例 :

     [[0,1,0,0],
     [1,1,1,0],
     [0,1,0,0],
     [1,1,0,0]]

     答案: 16
     解释: 它的周长是下面图片中的 16 个黄色的边：


     *
     *
     *
     * @param args
     */


    public static void main(String[] args) {

        //[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
        int[][] grid = new int[4][4];
        int[] g1 = new int[]{0, 1, 0, 0};
        int[] g2 = new int[]{1, 1, 1, 0};
        int[] g3 = new int[]{0, 1, 0, 0};
        int[] g4 = new int[]{1, 1, 0, 0};
        grid[0] = g1;
        grid[1] = g2;
        grid[2] = g3;
        grid[3] = g4;
        System.out.println(islandPerimeter(grid));
    }

    /**
     * grid.length 是长
     * grid[0].length 是宽
     *
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid) {
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    total += getRound(i, j, grid, grid.length - 1, grid[0].length - 1);
                }
            }
        }
        return total;
    }

    public static int getRound(int a, int b, int[][] grid, int ilong, int width) {
        int r1 = (a - 1 < 0) ? 1 : grid[a - 1][b] == 0 ? 1 : 0;
        int r2 = (a + 1 > ilong) ? 1 : grid[a + 1][b] == 0 ? 1 : 0;
        int r3 = (b - 1 < 0) ? 1 : grid[a][b - 1] == 0 ? 1 : 0;
        int r4 = (b + 1 > width) ? 1 : grid[a][b + 1] == 0 ? 1 : 0;
        return r1 + r2 + r3 + r4;
    }
}
