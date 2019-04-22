package test.深度优先搜索.easy;


import org.junit.Test;

import static test.深度优先搜索.MyTreeNode.*;

/**
 * Created by mengyue on 2018/9/23.
 */
public class 二叉树的最小深度 {


    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;
        System.out.println(minDepth(t1));


    }

    /**
     *
     * 为空的子树 表示为无限大
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        if (root.left == null && root.right == null) {
            return ++count;
        }
        int left = minDepth(root.left) + 1;
        int right = minDepth(root.right) + 1;
        if (left == 1) {
            left = Integer.MAX_VALUE;
        }
        if (right == 1) {
            right = Integer.MAX_VALUE;
        }
        return Math.min(left, right);
    }


}
