package test.easy;

/**
 * Created by mengyue on 2018/7/25.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * 示例:
 * <p>
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1    (0 0 0 1)
 * 4    (0 1 0 0)
 * ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class 汉明距离 {

    public static void main(String[] args) {

        System.out.println(other1(13, 7));
        System.out.println(other2(13, 7));
        System.out.println(self(13, 7));

    }


    /**
     * 这个应该是最快的
     *
     * @param x
     * @param y
     * @return
     */
    public static int other1(int x, int y) {
        int res = 0;
        int temp = x ^ y;
        while (temp != 0) {
            res++;
            //下面这一步不明白
            temp &= (temp - 1);
        }
        return res;
    }

    /**
     * 这个应该是想法最好的
     *
     * @param x
     * @param y
     * @return
     */
    public static int other2(int x, int y) {
        int i = 0;
        for (int j = 0; j < 32; j++) {
            if ((x & 0x00000001) != (y & 0x00000001)) i++;
            x = x >> 1;
            y = y >> 1;
        }
        return i;
    }


    /**
     * 自己写的最垃圾了
     *
     * @param x
     * @param y
     * @return
     */
    public static int self(int x, int y) {

        int total = 0;
        String xStr = ten2two(x);
        String yStr = ten2two(y);
        int diffLength = xStr.length() - yStr.length();
        diffLength = diffLength > 0 ? diffLength : -diffLength;
        StringBuffer zero = new StringBuffer();
        for (int i = 0; i < diffLength; i++) {
            zero.append("0");
        }
        if (xStr.length() > yStr.length()) {
            yStr = yStr + zero.toString();
        } else {
            xStr = xStr + zero.toString();
        }
        char[] xchar = xStr.toCharArray();
        char[] ychar = yStr.toCharArray();
        for (int i = xStr.length() - 1; i >= 0; i--) {
            total += xchar[i] ^ ychar[i];
        }

        return total;
    }

    public static String ten2two(int x) {
        StringBuffer sb = new StringBuffer();
        while (x != 0) {
            int tmp = x % 2;
            x = x / 2;
            sb.append(tmp);
        }
        return sb.toString();
    }

}
