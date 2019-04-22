package 动态规划.easy;

/**
 * Created by mengyue on 2018/7/29.
 */
public class 区域和检索数组不可变 {

    public static void main(String[] args) {
        int[] array = {-2, 0, 3, -5, 2, -1};
        System.out.println(new NumArray(array).sumRange(2, 5));

    }


    //
    static class NumArray {
//
//
        /**
         * 自己的是函数变成的递归思想
         */
        private int[] nums;

        private int diff;

        private int sum;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            if (diff == 1) {
                sum += nums[j];
            } else {
                sum += nums[i];
                diff = j - i;
                sumRange(i + 1, j);
            }
            return sum;
        }

        /**
         * 思想是将原来的数组内容变成, {0,0+1,0+1+2,0+1+2+3} 这里面表示下标的和
         * 然后sumRange的 i和j 表示数的范围, 让后将 j - (i-1) 就表示 i到j的范围的数之和
         */

//    int nums[];
//
//    public NumArray(int[] nums) {
//        this.nums = nums;
//        for (int i = 1; i < nums.length; i++) {
//            nums[i] += nums[i - 1];
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        if (i == 0) {
//            return nums[j];
//        } else {
//            return nums[j] - nums[i - 1];
//        }
//    }


        /**
         * scala 自己的写的版本
         */

//    class NumArray(_nums: Array[Int]) {
//
//        private var diff, sum: Int = _
//
//        def sumRange(i: Int, j: Int): Int = {
//                diff match {
//        case 1 =>
//            sum += _nums(j)
//        case _ =>
//            sum += _nums(i)
//            diff = j - i
//            sumRange(i + 1, j)
//    }
//            sum
//  }
//    }

    }


}