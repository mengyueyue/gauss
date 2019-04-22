package test.数学.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by mengyue on 2019/2/13.
 */
public class 增减字符串匹配 {

    /**
     *
     * 什么烂题
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(Arrays.toString(diStringMatch("IDID")));
    }

    public static int[] diStringMatch(String S) {
        int max = S.length();
        int len = S.length();
        int min = 0;
        int[] ans = new int[max + 1];
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            if (c == 'D') {
                ans[i] = max--;
            } else {
                ans[i] = min++;
            }
        }
        ans[len] = min;
        return ans;
    }

}
