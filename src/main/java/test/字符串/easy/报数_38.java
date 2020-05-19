package test.字符串.easy;

/**
 * Created by mengyue on 2018/8/12.
 */
public class 报数_38 {


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


    /**
     *
     * 思路： 没看懂
     *
     *
     * 先设置上一人为'1'
     * 开始外循环
     * 每次外循环先置下一人为空字符串，置待处理的字符num为上一人的第一位，置记录出现的次数为1
     * 开始内循环，遍历上一人的数，如果数是和num一致，则count增加。
     * 若不一致，则将count和num一同添加到next_person报的数中，同时更新num和count
     * 别忘了更新next_person的最后两个数为上一个人最后一个字符以及其出现次数！
     *
     * 作者：jimmy00745
     * 链接：https://leetcode-cn.com/problems/count-and-say/solution/ji-su-jie-bu-di-gui-zhi-ji-lu-qian-hou-liang-ren-p/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
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
