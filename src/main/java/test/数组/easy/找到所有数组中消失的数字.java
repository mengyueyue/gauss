package test.数组.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mengyue on 2018/9/15.
 */
public class 找到所有数组中消失的数字 {

    public static void main(String[] args) {

        int[] nums = new int[]{2,1,3};
        findDisappearedNumbers(nums);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int j = 0;
        /**
         *
         *   这种排序方式 适合1-n的乱序并且是连续的
         *
         *   而其他的排序算法 是可以 不连续的 m-n都可以的
         */
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
            j++;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(j);
        for (int i = 1; i <= nums.length; i++) {
            if (i != nums[i - 1]) {
                list.add(nums[i - 1]);
            }
        }
        return list;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
