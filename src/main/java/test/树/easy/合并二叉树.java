package test.树.easy;

import static test.深度优先搜索.MyTreeNode.*;

/**
 * Created by mengyue on 2018/7/27.
 */
public class 合并二叉树 {


    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     * <p>
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * Tree 1                     Tree 2
     * 1                         2
     * / \                       / \
     * 3   2                     1   3
     * /                           \   \
     * 5                             4   7
     * 输出:
     * 合并后的树:
     * 3
     * / \
     * 4   5
     * / \   \
     * 5   4   7
     * 注意: 合并必须从两个树的根节点开始。
     *
     * @param args
     */

    public static void main(String[] args) {

        TreeNode tnLeft = new TreeNode(1);
        TreeNode tn1 = new TreeNode(3);
        tn1.left = new TreeNode(5);
        tnLeft.left = tn1;
        TreeNode tn2 = new TreeNode(2);
        tnLeft.right = tn2;


        TreeNode tnRight = new TreeNode(1);
        TreeNode tn3 = new TreeNode(1);
        TreeNode tn4 = new TreeNode(3);
        tnRight.left = tn3;
        tnRight.right = tn4;
        TreeNode tn5 = new TreeNode(4);
        tn3.right = tn5;
        TreeNode tn6 = new TreeNode(4);
        tn4.right = tn6;


        System.out.println(tnLeft.toString());
        System.out.println(tnRight.toString());
        TreeNode strTn = mergeTrees(tnLeft, tnRight);
        System.out.println(strTn);
    }


    /**
     * @param t1
     * @param t2
     * @return
     */


    // 2,4,5,null,null,4,null,null,5,null,4,null,null
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) return null;

        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);

        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return newNode;
    }
}

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//
//    @Override
//    public String toString() {
//        return String.valueOf(val) + "," + dealWith(left) + "," + dealWith(right);
//    }
//
//    public String dealWith(TreeNode tn) {
//        return tn == null ? "null" : tn.toString();
//    }
//}