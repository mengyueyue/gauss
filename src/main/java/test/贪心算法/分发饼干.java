package test.贪心算法;

import java.util.Arrays;

/**
 * Created by mengyue on 2018/9/27.
 */
public class 分发饼干 {


    public static void main(String[] args) {

    }

    public static int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int rst = 0;
        for (int i = 0; i < s.length; i++) {
            if (j < g.length && s[i] >= g[j]) {
                rst++;
                j++;
            }
        }
        return rst;
    }
}
