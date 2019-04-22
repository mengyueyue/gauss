package test.深度优先搜索.easy;

import static test.深度优先搜索.MyTreeNode.*;

/**
 * Created by mengyue on 2018/9/23.
 */
public class 路径总和 {


    public static void main(String[] args) {


        TreeNode tn1 = new TreeNode(5);
        TreeNode tn2 = new TreeNode(4);
        TreeNode tn3 = new TreeNode(8);
        TreeNode tn4 = new TreeNode(11);
        TreeNode tn6 = new TreeNode(13);
        TreeNode tn7 = new TreeNode(4);
        TreeNode tn8 = new TreeNode(7);
        TreeNode tn9 = new TreeNode(2);
        TreeNode tn10 = new TreeNode(1);
        tn1.left = tn2;
        tn1.right = tn3;
        tn2.left = tn4;
        tn3.left = tn6;
        tn3.right = tn7;
        tn4.left = tn8;
        tn4.right = tn9;
        tn7.right = tn10;

        System.out.println(hasPathSum(tn1, 22));


    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null || root.val > sum) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = hasPathSum(root.right, sum - root.val);
        return left || right;
    }


}
