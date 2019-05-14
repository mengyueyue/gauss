package test.数组.middle;

import java.util.Arrays;

/**
 * Created by mengyue on 2019-05-10.
 */
public class 除自身以外数组的乘积 {

    /**
     * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * <p>
     * 进阶：
     * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = new int[]{2, 3, 4, 5};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }

    /**
     * 2,3,4,5 =====> 1,2,6,24 (由左向右乘了一遍的结果)
     * (这个是通过 不包含自身的 前面的位数的乘积 )
     * (第一位2 不包含自身 但也不能为0 所以 2 => 1 = 1)
     * (第二位3 不包含自身 但包含前一位2 所以 3 => 1*2 = 2)
     * (第三位4 不包含自身 但包含前两位2,3 所以 4 => 1*2*3 = 6)
     * (第四位5 不包含自身 但包含前三位2,3,4 所以 5 => 1*2*3*4 = 24)
     * <p>
     * 2,3,4,5 =====> 60,20,5,1 (由右向左乘积了一遍的结果)
     * (第一位5 不包含自身 但也不能为0 所以 5 => 1 = 1)
     * (第二位4 不包含自身 但包含后一位5 所以 4 => 1*5 = 5)
     * (第三位3 不包含自身 但包含后两位4,5 所以 3 => 1*5*4 = 20)
     * (第四位2 不包含自身 但包含后三位3,4,5 所以 2 => 1*5*4*3 = 60)
     * <p>
     * 最后 将 1,2,6,24 和 60,20,5,1 对位相乘 就是结果了 也就是 [60, 40, 30, 24]
     *
     * @param nums 这个写法 浪费内存 但是 易于理解
     * @return
     */

    public static int[] productExceptSelf(int[] nums) {
        int[] q1 = new int[nums.length];
        int s1 = 1;
        for (int i = 0; i < nums.length; i++) {
            q1[i] = s1;
            s1 *= nums[i];
        }

        int[] q2 = new int[nums.length];
        int s2 = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            q2[i] = s2;
            s2 *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            q1[i] = q1[i] * q2[i];
        }
        return q1;

    }

    /**
     *
     * 这个写法 节省内存 但是 不利于理解
     *
     */
//    public static int[] productExceptSelf(int[] nums) {
//        int[] q = new int[nums.length];
//        int s = 1;
//        for (int i = 0; i < nums.length; i++) {
//            q[i] = s;
//            s = s * nums[i];
//        }
//        int s2 = 1;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            q[i] = q[i] * s2;
//            s2 = s2 * nums[i];
//        }
//        return q;
//    }
}
