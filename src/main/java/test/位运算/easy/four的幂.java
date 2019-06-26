package test.位运算.easy;

/**
 * Created by mengyue on 2019-05-21.
 */
public class four的幂 {


    public static void main(String[] args) {

        System.out.println(12 & (12 - 1));

        System.out.println(isPowerOfFour(5));
    }


    public static boolean isPowerOfFour(int num) {


        /**
         *
         * 如果是2的次方的话, 那么num & (num - 1) 的结果应该是 0 否则其他数不是0
         *
         *
         */
        // 确定是否是2的倍数
        if (num < 0 || (num & (num - 1)) != 0) {//check(is or not) a power of 2.
            return false;
        }

        // 因为4的倍数 1肯定是在奇数位的 所以 这个0x55555555 其实是1010101010101010101010101010101
        // 也就是 奇数部分都是1 这样他们 & 一下 之后的结果 应该不等于 0 就是4的倍数

        return (num & 0x55555555) != 0;//check 1 on odd bits
    }
}
