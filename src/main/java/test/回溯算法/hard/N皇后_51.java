package test.回溯算法.hard;

import java.util.List;

/**
 * Created by mengyue on 2019-11-18.
 */
public class N皇后_51 {


    public static void main(String[] args) {

    }

    /**
     * row + col 代表 撇对角线 这样加完之后 会有大于n的数出现 所以他的范围是 (0,2n) 之间 中点是n 所以存放它的数组大小将会是2n
     * <p>
     * <p>
     * <p>
     * <p>
     * row - col 代表 捺对角线 这样减完 之后 会有负数的出现 所以他的范围是  (-n,n) 之间 中点是0 所以存放它的数组大小将会是4n
     * (为什么是4n呢 它只有0～2n个数呀 因为？？？？？？ 我自己也解释不通)
     * <p>
     * <p>
     * ![撇捺图片](https://pic.leetcode-cn.com/332b878ebcd261a71f5f85cb4e23685d42b37685112f562e2844079748e63cd0-51_diagonals.png)
     *
     * @param row
     * @param col
     * @param n
     * @param rows
     * @param hills
     * @param dales
     * @return
     */
    public boolean is_not_under_attack(int row, int col, int n,
                                       int[] rows,
                                       int[] hills,
                                       int[] dales) {

        //等于0的话 表示不在皇后的攻击范围下
        //这样 一个位置的数 其实就代表了 一列 或 一撇 或 一捺的结果

        // 一个皇后的 所有撇对角线 row + col 的值都是相等的 所以才会出现下面这样的判断 一个位置的值 就代表了 整个对角线的结果
        // 而且不同的撇对角线 他们row + col的值都是不一样的 所以才可以反应在不同的数组位置上
        int res = rows[col] + dales[row + col] + hills[row - col + 2 * n];
        return res == 0;
    }

    public int backtrack(int row, int count, int n,
                         int[] rows,
                         int[] hills,
                         int[] dales) {
        for (int col = 0; col < n; col++) {
            if (is_not_under_attack(row, col, n, rows, hills, dales)) {
                // place_queen
                rows[col] = 1;
                hills[row - col + 2 * n] = 1;  // "hill" diagonals
                dales[row + col] = 1;   //"dale" diagonals

                // if n queens are already placed
                if (row + 1 == n) count++;
                    // if not proceed to place the rest
                else count = backtrack(row + 1, count, n,
                        rows, hills, dales);

                // remove queen
                rows[col] = 0;
                hills[row - col + 2 * n] = 0;
                // 撇 对角线
                dales[row + col] = 0;
            }
        }
        return count;
    }

    public int totalNQueens(int n) {
        int rows[] = new int[n];
        // "hill" diagonals 主对角线
        int hills[] = new int[4 * n - 1];
        // "dale" diagonals 次对角线
        int dales[] = new int[2 * n - 1];

        return backtrack(0, 0, n, rows, hills, dales);
    }

}
