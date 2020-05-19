package test.回溯算法.middle;

import java.util.*;

/**
 * Created by mengyue on 2018/8/12.
 */
public class 组合总和 {


    public static void main(String[] args) {

        //int[] candidates = new int[]{2, 6, 4};
        //int target = 8;
        //int[] candidates = new int[]{7, 6, 6, 3, 9, 3, 5, 1};
        //int[] candidates = new int[]{7, 6, 6, 3, 9, 3, 5, 5, 7, 1};
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(Arrays.toString(combinationSum(candidates, target).toArray()));
    }


//    public static List<List<Integer>> combinationSum(int[] nums, int target) {
//        List<List<Integer>> list = new ArrayList<>();
//        Set<Integer> present = new HashSet<>();
//        Arrays.sort(nums);
//        backtrack(list, present, new ArrayList<>(), nums, target, 0);
//        return list;
//    }
//
//    private static void backtrack(List<List<Integer>> list, Set<Integer> present, List<Integer> tempList, int[] nums, int remain, int start) {
//        if (remain == 0) {
//            list.add(new ArrayList<>(tempList));
//            if (!present.contains(tempList.get(0))) {
//                list.add(new ArrayList<>(tempList));
//            }
//            present.add(tempList.get(0));
//        } else {
//            for (int i = start; i < nums.length; i++) {
//                //起到去重作用
//                if (i > start && nums[i] == nums[i - 1]) {
//                    continue;
//                }
//                if (tempList.size() < 2) {
//                    tempList.add(nums[i]);
//                } else {
//                    continue;
//                }
//                tempList.add(nums[i]);
//                backtrack(list, present, tempList, nums, remain - nums[i], i + 1);
//                tempList.remove(tempList.size() - 1);
//            }
//        }
//    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res, temp, target, candidates, 0);
        return res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> temp, int target, int[] candidates, int j) {
        //满足条件，将中间集加入结果集
        if (target == 0) {
            res.add(new ArrayList<>(temp));
        }
        //target>=candidates[i]是剪枝操作
        for (int i = j; i < candidates.length && target >= candidates[i]; i++) {
            temp.add(candidates[i]);
            /**
             *
             * 这个操作是查找不重复的组合
             * dfs(res, temp, target - candidates[i], Arrays.copyOfRange(candidates, i + 1, candidates.length), i);
             */
            /**
             *
             * 这个操作是可以有重复的组合
             * dfs(res, temp, target - candidates[i], candidates, i);
             */
            //dfs(res, temp, target - candidates[i], Arrays.copyOfRange(candidates, i + 1, candidates.length), i);
            dfs(res, temp, target - candidates[i], candidates, i);
            /**
             *
             * 这里的remove 在每次找到组合的时候 要执行两次 为什么呢 因为只有最有两个的和才大于下一个的和啊
             *
             * eg[2,3]
             *
             * 当我找到[2,2,2,2]的时候 需要去掉最后两个2，否则去掉一个的话加上3明显是大于target的，算无效的操作
             */
            temp.remove(temp.size() - 1);
        }
    }
}
