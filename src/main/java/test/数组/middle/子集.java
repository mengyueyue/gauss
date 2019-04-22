package test.数组.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengyue on 2018/9/22.
 */
public class 子集 {


    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void recursion(List<List<Integer>> result, List<Integer> list, int[] nums, int j) {
        result.add(new ArrayList<>(list));
        for (int i = j; i < nums.length; i++) {
            list.add(nums[i]);
            recursion(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
