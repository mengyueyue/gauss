package test.数学.easy;

import java.util.Arrays;

/**
 * Created by mengyue on 2018/8/23.
 */
public class 最小移动次数使数组元素相等453 {


    public static void main(String[] args) {

    }

    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int min = nums[nums[0]];
        int step = 0;
        while (min != max) {

            step++;
        }
        return step;
    }
}
