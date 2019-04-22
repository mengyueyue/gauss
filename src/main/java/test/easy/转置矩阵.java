package test.easy;

import java.util.Arrays;

import junit.framework.Assert;

/**
 * Created by mengyue on 2018/7/24.
 */
public class 转置矩阵 {

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] a = {{1, 2, 3}, {4, 5, 6}};
        Assert.assertEquals(Arrays.deepToString(other(a)), Arrays.deepToString(self(a)));
    }

    /**
     *
     * 方法：直接复制
     思路和算法
     尺寸为 R x C 的矩阵 A 转置后会得到尺寸为 C x R 的矩阵 ans，对此有 ans[c][r] = A[r][c]。
     让我们初始化一个新的矩阵 ans 来表示答案。然后，我们将酌情复制矩阵的每个条目。

     复杂度分析
     时间复杂度：O(R * C)O(R∗C)，其中 RR 和 CC 是给定矩阵 A 的行数和列数。
     空间复杂度：O(R * C)O(R∗C)，也就是答案所使用的空间。
     *
     *
     */


    /**
     * 标准答案
     */
    public static int[][] other(int[][] A) {
        int[][] result = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

    /**
     * 自己的答案
     *
     * @param A
     * @return
     */
    public static int[][] self(int[][] A) {
        int[][] result = new int[A[0].length][A.length];
        int[] c;
        for (int i = 0; i < A[0].length; i++) {
            c = null;
            for (int j = 0; j < A.length; j++) {
                if (c == null) {
                    c = new int[A.length];
                }
                c[j] = A[j][i];
            }
            result[i] = c;
        }
        return result;
    }
}
