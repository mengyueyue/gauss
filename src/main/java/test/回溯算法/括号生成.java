package test.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengyue on 2018/8/13.
 */
public class 括号生成 {


    public static void main(String[] args) {

        List<String> list = generateParenthesis(2);

        System.out.println(list);

    }


    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        doadd(n, n, list, "");
        return list;
    }

    /**
     * 有效括号的条件：就是path 字符串里的左括号 在没有拼接成的时候 左括号的个数是大于右括号的个数的 所以要控制right > left 这个条件
     * <p>
     * [((())), (()()), (())(), ()(()), ()()()]
     *
     * @param left
     * @param right
     * @param list
     * @param path
     */

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

    /**
     *
     *
     * 这种是错误的示范
     *
     * [
     * ((())), (()()), (())(), (()))(, ()(()),
     * ()()(), ()())(, ())((), ())()(, ()))((,
     *
     * )((()), )(()(), )(())(, )()((), )()()(,
     * )())((, ))(((), ))(()(, ))()((, )))(((
     * ]
     *
     * 这种的结果有20种？为什么呢？
     *
     *
     * 总共了6个元素 每个位置 可以放左括号也可以放右括号 也就是两种情况 所有一共有2^6次方个
     *
     * 但是我们左括号和右括号个有三个而已 所以就会少掉一些例如 (((((( 6个都是左括号的情况
     *
     * 然后正确的方法 又只需要 有效括号的情况 所以会更加少些
     *
     *
     *
     *
     * @param left
     * @param right
     * @param list
     * @param path
     */

//    public static void doadd(int left, int right, List<String> list, String path) {
//
//        if (left == 0 && right == 0) {
//            list.add(path);
//            return;
//        }
//        if (left != 0) {
//            doadd(left - 1, right, list, path + "(");
//        }
//        if (right != 0 ) {
//            doadd(left, right - 1, list, path + ")");
//        }
//    }
}
