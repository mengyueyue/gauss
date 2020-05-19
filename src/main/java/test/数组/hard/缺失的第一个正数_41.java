package test.数组.hard;

/**
 * Created by mengyue on 2020-02-07.
 */
public class 缺失的第一个正数_41 {


    public static void main(String[] args) {


    }


    /**
     *链接：https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            //i位置的数 不等于 i+1的 这个数 我们就认为他是 缺失的第一个正数
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        //上面为什么能够这么肯定的返回 num.len + 1呢?
        /**
         * 因为假设数组里有 num.len + 1 缺失的第一个正数 这个数那么一定是小于等于num.len的 因为num.len + 1 占了一个坑
         *
         * 小于等于num.len的数中 就必定会少一个数 因为数组大小是定的呀
         *
         */

        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
