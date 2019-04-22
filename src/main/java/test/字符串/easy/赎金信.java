package test.字符串.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengyue on 2018/10/13.
 */
public class 赎金信 {


    public static void main(String[] args) {

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] note = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : note) {
            Object o = map.containsKey(c) ? map.put(c, map.get(c) + 1) : map.put(c, 1) ;
        }
        for (char c : mag) {
            if (map.containsKey(c)) {
                int m = map.get(c) - 1;
                if (m == 0) {
                    map.remove(c);
                } else {
                    map.put(c, m);
                }
            }
        }
        return map.size() == 0;
    }
}
