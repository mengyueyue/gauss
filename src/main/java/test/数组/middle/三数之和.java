package test.数组.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mengyue on 2018/8/31.
 */
public class 三数之和 {


    public static void main(String[] args) {

    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        List<Integer> subList = new ArrayList<>();
//                        subList.add(nums[i]);
//                        subList.add(nums[j]);
//                        subList.add(nums[k]);
//                        list.add(subList);
//                    }
//                }
//            }
//        }
//        return list;
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) return lists;
        /**
         *
         *
         */
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //i之后的数 大于0的话 ,就不可能有 a + b + c = 0 的情况了
            if (nums[i] > 0) break;
            //前后两个数 相同的话 算重复的情况 直接跳过 , 当然除了 [-1,-1,2]的情况
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //从i+1开始 一直往后遍历
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                //算连续的三个数 是否等于0
                if (nums[i] + nums[l] + nums[r] == 0) {
                    //如果相等的话 就加到res里
                    lists.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //l位置如果有相同的情况  这样算是 重复的 所以 直接跳过就好 当然 在l 不大于r的情况下
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    //r位置如果有相同的情况  这样算是 重复的 所以 直接跳过就好 当然 在r 不小于l的情况下
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    /**
                     *  上一步 如果有 nums[l] == nums[l + 1]) 的情况 l++ 只是从l到了l+1的位置
                     *  然后下面的l++ 从l+1到l+2的位置 也就是跳过了 这两个相同位置的数
                     *
                     *  然后正常情况吗下 nums[l] != nums[l + 1] 的情况 下 人家是要正常的++的 以及 --
                     *
                     */

                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    //当三个数 相加都小于零的情况下 要增加nums[l]的值, 因为l是里层的遍历
                    l++;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    //当三个数 相加都大于零的情况下 要增加nums[r]的值, 因为r是里层的遍历
                    r--;
                }
            }
        }
        return lists;
    }

}
