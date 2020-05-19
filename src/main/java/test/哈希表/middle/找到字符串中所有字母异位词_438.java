package test.哈希表.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengyue on 2019-10-12.
 */
public class 找到字符串中所有字母异位词_438 {

    /*

    给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

    字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

    说明：

    字母异位词指字母相同，但排列不同的字符串。
    不考虑答案输出的顺序。
    示例 1:

    输入:
    s: "cbaebabacd" p: "abc"

    输出:
    [0, 6]

    解释:
    起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
    起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     示例 2:

    输入:
    s: "abab" p: "ab"

    输出:
    [0, 1, 2]

    解释:
    起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
    起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
    起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     */
    public static void main(String[] args) {

        /**
         *
         * String s = "abbc";
         *
         * String p = "baac";
         *
         *
         * 这种情况下 判断也是没有问题的
         *
         *
         * 因为他在减掉map里的记录后 在left 指针的移动后 又会加回来 （这个字符在map里的话 就会加回来 不在的话 当初也没有减掉过 也就没有比较加回来了）
         *
         */

        String s = "abbc";

        String p = "bbac";


        System.out.println(findAnagrams(s, p));

    }


    public static List<Integer> findAnagrams(String s, String p) {


        ArrayList<Integer> result = new ArrayList<>();
        if (s == null || p == null) return result;
        int left = 0, right = 0, count = p.length();
        int[] map = new int[256];
        char[] sc = s.toCharArray();
        for (char c : p.toCharArray()) map[c]++;
        while (right < s.length()) {

            if (map[sc[right++]]-- >= 1) count--;
            if (count == 0) result.add(left);
            if (right - left == p.length() && map[sc[left++]]++ >= 0) count++;
        }
        return result;
    }


}
