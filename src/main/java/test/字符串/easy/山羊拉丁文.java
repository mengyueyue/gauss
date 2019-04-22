package test.字符串.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mengyue on 2018/9/18.
 */
public class 山羊拉丁文 {


    public static void main(String[] args) {
        String s = "";
        System.out.println(toGoatLatin(s));
    }

    private static Set<Character> set;

    static {
        set = new HashSet<Character>() {{
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
    }

    public static String toGoatLatin(String S) {
        StringBuffer sb = new StringBuffer();
        String[] array = S.split("\\s");
        for (int i = 0; i < array.length; i++) {
            sb.append(toGoat(array[i]) + getMa(i));
            if (i != array.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String toGoat(String s) {
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        if (set.contains(chars[0])) {
            return s;
        }
        for (int i = 1; i < s.length(); i++) {
            sb.append(chars[i]);
        }
        sb.append(chars[0]);
        return sb.toString();
    }

    public static String getMa(int i) {
        StringBuffer sb = new StringBuffer("ma");
        for (int j = 0; j < i + 1; j++) {
            sb.append("a");
        }
        return sb.toString();
    }
}
