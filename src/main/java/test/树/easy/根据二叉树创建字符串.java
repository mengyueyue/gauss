package test.树.easy;


import java.util.Stack;

import static test.深度优先搜索.MyTreeNode.*;

/**
 * Created by mengyue on 2018/10/12.
 */
public class 根据二叉树创建字符串 {


    public static void main(String[] args) {

    }


    public static String tree2str(TreeNode t) {
        if (t == null) return "";

        String result = t.val + "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if ("".equals(left) && "".equals(right)) return result;
        if ("".equals(left)) return result + "()" + "(" + right + ")";
        if ("".equals(right)) return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
    }
}
