package test.字符串.easy;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by mengyue on 2018/8/20.
 */
public class 亲密字符串 {

    /**
     *
     *
     * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。



     示例 1：

     输入： A = "ab", B = "ba"
     输出： true
     示例 2：

     输入： A = "ab", B = "ab"
     输出： false
     示例 3:

     输入： A = "aa", B = "aa"
     输出： true
     示例 4：

     输入： A = "aaaaaaabc", B = "aaaaaaacb"
     输出： true
     示例 5：

     输入： A = "", B = "aa"
     输出： false


     提示：

     0 <= A.length <= 20000
     0 <= B.length <= 20000
     A 和 B 仅由小写字母构成。
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(buddyStrings("acccb", "bccca"));
    }


    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            Set<Character> s = new HashSet<>();
            for (char c : A.toCharArray()) s.add(c);
            return s.size() < A.length();
        }
        int first = -1, second = -1;
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) != B.charAt(i)) {
                if (first == -1)
                    first = i;
                else if (second == -1)
                    second = i;
                else
                    return false;
            }
        }
        return (second != -1 && A.charAt(first) == B.charAt(second) &&
                A.charAt(second) == B.charAt(first));
    }
}
