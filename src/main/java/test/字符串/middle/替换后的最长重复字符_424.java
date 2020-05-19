package test.字符串.middle;

/**
 * Created by mengyue on 2019-10-11.
 */
public class 替换后的最长重复字符_424 {

    /**
     * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
     * <p>
     * 注意:
     * 字符串长度 和 k 不会超过 104。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * s = "ABAB", k = 2
     * <p>
     * 输出:
     * 4
     * <p>
     * 解释:
     * 用两个'A'替换为两个'B',反之亦然。
     * 示例 2:
     * <p>
     * 输入:
     * s = "AABABBA", k = 1
     * <p>
     * 输出:
     * 4
     * <p>
     * 解释:
     * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
     * 子串 "BBBB" 有最长重复字母, 答案为 4。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 思路: 它也是滑动窗口，但它窗口的left和right是的移动条件是不相同的
     * <p>
     * 它这个提可以转化为 求窗口里出现最多的字符的个数+ k的值 然后算临时的最大值 然后再变动窗口（就像动态规划）再去看看有没有更大的值
     * <p>
     * 然后right指针变动的准则就是随着 for循环的遍历而移动
     * 然后left指针变动 是 判断 窗口的大小 - 最多字符的个数 > k的个数（就是变化k个 后的结果可能是还有可能这些字符没发连在一起 一定经历了等于k的情况）
     * 这种情况下 就需要移动left了 也就是缩小窗口的大小
     *
     *
     *
     *
     *
     *
     *
     * 可以说滑动窗口这种思想，关键点在于：
     * 1、map中存储值的意义
     * 2、窗口什么时候扩展和收缩，对应于left和right值什么时候发生变化。
     * 在解题的时候，首先尝试扩展窗口right，看看什么时候包含了一个结果，记录结果。然后缩小左边界left，直到窗口不在包含一个可能解！接着就可以继续扩展窗口了，以此类推。
     * ————————————————
     * 版权声明：本文为CSDN博主「自在时刻」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/yy254117440/article/details/53025142
     *
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {

    }


    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int l = 0, r = 0, res = 0;
        int[] dict = new int[256];
        int maxLen = 0;
        while (r < s.length()) {
            dict[s.charAt(r)]++;
            maxLen = Math.max(maxLen, dict[s.charAt(r)]);
            while ((r - l + 1 - maxLen) > k) {
                dict[s.charAt(l++)]--;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
