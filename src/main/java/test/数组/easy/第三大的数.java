package test.数组.easy;

/**
 * Created by mengyue on 2018/9/16.
 */
public class 第三大的数 {


    public static void main(String[] args) {

        int[] nums = new int[]{1,2};
        System.out.println(thirdMax(nums));
    }


    public static int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, three = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > first) {
                three = second;
                second = first;
                first = num;
            }
            if (num > second && num < first) {
                three = second;
                second = num;
            }
            if (second > num && num > three) {
                three = num;
            }
        }
        return (second == three || three == Long.MIN_VALUE) ? (int)first : (int)three;
    }
}
