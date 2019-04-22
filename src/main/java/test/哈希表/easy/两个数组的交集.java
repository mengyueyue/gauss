package test.哈希表.easy;

import java.util.*;

/**
 * Created by mengyue on 2018/8/28.
 */

//todo 在复习一遍
public class 两个数组的交集 {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2]
     * 示例 2:
     * <p>
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [9,4]
     * 说明:
     * <p>
     * 输出结果中的每个元素一定是唯一的。
     * 我们可以不考虑输出结果的顺序。
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                set1.add(nums2[i]);
            }
        }
        int index = 0;
        int[] array = new int[set1.size()];
        for (Integer integer : set1) {
            array[index] = integer;
            index++;
        }
        return array;
    }


}
