package test.深度优先搜索.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static test.深度优先搜索.MyTreeNode.*;

/**
 * Created by mengyue on 2018/9/23.
 */
public class 二叉树的所有路径 {


    public static void main(String[] args) {

    }


    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        recursion(result, root, "");
        return result;
    }

    public static void recursion(List<String> list, TreeNode tn, String tmp) {
        tmp += String.valueOf(tn.val) + " ";
        if (tn.left == null && tn.right == null) {
            list.add(tmp.trim().replace(" ", "->"));
        } else {
            if (tn.left != null) {
                recursion(list, tn.left, tmp);
            }
            if (tn.right != null) {
                recursion(list, tn.right, tmp);
            }
        }
    }
}
