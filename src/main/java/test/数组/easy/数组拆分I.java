package test.数组.easy;

import java.util.Arrays;

/**
 * 这道题有问题 如果数组为 -1, -4, -3, -2 那么根据题目要求，应该是 -4 啊 ！！！！！！1
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Created by mengyue on 2018/7/30.
 */
public class 数组拆分I {

    public static void main(String[] args) {
        int[] array = new int[]{-1, -4, -3, -2};
        System.out.println(arrayPairSum(array));
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

}
