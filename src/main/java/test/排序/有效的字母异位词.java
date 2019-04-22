package test.排序;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengyue on 2018/10/25.
 */
public class 有效的字母异位词 {


    public static boolean isAnagram(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.computeIfPresent(c, (k, v) -> v+1);
            map.putIfAbsent(c, 1);
        }

        char[] tChats = t.toCharArray();
        for (char c : tChats) {
            if (map.containsKey(c)) {
                map.computeIfPresent(c, (k, v) -> --v == 0 ? null : v);
            } else {
                return false;
            }
        }

        return map.size() <= 0;

    }
}
