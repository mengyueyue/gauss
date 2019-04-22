package test.位运算.easy;

/**
 * Created by mengyue on 2019/2/14.
 */
public class 交替位二进制数 {


    public static void main(String[] args) {

    }


    /**
     * 判断交替的0和1
     *
     * @param n
     * @return
     */
//    public static boolean hasAlternatingBits(int n) {
//
//        int bit = -1;
//
//        while (n > 0) {
//
//            if ((n & 1) == 1) {
//
//                if (bit == 1) {
//                    return false;
//                }
//
//                bit = 1;
//
//            } else {
//
//                if (bit == 0) {
//                    return false;
//                }
//
//                bit = 0;
//            }
//
//            n >>= 1;
//        }
//
//        return true;
//    }

    /**
     * n不断的向右移 bit不断的通过异或来在0和1之前变换 直到n等于0的时候 返回true 否则false
     *
     * @param n
     * @return
     */
//    public static boolean hasAlternatingBits(int n) {
//        int bit = n & 1;
//
//        while ((n & 1) == bit) {
//            bit ^= 1;
//            n >>= 1;
//        }
//
//        return n == 0;
//
//    }


    /**
     * 101
     * 右移一位
     * 101 + 10 + 1
     * 二进制数相加等于
     * 1000
     * 与上
     * 101 + 10（也就是111）
     * <p>
     * return 1000 & 111 == 0
     *
     * @param n
     * @return
     */
//    public static boolean hasAlternatingBits(int n) {
//
//        return ((n + (n >> 1) + 1) & (n + (n >> 1))) == 0;
//
//    }


    /**
     * (n ^= (n >> 2)
     * 这样的结果是只剩最高位的1 然后赋值给n
     * 所以(n - 1) 等于都是1的二进制数
     *
     * @param n
     * @return
     */
    public static boolean hasAlternatingBits(int n) {

        // 这里的n被重新赋值了一次
        return ((n ^= (n >> 2)) & (n - 1)) == 0;

    }

}
