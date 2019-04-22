package test.数组.easy;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengyue on 2018/9/22.
 */
public class 数组的度 {

    public static void main(String[] args) {

    }


    public static int findShortestSubArray(int[] nums) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            //出席
            count.computeIfPresent(key, (k, v) -> v + 1);
            right.put(key, i);
            left.putIfAbsent(key, i);
            //缺席
            count.putIfAbsent(key, 1);
            max = Math.max(max, count.get(key));
        }
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (count.get(key) == max) {
                min = Math.min(min, right.get(key) - left.get(key) + 1);
            }
        }
        return min;
    }
}
