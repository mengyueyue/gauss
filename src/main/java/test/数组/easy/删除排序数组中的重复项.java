package test.数组.easy;

/**
 * Created by mengyue on 2018/9/15.
 */
public class 删除排序数组中的重复项 {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                continue;
            } else {
                pre = nums[i];
                int tmp = nums[result];
                nums[result] = nums[i];
                nums[i] = tmp;
                result++;
            }
        }
        return result;
    }
}
