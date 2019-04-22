package test.数组.easy;

/**
 * Created by mengyue on 2018/9/18.
 */
public class 只出现一次的数字 {


    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int rst = 0;
        for (int num : nums) {
            rst ^= num;
        }
        return rst;
    }
}
