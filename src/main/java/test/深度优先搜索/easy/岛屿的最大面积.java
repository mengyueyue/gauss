package test.深度优先搜索.easy;

/**
 * Created by mengyue on 2018/8/24.
 */
public class 岛屿的最大面积 {


    /**
     *
     *给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。

     找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)

     示例 1:

     [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     [0,0,0,0,0,0,0,1,1,1,0,0,0],
     [0,1,1,0,1,0,0,0,0,0,0,0,0],
     [0,1,0,0,1,1,0,0,1,0,1,0,0],
     [0,1,0,0,1,1,0,0,1,1,1,0,0],
     [0,0,0,0,0,0,0,0,0,0,1,0,0],
     [0,0,0,0,0,0,0,1,1,1,0,0,0],
     [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。

     示例 2:

     [[0,0,0,0,0,0,0,0]]
     对于上面这个给定的矩阵, 返回 0。

     注意: 给定的矩阵grid 的长度和宽度都不超过 50。
     *
     * @param args
     */

    public static void main(String[] args) {

    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int result = search(i, j, grid);
                    max = Math.max(max, result);
                }
            }
        }
        return max;
    }

    public int search(int i, int j, int[][] grid) {
        int sum = 0;
        if (i < grid.length && i >= 0 && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            sum += 1 + search(i + 1, j, grid) + search(i - 1, j, grid) + search(i, j + 1, grid) + search(i, j - 1, grid);
        }
        return sum;
    }
}
