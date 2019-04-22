package test.数组.easy;

/**
 * Created by mengyue on 2018/9/15.
 */
public class 至少是其他数字两倍的最大数 {


    public static void main(String[] args) {

        int[] nums = new int[]{ 0, 1};
        System.out.println(dominantIndex(nums));
    }

    public static int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int first;
        int second;
        int index;
        int pre;
        if (nums[0] > nums[1]) {
            first = nums[0];
            second = nums[1];
            index = 0;
        } else {
            first = nums[1];
            second = nums[0];
            index = 1;
        }
        for (int i = 2; i < nums.length; i++) {
            pre = first;
            second = Math.max(second, nums[i]);
            first = Math.max(second, first);
            if (pre != first) {
                second = pre;
                index = i;
                pre = first;
            }
        }
        if (second == 0) {
            return index;
        }
        return (first / second) >= 2 ? index : -1;
    }
}
