package test.数组.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mengyue on 2018/9/15.
 */
public class 较大分组的位置 {


    public static void main(String[] args) {

        String s = "aaa";
        List<List<Integer>> result = largeGroupPositions(s);
        System.out.println(Arrays.toString(result.toArray()));

    }

    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> list = new ArrayList<>();
        char[] chars = S.toCharArray();
        char pre = chars[0];
        int sum = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == pre) {
                sum++;
            }
            if (chars[i] != pre || i == chars.length - 1) {
                if (sum >= 3) {
                    List<Integer> l = new ArrayList<>();
                    l.add(i - sum + 1);
                    l.add(i - 1 + 1);
                    list.add(l);
                }
                pre = chars[i];
                sum = 1;
            }
        }
        return list;
    }
}
