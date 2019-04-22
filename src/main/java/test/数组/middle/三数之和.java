package test.数组.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengyue on 2018/8/31.
 */
public class 三数之和 {


    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[k]);
                        list.add(subList);
                    }
                }
            }
        }
        return list;
    }
}
