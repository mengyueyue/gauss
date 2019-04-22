package test.字符串.easy;

/**
 * Created by mengyue on 2018/8/16.
 */
public class 检测大写字母 {

    /**
     *
     *
     * 给定一个单词，你需要判断单词的大写使用是否正确。

     我们定义，在以下情况时，单词的大写用法是正确的：

     全部字母都是大写，比如"USA"。
     单词中所有字母都不是大写，比如"leetcode"。
     如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
     否则，我们定义这个单词没有正确使用大写字母。

     示例 1:

     输入: "USA"
     输出: True
     示例 2:

     输入: "FlaG"
     输出: False
     *
     * @param args
     */
    public static void main(String[] args) {

        String s = "Leetcode";
        System.out.println(detectCapitalUse(s));

    }

    public static boolean detectCapitalUse(String word) {
        int num = 0;
        int first = 0;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('A' <= chars[i] && 'Z' >= chars[i]) {
                if (i == 0) {
                    first++;
                }
                num++;
            }
        }
        return (num == 0 && first == 0) || num == chars.length || (num == 1 && first == 1);
    }
}
