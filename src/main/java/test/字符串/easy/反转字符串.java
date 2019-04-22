package test.字符串.easy;


import java.util.Arrays;

/**
 * Created by mengyue on 2018/8/16.
 */
public class 反转字符串 {


    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "hello"
     * 输出: "olleh"
     * 示例 2:
     * <p>
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: "amanaP :lanac a ,nalp a ,nam A"
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(reverseString("hello"));
        System.out.println(new String(reverseString("hello".toCharArray())));
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


    public static char[] reverseString(char[] c) {
        if (c == null || c.length == 1) {
            return c;
        }
        for (int i = 0; i < (c.length - 1) / 2; i++) {
            char c1 = c[i];
            char c2 = c[c.length - 1 - i];
            c[i] = c2;
            c[c.length - 1 - i] = c1;
        }
        return c;
    }
}
