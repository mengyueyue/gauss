package test.滑动窗口.hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by mengyue on 2019-10-14.
 */
public class 滑动窗口中位数_480 {


    /**
     * 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
     * <p>
     * 例如：
     * <p>
     * [2,3,4]，中位数是 3
     * <p>
     * [2,3]，中位数是 (2 + 3) / 2 = 2.5
     * <p>
     * 给出一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
     * <p>
     * 例如：
     * <p>
     * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
     * <p>
     * 窗口位置                      中位数
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       1
     * 1 [3  -1  -3] 5  3  6  7       -1
     * 1  3 [-1  -3  5] 3  6  7       -1
     * 1  3  -1 [-3  5  3] 6  7       3
     * 1  3  -1  -3 [5  3  6] 7       5
     * 1  3  -1  -3  5 [3  6  7]      6
     *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
     * <p>
     * 提示：
     * 假设k是合法的，即：k 始终小于输入的非空数组的元素个数.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sliding-window-median
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */


    /***
     *
     *思路：
     * 维护两个堆
     * 一个大根堆：用来存 窗口内 较小的那一半数 然后这一半的大根堆index=0 的位置就是 偶数（就是中位数里小的那个数） 奇数（就是中位数）
     * 一个小根堆：用来存 窗口内 较大的那一半数 然后这一半的大根堆index=0 的位置就是 偶数（就是中位数里大的那个数）
     *
     * 但要维持这两个堆的大小保持一直（偶数情况） 或者是大根堆里比小根堆多一个数（奇数情况）
     *
     *
     * @param args
     */


    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};

        System.out.println(Arrays.toString(medianSlidingWindow(nums, 3)));

    }


    public static double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1; // 结果的尺寸
        double[] res = new double[m];
        //两个堆，一个最大堆，一个最小
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // 让maxHeap始终保存小于一半的值，minHeap保存大于一半的，

            /**
             *
             * maxHeap 存着窗口中较小的值 所以有小于中位数的值 maxHeap就要load进来
             */

            if (maxHeap.size() == 0 || maxHeap.peek() >= num)
                maxHeap.add(num);
            else minHeap.add(num);
            // 维护两个堆，保证两个堆得大小，要么保持一致（偶数时），要么maxHeap多一个（奇数时）
            maintainHeap(minHeap, maxHeap);
//            if (minHeap.size() > maxHeap.size())
//                maxHeap.add(minHeap.poll());
//            if (maxHeap.size() > minHeap.size() + 1)
//                minHeap.add(maxHeap.poll());
            // 如果需要输出
            if (i - k + 1 >= 0) {
                if (k % 2 == 1)
                    res[i - k + 1] = maxHeap.peek();
                else
                    res[i - k + 1] = (maxHeap.peek() / 2.0 + minHeap.peek() / 2.0); // 小心溢出
                //移除并更新
                int toBeRemove = nums[i - k + 1];
                if (toBeRemove <= maxHeap.peek())
                    maxHeap.remove(toBeRemove);
                else minHeap.remove(toBeRemove);
                // 维护两个堆，保证两个堆得大小，要么保持一致（偶数时），要么maxHeap多一个（奇数时）
                maintainHeap(minHeap, maxHeap);
//
//                if (minHeap.size() > maxHeap.size())
//                    maxHeap.add(minHeap.poll());
//                if (maxHeap.size() > minHeap.size() + 1)
//                    minHeap.add(maxHeap.poll());

            }
        }
        return res;

    }

    public static void maintainHeap(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {

        /**
         *
         *
         * 因为我们的目标是minHeap <= maxHeap
         * 所以不符合这个标准的情况 都要做平衡
         *
         *
         * 所以就需要把 靠近中位数的值 给对方 其实也就是index = 0的值拉
         *
         */

        if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
    }
}
