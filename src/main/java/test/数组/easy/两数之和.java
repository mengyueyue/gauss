package test.数组.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengyue on 2018/8/20.
 */
public class 两数之和 {


    public static void main(String[] args) {

        int[] nums = new int[]{2, 11, 15, 7};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }


//    public static int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    result[0] = i;
//                    result[1] = j;
//                }
//            }
//        }
//        return result;
//    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int component = target - nums[i];
            if (map.containsKey(component)) {
                return new int[]{map.get(component), i};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("error");
    }
}
