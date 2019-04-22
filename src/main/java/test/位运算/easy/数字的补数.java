package test.位运算.easy;

/**
 * Created by mengyue on 2018/8/29.
 */
public class 数字的补数 {

    /**
     * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
     * <p>
     * 注意:
     * <p>
     * 给定的整数保证在32位带符号整数的范围内。
     * 你可以假定二进制数不包含前导零位。
     * 示例 1:
     * <p>
     * 输入: 5
     * 输出: 2
     * 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
     * 示例 2:
     * <p>
     * 输入: 1
     * 输出: 0
     * 解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
     *
     * @param args
     */
    public static void main(String[] args) {
        int num = 5;
        System.out.println(5 ^ 3);
        //System.out.println(findComplement(num));
    }


    /**
     * 5 ^ 7 = 2
     * 101 ^ 111 = 010
     * <p>
     * <p>
     * 其实原理很简单就是 没有前导0的二进制和位数相同的都是1的二进制 ^ 一下就行
     * 然后重点就来到了 找到底是多少为的1这件事情上
     *
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        for (int i = 31; i >= 0; i--) {
            //从左边开始找不为0的那一位的index
            if (((1 << i) & num) != 0) {
                return num ^ ((1 << i + 1) - 1);
            }
        }
        return 0;
    }


}
