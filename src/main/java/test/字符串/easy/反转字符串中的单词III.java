package test.字符串.easy;

import java.util.Arrays;

/**
 * Created by mengyue on 2018/8/16.
 */
public class 反转字符串中的单词III {

    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc"
     * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     *
     * @param args
     */
    public static void main(String[] args) {

        //String str = "Let's take LeetCode contest";
        String str = "LeetCode contest";
        System.out.println(reverseWords(str));
    }


    public static String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        String a = "";
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(reverseString(a) + " ");
                a = "";
            } else {
                a += c;
            }
        }
        return sb.toString() + reverseString(a);
    }

    public static String reverseString(String s) {
        char[] newChars = new char[s.length()];
        char[] chars = s.toCharArray();
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            newChars[j] = chars[i];
            j++;
        }
        return new String(newChars);
    }
}
