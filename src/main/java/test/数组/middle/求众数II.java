//package test.数组.middle;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Created by mengyue on 2018/8/30.
// */
//public class 求众数II {
//
//    public static void main(String[] args) {
//
//        int[] nums = new int[]{1, 1, 1, 3, 3, 2, 2, 2};
//        System.out.println(Arrays.toString(majorityElement(nums).toArray()));
//    }
//
//    public static List<Integer> majorityElement(int[] nums) {
//        if (nums == null || nums.length == 0)
//            return new ArrayList<>();
//        List<Integer> result = new ArrayList<>();
//        int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
//        for (int i = 0; i < len; i++) {
//            if (nums[i] == number1)
//                count1++;
//            else if (nums[i] == number2)
//                count2++;
//            else if (count1 == 0) {
//                number1 = nums[i];
//                count1 = 1;
//            } else if (count2 == 0) {
//                number2 = nums[i];
//                count2 = 1;
//            } else {
//                count1--;
//                count2--;
//            }
//        }
//        count1 = 0;
//        count2 = 0;
//        for (int i = 0; i < len; i++) {
//            if (nums[i] == number1)
//                count1++;
//            else if (nums[i] == number2)
//                count2++;
//        }
//        if (count1 > len / 3)
//            result.add(number1);
//        if (count2 > len / 3)
//            result.add(number2);
//        return result;
//    }
//}
