package test.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mengyue on 2018/8/13.
 */
public class 子集 {


    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 2};
        List<List<Integer>> result = subsets(nums);
        System.out.println(result.size());
        System.out.println(Arrays.toString(result.toArray()));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
