package test.字符串.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengyue on 2019-10-09.
 */
public class 最小覆盖子串_76 {

    /**
     *
     *
     * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
     *
     * 示例：
     *
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     * 说明：
     *
     * 如果 S 中不存这样的子串，则返回空字符串 ""。
     * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-window-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    /**
     *
     *
     * 思路：滑动窗口
     *
     * 先找到符合的子串 (其实就是right的不断移动 也就是代码里的最外层的while的循环)
     * 然后缩小范围，在这个子串中寻找最小的符合条件的串(其实就是left的不断移动 也即是代码里层的while的循环)
     *
     *
     * 我们通过移动right指针不断扩张窗口。当窗口包含全部所需的字符后，如果能收缩，我们就收缩窗口直到得到最小窗口。
     *
     *
     */
}


class StateMgr {

    private int found; // 总共需要的状态数
    private int counter; // 当前已有的状态数

    private Map<Character, Integer> sMap;
    private Map<Character, Integer> tMap;

    private String t;

    StateMgr(String t) {
        this.sMap = new HashMap<>();
        this.tMap = new HashMap<>();
        this.t = t;
        this.counter = 0;
    }

    void init() {
        char[] chars = t.toCharArray();
        for (char ch : chars) {
            Integer count = tMap.get(ch);
            if (count == null) {
                count = 0;
            }
            tMap.put(ch, count + 1);
        }
        this.found = tMap.size();
    }

    void inc(Character ch) {
        if (!tMap.containsKey(ch)) return;
        Integer count = sMap.get(ch);
        if (count == null) count = 0;
        sMap.put(ch, count + 1);
        int tc = tMap.get(ch);
        boolean findOne = count < tc && count + 1 >= tc;
        if (findOne) counter++;
    }

    void dec(Character ch) {
        if (!tMap.containsKey(ch)) return;
        Integer count = sMap.get(ch);
        if (count == null) return;
        sMap.put(ch, count - 1);
        int tc = tMap.get(ch);
        boolean findOne = count >= tc && count - 1 < tc;
        if (findOne) counter--;
    }

    boolean find() {
        return counter == found;
    }

}

class Solution {

    public String minWindow(String s, String t) {

        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        StateMgr mgr = new StateMgr(t);
        mgr.init();
        int start = 0, end = 0, len = s.length();
        char[] src = s.toCharArray();
        String res = "";
        int minLen = Integer.MAX_VALUE;
        while (end < len) {
            mgr.inc(src[end]);
            end++;
            while (mgr.find()) {
                if (end - start < minLen) {
                    minLen = end - start;
                    res = s.substring(start, end);
                }
                mgr.dec(src[start]);
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}
