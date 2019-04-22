package test.数组.easy;

/**
 * Created by mengyue on 2018/9/16.
 */
public class 寻找数组的中心索引 {


    public static void main(String[] args) {

        int[] n = new int[]{-1, -1, -1, -1, -1, 0};
        System.out.println(pivotIndex(n));
    }


    public static int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
