package test.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengyue on 2018/8/13.
 */
public class 括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        doadd(n, n, list, "");
        return list;
    }

    public static void doadd(int left, int right, List<String> list, String path) {

        if (left == 0 && right == 0) {
            list.add(path);
            return;
        }
        if (left != 0) {
            doadd(left - 1, right, list, path + "(");
        }
        if (right != 0 && right > left) {
            doadd(left, right - 1, list, path + ")");
        }
    }
}
