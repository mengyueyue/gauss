package self.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mengyue on 2018/8/21.
 */

public class 子集的实现 {


    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(subSet(nums).toArray()));
    }

    public static List<List<Integer>> subSet(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        getSub(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    public static void getSub(List<List<Integer>> list, List<Integer> temp, int[] nums, int start) {
        list.add(new ArrayList<>(temp));
        for (int j = start; j < nums.length; j++) {
            temp.add(nums[j]);
            getSub(list, temp, nums, j + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
