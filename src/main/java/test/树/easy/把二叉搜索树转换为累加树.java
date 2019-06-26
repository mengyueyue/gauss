package test.树.easy;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.omg.CORBA.INTERNAL;

import static test.深度优先搜索.MyTreeNode.*;


/**
 * Created by mengyue on 2019-05-24.
 */
public class 把二叉搜索树转换为累加树 {

    public static void main(String[] args) {

    }

    private int sum = 0;


    /**
     * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）
     * 它或者是一棵空树，或者是具有下列性质的二叉树：
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * 它的左、右子树也分别为二叉排序树。
     *
     * @param root
     * @return
     */


//    int count=0;
//    public TreeNode convertBST(TreeNode root) {
//        if(root==null)
//            return null;
//        convertBST(root.right);
//        root.val+=count;
//        count=root.val;
//        convertBST(root.left);
//        return root;
//    }
    public TreeNode convertBST(TreeNode root) {
        Integer sum = 0;

        if (root == null) {
            return null;
        }

        convertBST(root.right);

        sum += root.val;

        root.val = sum;

        convertBST(root.left);

        return root;
    }

}
