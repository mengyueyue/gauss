package test.数组.easy;

import java.util.Arrays;

/**
 * Created by mengyue on 2018/8/20.
 */
public class 移除元素 {


    public static void main(String[] args) {

        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int result = removeElement(nums, 2);
        System.out.println(result);
        //[0 , 1 , 3 , 0 , 4]
        System.out.println(Arrays.toString(nums));
    }



    public static int removeElement(int[] nums, int val) {
        int index = 0;
//        for (int num : nums) {
//            if (num != val) {
//                nums[index] = num;
//                index++;
//            }
//        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != val) {
                nums[index] = num;
                index++;
            }
        }
        return index;
    }

}
