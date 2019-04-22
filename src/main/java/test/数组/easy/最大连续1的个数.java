package test.数组.easy;

/**
 * Created by mengyue on 2018/8/20.
 */
public class 最大连续1的个数 {


    public static void main(String[] args) {


    }


    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Integer.max(max, sum);
                sum = 0;
            } else {
                sum++;
            }
        }
        return Integer.max(max, sum);
    }
}
