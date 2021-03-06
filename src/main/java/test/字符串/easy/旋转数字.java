package test.字符串.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengyue on 2018/8/16.
 */
public class 旋转数字 {


    /**
     *

     我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。

     如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。

     0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。

     现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？

     示例:
     输入: 10
     输出: 4
     解释:
     在[1, 10]中有四个好数： 2, 5, 6, 9。
     注意 1 和 10 不是好数, 因为他们在旋转之后不变。
     注意:

     N 的取值范围是 [1, 10000]

     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(rotatedDigits(10));
    }


    public static int rotatedDigits(int N) {

        Map<String, String> map = new HashMap<String, String>(16) {{
            put("0", "0");
            put("1", "1");
            put("2", "5");
            put("5", "2");
            put("8", "8");
            put("6", "9");
            put("9", "6");
        }};
        int num = 0;
        for (int i = 1; i <= N; i++) {
            StringBuffer sb = new StringBuffer();
            char[] chars = String.valueOf(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (map.containsKey(String.valueOf(chars[j]))) {
                    sb.append(map.get(String.valueOf(chars[j])));
                } else {
                    chars = new char[]{};
                    break;
                }
            }
            String result = new String(chars);
            if (!sb.toString().equals(result) && !result.equals("")) {
                num++;
            }
        }
        return num;
    }
}
