package test.深度优先搜索.easy;

import java.util.ArrayList;
import java.util.List;

import static test.深度优先搜索.MyTreeNode.*;

/**
 * Created by mengyue on 2018/9/23.
 */
public class 递增顺序查找树 {


    public static void main(String[] args) {


    }

    public static TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        TreeNode newRoot = new TreeNode(0);
        TreeNode cur = newRoot;
        for (int i = 0; i < list.size(); i++) {
            cur.right = new TreeNode(list.get(i));
            cur = cur.right;
        }
        return newRoot.right;
    }

    public static void recursion(TreeNode tn, List<Integer> vals) {
        if (tn == null) return;
        recursion(tn.left, vals);
        vals.add(tn.val);
        recursion(tn.right, vals);
    }
    /**
     *
     * 还有第二种解法
     */
}
