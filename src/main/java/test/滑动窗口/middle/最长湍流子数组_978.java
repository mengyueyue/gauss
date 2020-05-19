package test.滑动窗口.middle;

/**
 * Created by mengyue on 2019-10-15.
 */
public class 最长湍流子数组_978 {


    public static void main(String[] args) {


    }


    /**
     * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
     * <p>
     * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
     * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
     * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
     * <p>
     * 返回 A 的最大湍流子数组的长度。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[9,4,2,10,7,8,8,1,9]
     * 输出：5
     * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
     * 示例 2：
     * <p>
     * 输入：[4,8,12,16]
     * 输出：2
     * 示例 3：
     * <p>
     * 输入：[100]
     * 输出：1
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= A.length <= 40000
     * 0 <= A[i] <= 10^9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 思路：
     * <p>
     * 显然，我们只需要关注相邻两个数字之间的符号就可以了。
     * <p>
     * 如果用 -1, 0, 1 代表比较符的话（分别对应 <、 =、 >），
     * <p>
     * 那么我们的目标就是在符号序列中找到一个最长的元素交替子序列 1, -1, 1, -1, ...（从 1 或者 -1 开始都可以）。
     * <p>
     * <p>
     * 如果是交替的话 那么前一个数 乘 后一个数 的结果是 -1 否则是其他数
     *
     * @param A
     * @return
     */

    public static int maxTurbulenceSize(int[] A) {
        int N = A.length;
        int ans = 1;
        int anchor = 0;

        for (int i = 1; i < N; ++i) {

            int c = Integer.compare(A[i - 1], A[i]);

            /**
             *
             * i == N - 1 是最后循环的一个数了  所以要特殊判断一下
             *
             * 这里的c 会和 Integer.compare(A[i], A[i + 1])比较一下 如果 !=-1的话 那么就代表 c这数的index也就是i是 i距离anchor的最大湍流值了
             *
             * c如果是因为 和下一个数 乘完的结果 因为!=-1 并且 c!=0这样(前两个数是不相等)的情况的话
             *
             *
             */
            /**
             *
             * 进入下面这个if判断 就至少代表锚点index要增加了
             * 1。因为没有连续的湍流
             * 2。因为当前湍流要断了
             */
            if (i == N - 1 || c * Integer.compare(A[i], A[i + 1]) != -1) {
                if (c != 0) {
                    //这样的情况是 前一个对比 不是湍流 终结点
                    //但下一个是湍流的终结点
                    ans = Math.max(ans, i - anchor + 1);
                }
                //前一个就是湍流的终结点 Integer.compare(A[i - 1], A[i]) * Integer.compare(A[i], A[i + 1])
                // 因为 c = 0了
                anchor = i;
            }
        }

        return ans;
    }

}

