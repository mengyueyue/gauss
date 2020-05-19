package test.回溯算法.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mengyue on 2019-11-11.
 */
public class 全排列II {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2};

        List<List<Integer>> resultList = permuteUnique(nums);

        System.out.println(resultList);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(nums);

        int[] v = new int[nums.length];

        backtrack(resultList, new ArrayList<>(), nums, v);

        return resultList;
    }

    public static void backtrack(List<List<Integer>> resultList, List<Integer> tmp, int[] nums, int[] v) {

        if (tmp.size() == nums.length) {
            resultList.add(new ArrayList<>(tmp));
        }

        for (int i = 0; i < nums.length; i++) {

            if(v[i] != 1){
                // 比如 执行到了 i = 3 的位置 , 然后 i = 2的位置 和i=3的位置的值一样 , 并且没有使用过也就是v[i - 1] != 1 ,
                // 那么在回溯的时候 , 就会出现将这个值加入到tmp里的操作 也就是会出现 i i` i`` 和 i` i ii`` 这样的值出现
                // 这样的话 比如 i =1 i`=1 i``=1 这样的出现 就是有重复的

                if (i > 0 && nums[i] == nums[i - 1] && v[i - 1] != 1) {
                    continue;
                }

                tmp.add(nums[i]);

                v[i] = 1;

                backtrack(resultList, tmp, nums, v);

                v[i] = 0;

                tmp.remove(tmp.size() - 1);

            }

        }
    }
}
