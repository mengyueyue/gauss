package test.数组.easy;

/**
 * Created by mengyue on 2018/9/15.
 */
public class 最长连续递增序列 {

    public static void main(String[] args) {

        int[] n = new int[]{1, 3, 5, 4, 7};
        System.out.println(findLengthOfLCIS(n));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int cur = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                cur++;
                pre = nums[i];
            } else {
                pre = nums[i];
                max = Math.max(max, cur);
                cur = 1;
            }
        }
        return Math.max(max, cur);
    }
}
