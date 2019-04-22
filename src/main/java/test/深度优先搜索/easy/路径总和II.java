package test.深度优先搜索.easy;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

import static test.深度优先搜索.MyTreeNode.*;

/**
 * Created by mengyue on 2018/9/27.
 */
public class 路径总和II {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        recursion(list, root, sum, new ArrayList<>());
        return list;
    }

    public static void recursion(List<List<Integer>> list, TreeNode root, int sum, List<Integer> tmp) {
        if (root == null) return;
        tmp.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            list.add(new ArrayList<>(tmp));
        }
        recursion(list, root.left, sum - root.val, tmp);
        recursion(list, root.right, sum - root.val, tmp);
        tmp.remove(tmp.size() - 1);
    }

}
