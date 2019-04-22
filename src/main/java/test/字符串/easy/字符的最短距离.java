package test.字符串.easy;

import java.util.Arrays;

/**
 * Created by mengyue on 2018/8/29.
 */

//todo 复习一遍
public class 字符的最短距离 {

    /**
     * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
     * <p>
     * 示例 1:
     * <p>
     * 输入: S = "loveleetcode", C = 'e'
     * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
     * 说明:
     * <p>
     * 字符串 S 的长度范围为 [1, 10000]。
     * C 是一个单字符，且保证是字符串 S 里的字符。
     * S 和 C 中的所有字母均为小写字母。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
    }

    public static int[] shortestToChar(String s, char c) {
        int N = s.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (s.charAt(i) == c) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (s.charAt(i) == c) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }
}
