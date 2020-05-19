package test.字符串.middle;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengyue on 2019-10-09.
 */
public class 无重复字符的最长子串_3 {


    /**
     *
     *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     *
     * @param args
     */


    /**
     * 思路：滑动窗口（其实也就是 双指针）
     *
     * start指针是滑动窗口的开始
     * end指针是滑动窗口的结束
     *
     * map里会存每个字符以及这个字符最后出现的的index+1 , map的key用来判断是否遇到了重复的字符,而value存这个字符最新出现的index+1
     *
     * start = Math.max(map.get(alpha), start);
     * 如果遍历的字符一直没有重复的话 start的位置是一直不变的，直到遇到重复的字符，然后用重复的字符的位置代替掉start的值
     *
     * ans = Math.max(ans, end - start + 1);
     * 当然在遍历的过程中 会一直计算不重复字符的最大长度，这个过程其实是个动态的过程 有点想DP(动态规划)
     *
     * map.put(s.charAt(end), end + 1);
     * 然后再用这个字符的最新index+1维护到map里
     * (
     * 维护的作用 就是说这个出现过的字符 和 这个字符上一次出现的位置 他们之间的字符我们都有查找过, 在接下来的情况下就不需要继续去查找了，所以
     * 我们将滑动窗口的start设置成了这个字符上一次出现的位置（当然这个位置我们认为是开区间的 不包括当然这个字符）（或者说这个字符上一次出现的位置的闭区间）
     *)
     *
     * @param args
     */
    public static void main(String[] args) {


    }


    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;


    }
}
