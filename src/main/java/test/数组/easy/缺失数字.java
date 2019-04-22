package test.数组.easy;


/**
 * Created by mengyue on 2018/8/20.
 */
public class 缺失数字 {


    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 1, 0};
        System.out.println(missingNumber(nums));

    }

    /**
     * 等差数列
     *
     * @param nums
     * @return
     */
//    public static int missingNumber(int[] nums) {
//        int sum = 0, n = nums.length;
//        for (int a : nums) {
//            sum += a;
//        }
//        return (int) (0.5 * n * (n + 1) - sum);
//    }

    /**
     * 相当于 1，2，3，4 和 1，2，3，0 去异或 然后 相同的数异或后会变成 0 ，0和任何一个不等于0的数 异或还是本身
     *
     * 所以到最后 就是 4和0的异或 然后得4
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= (i + 1) ^ nums[i];
        }
        return res;
    }
}
