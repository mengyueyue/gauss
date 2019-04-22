package test.easy;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mengyue on 2018/7/24.
 *
 *
 *
 *
     给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

    J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。


    示例 1:

    输入: J = "aA", S = "aAAbbbb"
    输出: 3

    示例 2:
    输入: J = "z", S = "ZZ"
    输出: 0
    注意:

    S 和 J 最多含有50个字母。
    J 中的字符不重复。
 *
 *
 */
public class 宝石与石头 {


    public static void main(String[] args) {

        String J = "aA";
        String S = "aAAbbbb";
        Assert.assertEquals(other(J, S), self(J, S));
    }

    /**
     * 这种方式慢的要死
     *
     * @param J
     * @param S
     * @return
     */
    public int otherMatch(String J, String S) {
        int count = 0;
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return count;
        }
        for (int i = 0; i < J.length(); i++) {
            char item = J.charAt(i);
            String compile = String.valueOf(item);
            Pattern p = Pattern.compile(compile);
            Matcher m = p.matcher(S);
            while (m.find()) {
                count++;
            }
        }
        return count;
    }


    /**
     * 不使用set 等数据结构的情况下
     */
    public static int other(String J, String S) {
        int index = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (J.charAt(i) == S.charAt(j)) {
                    index++;
                }
            }
        }
        return index;
    }

    /**
     * 自己的答案 使用了set数据结构
     *
     * @param J
     * @param S
     * @return
     */
    public static int self(String J, String S) {
        int total = 0;
        char[] c = J.toCharArray();
        Set<Character> set = new HashSet<Character>();
        for (char c1 : c) {
            set.add(c1);
        }
        for (char c1 : S.toCharArray()) {
            int a = set.contains(c1) ? total++ : total;
        }
        return total;
    }
}
