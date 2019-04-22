package test.字符串.easy;

/**
 * Created by mengyue on 2018/8/12.
 */
public class 报数 {


    /**
     * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     * <p>
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     * <p>
     * 给定一个正整数 n ，输出报数序列的第 n 项。
     * <p>
     * 注意：整数顺序将表示为一个字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1
     * 输出: "1"
     * 示例 2:
     * <p>
     * 输入: 4
     * 输出: "1211"
     *
     * @param args
     */

    public static void main(String[] args) {

        System.out.println(countAndSay(3));

    }


//    public static String countAndSay(int n) {
//        StringBuilder curr = new StringBuilder("1");
//        StringBuilder prev;
//        for (int i = 1; i < n; i++) {
//            prev = curr;
//            curr = new StringBuilder();
//            int count = 1;
//            char say = prev.charAt(0);
//            for (int j = 1, len = prev.length(); j < len; j++) {
//                if (prev.charAt(j) != say) {
//                    curr.append(count).append(say);
//                    count = 1;
//                    say = prev.charAt(j);
//                } else count++;
//            }
//            curr.append(count).append(say);
//        }
//        return curr.toString();
//    }

    //自已也蛮厉害的
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String result = "1";
        char pre = ' ';
        int count = 0;
        for (int i = 1; i < n; i++) {
            char[] chars = String.valueOf(result).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (' ' == pre) {
                    count++;
                    pre = chars[j];
                    result = "";
                } else if (pre == chars[j]) {
                    count++;
                } else {
                    result += String.valueOf(count) + pre;
                    pre = chars[j];
                    count = 1;
                }
            }
            result += String.valueOf(count) + pre;
            pre = ' ';
            count = 0;
        }
        return result;
    }

}
