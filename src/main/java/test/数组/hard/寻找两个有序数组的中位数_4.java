package test.数组.hard;


/**
 * Created by mengyue on 2019-11-04.
 */


public class 寻找两个有序数组的中位数_4 {


    public static void main(String[] args) {



        int[] A = {4, 5, 6};
        int[] B = {1, 2, 3, 7, 8, 9};

        System.out.println(findMedianSortedArrays(A, B));

    }

    /**
     *
     * 思路：第四种解题方法
     *
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
     *
     *
     *
     * @param A
     * @param B
     * @return
     */
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            //TODO 这里为什么要保证 m<=n呢
            return findMedianSortedArrays(B, A); // 保证 m <= n
        }
        //还有这里切的是m数组 也就是较小的那个数组
        int min = 0, max = m;
        while (min <= max) {
            int i = (min + max) / 2;
            int j = (m + n + 1) / 2 - i;

            /**
             * 正常
             * A[i-1] < A[i]
             * B[j-1] < B[j]
             * 因为A B两个数组原本是有序的 所以 i-1 < i 是自然的
             *
             *
             * 但是无法保证 B[j-1] < A[i] 以及 A[i-1] < B[j] 这两种情况
             *
             *
             *
             */

            if (j != 0 && i != m && B[j - 1] > A[i]) {
                // i 需要增大 B[j-1] < A[i] 不成立的条件下 i需要增大（也就是像右移动）而j需要减小（也就是像左移动）
                min = i + 1;
            } else if (i != 0 && j != n && A[i - 1] > B[j]) {
                // i 需要减小 A[i-1] < B[j] 不成立
                max = i - 1;
            } else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }


}
