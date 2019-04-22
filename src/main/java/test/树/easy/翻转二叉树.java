package test.树.easy;

/**
 * Created by mengyue on 2018/8/29.
 */
public class 翻转二叉树 {

    public static void main(String[] args) {

    }


    public static TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public static void invert(TreeNode tn) {
        if (tn == null) {
            return;
        }
        TreeNode tmp = tn.left;
        tn.left = tn.right;
        tn.right = tmp;
        invert(tn.left);
        invert(tn.right);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
