package test.数组.middle;

/**
 * Created by mengyue on 2018/9/18.
 */
//todo review
public class 只出现一次的数字II {

    public static void main(String[] args) {
        int[] a = new int[]{2, 2, 2, 3};
        System.out.println(singleNumber(a));


        System.out.println(10 & -10);
    }

//    public static int singleNumber(int[] A) {
//        int ones = 0, twos = 0;
//        for (int i = 0; i < A.length; i++) {
//            ones = (ones ^ A[i]) & ~twos;
//            twos = (twos ^ A[i]) & ~ones;
//        }
//        return ones;
//    }

    public static int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            a = (a ^ nums[i]) & ~b;
            b = (b ^ nums[i]) & ~a;
        }
        return b;
    }
}
