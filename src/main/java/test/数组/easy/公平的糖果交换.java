package test.数组.easy;

import java.util.*;

/**
 * Created by mengyue on 2019-05-13.
 */
public class 公平的糖果交换 {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(fairCandySwap(new int[]{1, 2}, new int[]{2, 3})));
    }


    /**
     * 重点方程 B(B中任意元素) = ( sum_b - sum_a ) / 2 + A (A中任意元素)
     *
     *
     * 下面代码的 diff相减不能 和B变成 set 遍历A集合 不能反了 否则 结果不对
     *
     * 证明：
     *
     *  成立的可能性：
     *
     *  1.
     *      假设： sum_b - sum_a > 0 也就是正数
     *      得出： B > A
     *      得出： 上面的重点方程 有成立的可能
     *  2.
     *      假设： sum_b - sum_a < 0 也就是负数
     *      得出： B < A
     *      得出： 上面的重点方程 有可能成立
     *
     *  不成立的可能性
     *
     *  假设： 上面的方程 变成了 B = (sum_a - sum_b ) / 2 + A
     *
     *  1.
     *      假设： sum_a - sum_b  > 0 也就是正数的情况下
     *      得出： A > B
     *      但是： 假设的方程不成立了 B(小) != (sum_a - sum_b ) / 2 (正数) + A (大)
     *
     *  2.
     *      假设： sum_a - sum_b  < 0 也就是负数的情况下
     *      得出： A < B
     *      但是： 假设的方程不成立了 B(大) != (sum_a - sum_b ) / 2 (负数) + A (小)
     *
     *
     *
     * @param A
     * @param B
     * @return
     */
    public static int[] fairCandySwap(int[] A, int[] B) {

        int s1 = sum(A), s2 = sum(B);

        int diff = (s2 - s1) / 2;

        Set<Integer> set = new HashSet<>();

        for (int i : B) {
            set.add(i);
        }

        for (int i : A) {
            if (set.contains(diff + i)) {
                return new int[]{i, diff + i};
            }
        }

        return new int[]{};
    }

    private static int sum(int[] arr) {

        int sum = 0;

        for (int i : arr) {

            sum += i;
        }
        return sum;
    }

}
