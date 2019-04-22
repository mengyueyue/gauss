package test.深度优先搜索.easy;

import static test.深度优先搜索.MyTreeNode.*;

/**
 * Created by mengyue on 2018/9/23.
 */
public class 对称二叉树 {


    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return recursion(root.left, root.right);
    }

    public static boolean recursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else {
            if (left == null || right == null) {
                return false;
            } else {
                return left.val == right.val && recursion(left.left, right.right) && recursion(left.right, right.left);
            }
        }
    }
}
