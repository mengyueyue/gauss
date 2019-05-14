package test.数组.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mengyue on 2018/9/15.
 */
public class 存在重复元素 {
    public static void main(String[] args) {


        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    /**
     * 方法一：额外空间 O(n) 时间O(n)
     * <p>
     * 方法二：额外时间排序 O(nlogn) 常数空间O(1)
     *
     * @param nums
     * @return
     */




    //hash表的方式
//    public static boolean containsDuplicate(int[] nums) {
//
//        Set<Integer> set = new HashSet<>();
//
//        for (int num : nums) {
//            set.add(num);
//        }
//
//        return nums.length == set.size();
//    }


    public static boolean containsDuplicate(int[] nums) {


        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] == nums[i + 1]){
                return true;
            }
        }

        return false;
    }


}
