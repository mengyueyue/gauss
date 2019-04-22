package test.数组.easy;

import java.util.Arrays;

/**
 * Created by mengyue on 2018/9/15.
 */
public class 旋转数组 {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int k = 2;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

//    public static void rotate(int[] nums, int k) {
//        if (nums.length == 0 || (k %= nums.length) == 0) return;
//        int n = nums.length, start = 0, i = 0, cur = nums[i], cnt = 0;
//        while (cnt++ < n) {
//            i = (i + k) % n;
//            int t = nums[i];
//            nums[i] = cur;
//            if (i == start) {
//                ++start;
//                ++i;
//                cur = nums[i];
//            } else {
//                cur = t;
//            }
//        }
//    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        int start = 0;
        int i = 0;
        int cur = nums[i];
        while (cnt++ < n) {
            i = (i + k) % n;
            int tmp = nums[i];
            nums[i] = cur;
            if (i != start) {
                cur = tmp;
            } else {
                ++i;
                ++start;
                cur = nums[i];
            }
        }
    }


}
