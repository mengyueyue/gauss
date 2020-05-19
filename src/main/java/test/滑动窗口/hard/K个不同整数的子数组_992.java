package test.滑动窗口.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengyue on 2019-10-15.
 */
public class K个不同整数的子数组_992 {

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 3, 4};


        int result = subarraysWithKDistinct(A, 3);


        System.out.println(result);
    }


    /**
     * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
     * <p>
     * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
     * <p>
     * 返回 A 中好子数组的数目。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输出：A = [1,2,1,2,3], K = 2
     * 输入：7
     * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
     * 示例 2：
     * <p>
     * 输入：A = [1,2,1,3,4], K = 3
     * 输出：3
     * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= A.length <= 20000
     * 1 <= A[i] <= A.length
     * 1 <= K <= A.length
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static int subarraysWithKDistinct(int[] A, int K) {
        Window window1 = new Window();
        Window window2 = new Window();
        int ans = 0, left1 = 0, left2 = 0;

        for (int right = 0; right < A.length; ++right) {
            int x = A[right];
            window1.add(x);
            window2.add(x);
            /**
             *
             * 这个的变化  相当于比下面要慢一步 然后这慢的一步
             * 也就是能反应出 window2 窗口要缩小多少才能符合刚刚小于K的情况
             *
             * 然后window2窗口有可能变小1 也可能是2 ，或3 ， 因为它可能缩小的连续范围 比如都是有3个1 那么这3个1它都是需要跳过的
             *
             *
             */
            while (window1.different() > K)
                window1.remove(A[left1++]);
            while (window2.different() >= K)
                window2.remove(A[left2++]);

            ans += left2 - left1;
        }

        return ans;
    }

    static class Window {
        Map<Integer, Integer> count;
        int nonzero;

        Window() {
            count = new HashMap();

            nonzero = 0;
        }

        void add(int x) {
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 1)
                nonzero++;
        }

        void remove(int x) {
            count.put(x, count.get(x) - 1);
            if (count.get(x) == 0)
                nonzero--;
        }

        int different() {
            return nonzero;
        }
    }

}
