package test.数学.easy;

/**
 * Created by mengyue on 2018/8/24.
 */
public class Two的幂 {


    public static void main(String[] args) {

        System.out.println(isPowerOfTwo(2));
    }

    /**
     * 2的幂次方  二进制 都只有一个1
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        int total = 0;
        while (n > 0) {
            total += (n & 1);
            n = n >> 1;
        }
        return total == 1;
    }
}
