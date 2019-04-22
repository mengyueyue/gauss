package 动态规划.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengyue on 2018/7/29.
 */
public class 爬楼梯 {

    /**
     *
     *
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     *
     * 示例 1：
     *
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     *
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 23223;
        System.out.println(climbStairs(n));
        //容易StackOverflow
        //System.out.println(climbStairs1(n));
        //System.out.println(climbStairs2(n));
    }


    /**
     * 0 + 1 = 1
     * 1 + 2 = 3
     * 3 + 3 = 6
     * 6 + 4 = 10
     * 10 + 5 = 15
     * <p>
     * 有点这样的意思
     *
     *
     * 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        return n == 0 ? 0 : n == 1 ? 1 : n == 2 ? 2 : greatThan2(n);
    }

    public static int greatThan2(int n) {
        int a = 1, b = 2, temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

    /**
     * 像一棵树一样的 自顶向下的递归求和
     *
     *
     *              n
     *        n-1       n-2
     *     n-2   n-3  n-3  n-4
     *    .....................
     *
     * 1  2 ... 1  2 ... 1   2 ....1  2
     *
     *
     * 然后从树低慢慢向上合并, 递归到头了, 然后就相当于出栈 , 相加的操作
     *
     * 时间复杂度O(2^n) 空间复杂度O(1)
     *
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    /**
     *
     * 备忘录法 将算过的n保存起来
     *
     * 时间复杂度O(n) 空间复杂度O(n)
     */
    static Map<Integer, Integer> map = new HashMap<>();

    public static int climbStairs2(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int result = climbStairs2(n - 1) + climbStairs2(n - 2);
            map.put(n, result);
            return result;
        }
    }
}
