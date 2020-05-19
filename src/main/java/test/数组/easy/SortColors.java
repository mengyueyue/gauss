package test.数组.easy;

/**
 * Created by mengyue on 2020-05-19.
 */

import java.util.Arrays;

/**
 * Created by mengyue on 2020/5/19.
 */
public class SortColors {


    public static void main(String[] args) {

        int[] article = new int[]{2, 0, 2, 1, 1, 0, 2, 1, 0, 2, 1, 1, 2, 2, 0, 0, 1};

        /**
         *
         * 要求乱序的 0，1，2得到有序的0000111112222的结果
         * 不能用系统的排序函数
         *
         * 面试 牛客网题目
         */


        System.out.println(Arrays.toString(sortColors(article)));

    }

    //常数空间 两次遍历
    public static int[] sortColors(int[] nums) {
        if (nums.length < 1) {
            return nums;
        }

        int end = nums.length - 1;

        int start = 0;
        end = coreSwap(nums, start, end, 2);
        coreSwap(nums, start, end, 1);

        return nums;

    }

    private static int coreSwap(int[] nums, int start, int end, int compare_num) {

        while (start < end) {

            if (nums[start] == compare_num) {
                while (nums[end] == compare_num) {
                    end--;
                }

                swap(nums, start, end);
                end--;
            }
            start++;
        }

        return end;
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}


