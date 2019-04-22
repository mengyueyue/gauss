package test.深度优先搜索.easy;

import static test.深度优先搜索.MyTreeNode.*;

/**
 * Created by mengyue on 2018/9/23.
 */
public class 平衡二叉树 {


    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left, right) + 1;
    }


}
