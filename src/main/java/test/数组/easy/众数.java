package test.数组.easy;

/**
 * Created by mengyue on 2018/8/19.
 */
public class 众数 {


    /**
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     *
     * @param args
     */
    public static void main(String[] args) {


        int[] num = new int[]{2, 3, 325, 123, 234, 1, 124, 5, 1, 1, 1};
        System.out.println(majorityElement(num));


    }

    /**
     * 让他们相互的消除 最后剩下的一定是那个众数
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {

        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == major) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    major = nums[i];
                    count = 1;
                }
            }
        }
        return major;

    }

    /**
     * 思想：因为是找大于n/2的数 ，所以这个数减去其他所有数的和 也是大于0的
     *
     * @param num
     * @return
     */

//    public static int majorityElement(int[] num) {
//
//        int major = num[0], count = 1;
//        for (int i = 1; i < num.length; i++) {
//            if (count == 0) {
//                count++;
//                major = num[i];
//            } else if (major == num[i]) {
//                count++;
//            } else count--;
//
//        }
//        return major;
//    }
}
