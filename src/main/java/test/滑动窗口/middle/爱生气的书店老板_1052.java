package test.滑动窗口.middle;

/**
 * Created by mengyue on 2019-10-23.
 */
public class 爱生气的书店老板_1052 {


    /**
     * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
     * <p>
     * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
     * <p>
     * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
     * <p>
     * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
     * 输出：16
     * 解释：
     * 书店老板在最后 3 分钟保持冷静。
     * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= X <= customers.length == grumpy.length <= 20000
     * 0 <= customers[i] <= 1000
     * 0 <= grumpy[i] <= 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {


        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};

        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};

        int x = 3;

        System.out.println(maxSatisfied(customers, grumpy, x));

    }

    /**
     * 整体的思路：满意的顾客 和 不满意的顾客 分开去计算（为什么可以 这样去计算呢 因为 老板在满意的X分钟 之内 可以将不好的变好 好的不变
     * 所以这x分钟 最后的效果 就是 满意num + max(不满意num) 的总和）
     *
     * 满意顾客的处理: 在遍历for循环的时候 找出 grumpy中等于0的值 然后加起来 就OK了
     *
     * 不满意顾客的处理: 在遍历for 循环的时候 我们还是用一个窗口 当然这个窗口的大小 就是X了 然后找grumpy中等于1的值 在这个窗口范围内的
     *
     * 当然窗口中会有满意的顾客 我们只要把他们的值 当做0就可以了 然后不断的移动 窗口 进来的值加上 出去的值 减去 动态的去判断max 就可以了
     *
     * 最后 要将 满意的值 + max(不满意的值) ok!
     *
     *
     *
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {

        int N = grumpy.length;
        int W = 0;
        int ans = 0;
        int max_W = 0;

        for (int i = 0; i < N; ++i) {
            if (grumpy[i] == 0) ans += customers[i];
            /**
             *
             *
             *
             */
            else W += grumpy[i] == 1 ? customers[i] : 0;
            if (i >= X) {
                W -= grumpy[i - X] == 1 ? customers[i - X] : 0;
            }
            max_W = Math.max(max_W, W);
        }
        return ans + max_W;

    }
}
