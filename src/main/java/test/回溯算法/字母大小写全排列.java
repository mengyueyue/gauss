package test.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mengyue on 2018/8/13.
 */
public class 字母大小写全排列 {

    public static void main(String[] args) {


        System.out.println((int) ('a' ^ 'A') ^ 'a');

        System.out.println('a' ^ (1 << 5));
        System.out.println('A' ^ (1 << 5));
        System.out.println((int) 'a');
        System.out.println((int) 'A');

        String s = "a1b2";
        System.out.println(Arrays.toString(letterCasePermutation(s).toArray()));

    }


    public static List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        dfs(S.toCharArray(), 0, ans);
        return ans;
    }

    /**
     * 应该像课树一样来处理 因为在不考虑 数字的时候 他们的结果 应该是 字母数量的^2次方个结果
     * 例如[a,b,c] => 2^3个结果
     *
     *
     *      1。当字符是字母时,将字母变成大写，然后递归调用
     *      2。当字符是数字时，return
     * @param S
     * @param i
     * @param ans
     */
    private static void dfs(char[] S, int i, List<String> ans) {
        if (i == S.length) {
            ans.add(new String(S));
            return;
        }
        //
        dfs(S, i + 1, ans);
        if (!Character.isLetter(S[i])) return;
        //大写变小写
        S[i] ^= 1 << 5;
        //
        dfs(S, i + 1, ans);
        //将上面的小写字母变回大写
        S[i] ^= 1 << 5;
    }
}
