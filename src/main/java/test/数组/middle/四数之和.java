package test.数组.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mengyue on 2019-07-18.
 */
public class 四数之和 {


    public static void main(String[] args) {

        int[] nums = {0, 4, -5, 2, -2, 4, 2, -1, 4};
        int target = 12;

        List<List<Integer>> result = fourSum(nums, target);
        result.forEach(x -> System.out.println(x.toString()));

    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 4) return lists;

        Arrays.sort(nums);


        for (int z = 0; z < nums.length; z++) {

            if (z > 0 && nums[z] == nums[z - 1]) continue;
            int newTarget = target - nums[z];   // 将四数之和转化为3数

            for (int k = z + 1; k < nums.length; k++) {   // 三数变成两数

                if (k > z + 1 && nums[k] == nums[k - 1]) continue;
                int newTarget2 = newTarget - nums[k];
                int i = k + 1, j = nums.length - 1;
                while (i < j) {              // 两数之和直接套用《两数之和2》的题
                    if (nums[i] + nums[j] == newTarget2) {
                        lists.add(Arrays.asList(nums[z], nums[k], nums[i], nums[j]));
                        while (i < j && nums[i] == nums[i + 1]) ++i;   //注意去重
                        while (i < j && nums[j] == nums[j - 1]) --j;
                        ++i;
                        --j;
                    } else if (nums[i] + nums[j] < newTarget2) {
                        ++i;
                    } else {
                        --j;
                    }

                }
            }

        }
        return lists;

    }
}
