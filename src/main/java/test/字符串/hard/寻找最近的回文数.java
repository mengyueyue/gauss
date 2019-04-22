package test.字符串.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mengyue on 2019/3/26.
 * <p>https://www.happygirlzt.com/2018/12/05/564-find-the-closest-palindrome-solution-and-explanation/</p>
 * <p>http://www.cnblogs.com/grandyang/p/6915355.html</p>
 */
public class 寻找最近的回文数 {


    public static void main(String[] args) {


        System.out.println(nearestPalindromic("1"));
    }


    /**
     * 解题思路：
     * 1. 假设字符串的长度为N ,那么离他最近的回文数的一个candidates为 N+1 或 N-1(也就是99 或101 这样的结果)
     * 2. 另一种情况是：结果长度也为N, 也就是N的前半段 ,反转就是后半段 ,这又分为三种情况
     * (2.1) 中间数和原数据的中间数相同( 例如123的最近回文数就是121 )
     * (2.2) 中间数比原数据的中间数小1 ( 例如920的最近回文数就是919 )
     * (2.3) 中间数比原数据的中间数大1 ( 例如189的最近回文数就是191 )
     *
     * @param n
     * @return
     */
    public static String nearestPalindromic(String n) {
        long num = Long.valueOf(n), result = 0, min = Long.MAX_VALUE, length = n.length();
        Set<Long> candidate = new HashSet<>();
        candidate.add((long) Math.pow(10, length) + 1);
        candidate.add((long) Math.pow(10, length - 1) - 1);

        long leftNum = Long.parseLong(n.substring(0, (int) (length + 1) >> 1));

        for (int i = -1; i <= 1; i++) {
            String left = String.valueOf(leftNum + i);
            String str;
            //奇数
            if ((n.length() & 1) == 1) {
                str = left + new StringBuffer(left.substring(0, left.length() - 1)).reverse();
            } else {
                str = left + new StringBuffer(left).reverse().toString();
            }

            candidate.add(Long.valueOf(str));
        }

        candidate.remove(Long.valueOf(n));

        for (Long a : candidate) {
            long diff = Math.abs(Long.valueOf(n) - a);
            if (min > diff) {
                min = diff;
                result = a;
            } else if (diff == min) {
                result = Math.min(a, result);
            }
        }

        return Long.toString(result);
    }

}
