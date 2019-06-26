package test.字符串.easy;

import java.util.*;

/**
 * Created by mengyue on 2019-05-16.
 */
public class 查找和替换模式 {


    public static void main(String[] args) {


        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        List<String> list = findAndReplacePattern(words, "abb");

        System.out.println(list.toString());
    }


    public static List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList<>();


        for (String word : words) {

            if (match(word, pattern)) result.add(word);

        }

        return result;
    }


    public static boolean match(String word, String pattern) {


        /**
         *
         *
         * 这里的情况只能判断出 【word 为 agg  pattern 为 nhh 的情况 】
         *
         */
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {

            if (!map.containsKey(word.charAt(i))) {
                map.put(word.charAt(i), pattern.charAt(i));
            } else {
                if (map.get(word.charAt(i)) != pattern.charAt(i)) {
                    return false;
                }
            }
        }

        boolean[] array = new boolean[26];

        /**
         *
         * 下面的代码 逻辑 其实是在判断 当pattern 为 abc 这样一个都不重复 而word 可能为 egg 这样有重复值的存在的情况
         *
         * 因为上面的map 逻辑 并不能 判断出 【 pattern 为 abc 而word 可能为 egg】 的情况
         *
         */
        for (Character value : map.values()) {

            if (array[value - 'a']) {
                return false;
            } else {
                array[value - 'a'] = true;
            }
        }

        return true;

    }
}
