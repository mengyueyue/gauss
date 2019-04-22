package 动态规划.easy;

/**
 * Created by mengyue on 2018/7/29.
 */
public class 最大子序和 {

    public static void main(String[] args) {

        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(array));
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int sumMax = nums[0];
        for (int i : nums) {
            sum += i;
            sumMax = Math.max(sumMax, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return sumMax;

    }
}
