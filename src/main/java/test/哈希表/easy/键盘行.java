package test.哈希表.easy;

import java.util.*;

/**
 * Created by mengyue on 2018/8/29.
 */
public class 键盘行 {

    /**
     * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
     * <p>
     * 示例1:
     * <p>
     * 输入: ["Hello", "Alaska", "Dad", "Peace"]
     * 输出: ["Alaska", "Dad"]
     * 注意:
     * <p>
     * 你可以重复使用键盘上同一字符。
     * 你可以假设输入的字符串将只包含字母。
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(findWords(words)));
    }


    static Set<String> set1 = new HashSet<String>() {
        {
            add("Q");
            add("P");
            add("W");
            add("E");
            add("R");
            add("T");
            add("Y");
            add("U");
            add("I");
            add("O");
        }
    };
    static Set<String> set2 = new HashSet<String>() {
        {
            add("A");
            add("S");
            add("D");
            add("F");
            add("G");
            add("H");
            add("J");
            add("K");
            add("L");
        }
    };
    static Set<String> set3 = new HashSet<String>() {
        {
            add("Z");
            add("X");
            add("C");
            add("V");
            add("B");
            add("N");
            add("M");
        }
    };

    public static String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            int first = 0, second = 0, three = 0;
            for (char c : word.toCharArray()) {
                String s = uppercase(c);
                if (set1.contains(s)) first = 1;
                if (set2.contains(s)) second = 1;
                if (set3.contains(s)) three = 1;
                if (first + second + three > 1) break;
            }
            if (first + second + three == 1) {
                list.add(word);
            }
        }
        return list2Array(list);
    }

    public static String uppercase(char c) {
        if ('A' <= c && 'Z' >= c) {
            return String.valueOf(c);
        }
        return String.valueOf((char) ('A' - 'a' + c));
    }

    public static String[] list2Array(List<String> list) {
        String[] array = new String[list.size()];
        return list.toArray(array);
    }
}
