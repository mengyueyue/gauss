package test.二分查找.hard;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by mengyue on 2019/3/25.
 * <p>
 * https://github.com/Shellbye/Shellbye.github.io/issues/41
 */


public class 和至少为K的最短子数组 {


    public static void main(String[] args) {

        int[] A = {1, -1, 5, -2, 3, 1, -9, 2};
        int K = 3;
        System.out.println(shortestSubarray(A, K));


    }

    /**
     * 条件1：
     * 比如当preSum[x2] <= preSum[x1]（其中x1 < x2）时，
     * 表明x1到x2之间的元素的和是负数或0，
     * 那么就是当preSum[xn] - preSum[x1] >= K则必然有preSum[xn] - preSum[x2] >= K，(这句话的意思 n - 5 >k 那么 n - 小于5的数也必定大于k)
     * 那么这个时候我们只计算xn - x2即可（x1到x2之间的元素可以全部跳过了，耶！），
     * 就不需要计算xn - x1了，因为后者一定是更大的，不满足我们要选最小的条件。
     * <p>
     * <p>
     * 条件2：
     * 当preSum[x2] - preSum[x1] >= K时，x1就可以跳过了，为什么呢？
     * 因为x1到x2已经满足了大于K，再继续从x1开始向后再找，
     * 也不会再有比x2距离x1更近的了，毕竟我们要求的是最小的x2 - x1
     *
     * @param A
     * @param K
     * @return
     */

    public static int shortestSubarray(int[] A, int K) {
        int[] preSum = new int[A.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < A.length; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        int minLength = A.length + 1;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < A.length + 1; i++) {
            // 判断preSum[x2] <= preSum[x1]条件
            while (!deque.isEmpty() && preSum[i] <= preSum[deque.getLast()]) {
                deque.pollLast();
            }
            //判断 preSum[x2] - preSum[x1] >= K
            while (!deque.isEmpty() && preSum[i] - preSum[deque.getFirst()] >= K) {
                int newLength = i - deque.pollFirst();
                minLength = newLength < minLength ? newLength : minLength;
            }
            deque.addLast(i);
        }
        return minLength == A.length + 1 ? -1 : minLength;
    }


}
