package test.深度优先搜索.easy;

import static test.深度优先搜索.MyTreeNode.*;

/**
 * Created by mengyue on 2018/9/23.
 */
public class 将有序数组转换为二叉搜索树 {


    public static void main(String[] args) {

    }


    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return recursion(0, nums.length - 1, nums);
    }

    public static TreeNode recursion(int start, int end, int[] nums) {
        if (start <= end) {
            int mid = (start + end) / 2;
            TreeNode th = new TreeNode(nums[mid]);
            th.left = recursion(start, mid - 1, nums);
            th.right = recursion(mid + 1, end, nums);
            return th;
        } else {
            return null;
        }
    }


}



