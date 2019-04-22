package test.树.easy;

import static test.深度优先搜索.MyTreeNode.*;

/**
 * Created by mengyue on 2018/9/27.
 */
public class 二叉树的坡度 {


    private  int result = 0;

    public  int findTilt(TreeNode root) {
        treeSum(root);
        return result;
    }

    public  int treeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeSum(root.left);
        int right = treeSum(root.right);
        result += Math.abs(left - right);
        return left + right + root.val;
    }
}
