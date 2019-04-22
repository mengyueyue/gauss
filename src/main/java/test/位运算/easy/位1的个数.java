package test.位运算.easy;

/**
 * Created by mengyue on 2018/8/24.
 */
public class 位1的个数 {


    /**
     * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     * <p>
     * 示例 :
     * <p>
     * 输入: 11
     * 输出: 3
     * 解释: 整数 11 的二进制表示为 00000000000000000000000000001011
     * <p>
     * <p>
     * 示例 2:
     * <p>
     * 输入: 128
     * 输出: 1
     * 解释: 整数 128 的二进制表示为 00000000000000000000000010000000
     *
     * @param args
     */
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        System.out.println(hammingWeight(a));
        System.out.println(hammingWeight1(a));
    }



    /**
     * >>> 是无符号右移 高位补0
     * >> 是有符号右移 高位补符号位
     *
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            ones = ones + (n & 1);
            n = n >>> 1;
        }
        return ones;
    }


    public static int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

}
