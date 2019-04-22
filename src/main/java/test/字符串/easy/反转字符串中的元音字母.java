package test.字符串.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mengyue on 2018/9/18.
 */
public class 反转字符串中的元音字母 {


    public static void main(String[] args) {

        String s = "leetcode";
        reverseVowels(s);
    }

    private static Set<Character> set = new HashSet<Character>() {{
        add('u');
        add('a');
        add('i');
        add('e');
        add('o');
        add('U');
        add('A');
        add('I');
        add('E');
        add('O');
    }};

    public static String reverseVowels(String s) {
        StringBuffer secondound = new StringBuffer();
        StringBuffer vowel = new StringBuffer();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {

        }
        return "";
    }
}
