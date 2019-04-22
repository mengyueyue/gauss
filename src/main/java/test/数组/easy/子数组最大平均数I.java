package test.数组.easy;

/**
 * Created by mengyue on 2018/9/16.
 */
public class 子数组最大平均数I {


    public static void main(String[] args) {

        int[] nums = new int[]{-1};
        int k = 1;
        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int sum = 0;
            int j = 0;
            while (j < k) {
                sum += nums[j + i];
                j++;
            }
            result = Math.max(result, (double) sum / k);
        }
        return result;
    }
}
