package 动态规划.easy;

/**
 * Created by mengyue on 2018/7/29.
 */
public class 打家劫舍 {

    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob(array));
    }

    /**
     * 1，3，5，7 和 0，2，4，6比较的方法
     * 得出一个最大值，然后在用两个数保存奇数的和 以及偶数的和 ，然后不停的更换奇数和偶数
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {

        if (nums == null || nums.length < 1) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[1], nums[0]);
        }
        int max = 0;
        int n0 = nums[0];
        int n1 = nums[1];
        int temp = 0;
        for (int i = 2; i < nums.length; i++) {
            max = Math.max(n1, n0 + nums[i]);
            temp = n0 + nums[i];
            n0 = n1;
            n1 = temp;
        }
        return max;
    }

    /**
     *
     * 下面这种方法蠢死了 😂
     *
     */

//    public static int rob(int[] nums) {
//        int a = 0;
//        int b = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (i % 2 == 0) {
//                a = max(a + nums[i], b);
//            } else {
//                b = max(a, b + nums[i]);
//            }
//        }
//        return max(a, b);
//    }
//
//    public static int max(int a, int b) {
//        return a > b ? a : b;
//    }
}
