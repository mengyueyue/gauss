package test.数组.easy;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengyue on 2018/9/16.
 */
public class 存在重复元素II {

    public static void main(String[] args) {


    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean result = false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
