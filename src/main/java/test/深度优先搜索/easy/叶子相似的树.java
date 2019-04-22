package test.深度优先搜索.easy;


import java.util.ArrayList;
import java.util.List;

import static test.深度优先搜索.MyTreeNode.*;

/**
 * Created by mengyue on 2018/9/23.
 */
public class 叶子相似的树 {


    public static void main(String[] args) {

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        recursion(list1, root1);
        recursion(list2, root2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void recursion(List<Integer> list, TreeNode tn) {
        if (tn.left == null && tn.right == null) {
            list.add(tn.val);
        } else {
            if (tn.left != null) {
                recursion(list, tn.left);
            }
            if (tn.right != null) {
                recursion(list, tn.right);
            }
        }
    }
}
