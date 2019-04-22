package test.easy;

import org.junit.Assert;

/**
 * Created by mengyue on 2018/7/25.
 *
 *
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 *
 */
public class 转换成小写字母 {

    public static void main(String[] args) {
        Assert.assertEquals(toLowerCase("HEllo"), "hello");
    }


    /**
     * 首先应该知道 a 和 A 转成int是多少
     *
     * @param str
     * @return
     */
    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        char[] newChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int j = (int) c;
            //在A 到 Z的范围内 ,原样返回
            if (isAZ(c)) {
                int value = (int) 'a' - (int) 'A' + j;
                c = (char) (value > 0 ? value : -value);
            }
            newChars[i] = c;
        }
        return String.valueOf(newChars);
    }

    public static boolean isAZ(char c) {
        return (int) 'A' - 1 < (int) c && (int) 'Z' + 1 > (int) c;
    }

}
