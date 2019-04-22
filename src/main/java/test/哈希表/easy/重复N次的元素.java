package test.哈希表.easy;

/**
 * Created by mengyue on 2019/2/13.
 */
public class 重复N次的元素 {


    public static void main(String[] args) {

        int[] A = {1, 3, 6, 5, 5, 2, 5, 5};
        System.out.println(repeatedNTimes(A));
    }
    /**
     *
     *
     * 在大小为 2N 的数组 A 中有 N+1 个不同的元素 , 其中有一个元素重复了 N 次。
     * (这不就明白着告诉你 除了重复N次的这个元素外 ,其他的元素都只出现一次)
     * 返回重复了 N 次的那个元素。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[1,2,3,3]
     * 输出：3
     * 示例 2：
     *
     * 输入：[2,1,2,5,3,2]
     * 输出：2
     * 示例 3：
     *
     * 输入：[5,1,5,2,5,3,5,4]
     * 输出：5
     *
     *
     * 提示：
     *
     * 4 <= A.length <= 10000
     * 0 <= A[i] < 10000
     * A.length 为偶数
     *
     *
     */

    /**
     * 此题有三种解法
     * <p>
     * 先来分析一波 😂
     * <p>
     * <p>
     *
     */

    /**
     *
     *解法一
     * @param A
     * @return
     */
//    public int repeatedNTimes(int[] A) {
//        int[] count = new int[10000];
//        for (int a : A)
//            if (count[a]++ == 1)
//                return a;
//        return -1;
//    }


    /**
     * 解法二
     * @param A
     * @return
     */
//    public static int repeatedNTimes(int[] A) {
//        for (int i = 2; i < A.length; ++i)
//            if (A[i] == A[i - 1] || A[i] == A[i - 2])
//                return A[i];
//        return A[0];
//    }


    /**
     * 解法三
     *
     * 随机挑两个数字。
     * 如果相同则返回。
     *
     * 50％得到正确的数字。
     * 每回合，25％得到两个正确的数字。
     * 将结果平均返回4圈。
     * 时间复杂O(4)，空间O(1)
     *
     * @param A
     * @return
     */
    public static int repeatedNTimes(int[] A) {
        int i = 0, j = 0, n = A.length;
        while (i == j || A[i] != A[j]) {
            i = (int) (Math.random() * n);
            j = (int) (Math.random() * n);
        }
        return A[i];
    }

}
