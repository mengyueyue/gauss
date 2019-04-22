package test.深度优先搜索.easy;

import static test.深度优先搜索.MyTreeNode.*;

/**
 * Created by mengyue on 2018/9/23.
 */
public class 相同的树 {

    public static void main(String[] args) {

        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        p1.left = p2;
        p1.right = p3;
        System.out.println(isSameTree(p1, p1));

    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else {
            if (p == null || q == null) {
                return false;
            } else {
                return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }


}
