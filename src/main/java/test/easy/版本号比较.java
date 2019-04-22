package test.easy;

/**
 * Created by mengyue on 2018/8/3.
 */
public class 版本号比较 {

    /**
     *
     *
     *
     *
     *
     *
     比较两个版本号 version1 和 version2。

     如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。

     你可以假设版本字符串非空，并且只包含数字和 . 字符。

     . 字符不代表小数点，而是用于分隔数字序列。

     例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。

     示例 1:

     输入: version1 = "0.1", version2 = "1.1"
     输出: -1
     示例 2:

     输入: version1 = "1.0.1", version2 = "1"
     输出: 1
     示例 3:

     输入: version1 = "7.5.2.4", version2 = "7.5.3"
     输出: -1
     *
     *
     *
     *
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(compareVersion("1.16", "1.2"));
    }

    /**
     * v1 > v2 result 1
     * v1 = v2 result 0
     * v1 < v2 result -1
     *
     * @param v1
     * @param v2
     * @return
     */
    public static int compareVersion(String v1, String v2) {
        if (v1.equals(v2)) {
            return 0;
        }
        String[] c1 = v1.contains(".") ? v1.split("\\.") : new String[]{v1};
        String[] c2 = v2.contains(".") ? v2.split("\\.") : new String[]{v2};
        int length = c1.length > c2.length ? c1.length : c2.length;
        for (int i = 0; i < length; i++) {
            int c1Value = i > c1.length - 1 ? 0 : Integer.valueOf(c1[i]);
            int c2Value = i > c2.length - 1 ? 0 : Integer.valueOf(c2[i]);
            int diff = c1Value - c2Value;
            if (diff > 0) {
                return 1;
            }
            if (diff < 0) {
                return -1;
            }
        }
        return 0;
    }
}
