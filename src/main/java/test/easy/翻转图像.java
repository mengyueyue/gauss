package test.easy;


import java.util.Arrays;

/**
 * Created by mengyue on 2018/7/25.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * <p>
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2:
 * <p>
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 说明:
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */
public class 翻转图像 {


    public static void main(String[] args) {

        int[][] param = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(param)));
    }

    /**
     * 自己的答案
     * <p>
     * 0转1，1转0的方式
     * 1.(x+1)%2
     * 2. x^1 异或
     *
     * @param A
     * @return
     */
//    public static int[][] flipAndInvertImage(int[][] A) {
//        int first = A.length;
//        int second = A[0].length;
//        int[][] level = new int[first][second];
//        for (int i = 0; i < first; i++) {
//            for (int j = 0; j < second; j++) {
//                level[i][j] = A[i][second - j - 1] == 0 ? 1 : 0;
//            }
//        }
//        return level;
//    }

    /**
     * 在不多申明额外空间的情况下
     *
     * @param A
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        int first = A.length;
        int second = (A[0].length - 1) / 2;
        int length = A[0].length - 1;
        for (int i = 0; i < first; i++) {
            for (int j = 0; j <= second; j++) {
                int temp = A[i][j];
                if (length - j != j) {
                    A[i][j] = A[i][length - j] ^ 1;
                }
                A[i][length - j] = temp ^ 1;
            }
        }
        return A;
    }
}
