package test.回溯算法.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mengyue on 2018/8/13.
 */
public class 全排列 {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(permute(nums).toArray()));
    }

//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        // Arrays.sort(nums); // not necessary
//        backtrack(list, new ArrayList<>(), nums);
//        return list;
//    }
//
//    private static void backtrack( List<List<Integer>> list, List<Integer> tempList, int[] nums) {
//        if (tempList.size() == nums.length) {
//            list.add(new ArrayList<>(tempList));
//        } else {
//            for (int i = 0; i < nums.length; i++) {
//                // element already exists, skip
//                if (tempList.contains(nums[i]))
//                    continue;
//                tempList.add(nums[i]);
//                backtrack(list, tempList, nums);
//                tempList.remove(tempList.size() - 1);
//            }
//        }
//    }


    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), nums);
        System.out.println(resultList.size());

        return resultList;

    }

    public static void backtrack(List<List<Integer>> resultList, List<Integer> tmpList, int[] nums) {
        if (tmpList.size() == nums.length) {
            resultList.add(new ArrayList<>(tmpList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tmpList.contains(nums[i])) {
                    continue;
                }
                tmpList.add(nums[i]);
                backtrack(resultList, tmpList, nums);
                tmpList.remove(tmpList.size() - 1);

            }
        }
    }
}
