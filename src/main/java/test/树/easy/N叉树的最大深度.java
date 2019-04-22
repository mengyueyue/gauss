package test.树.easy;

import java.util.List;

/**
 * Created by mengyue on 2018/8/29.
 */
public class N叉树的最大深度 {


    /**
     *
     *
     *
     * 给定一个N叉树，找到其最大深度。

     最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

     例如，给定一个 3叉树 :





     我们应返回其最大深度，3。

     说明:

     树的深度不会超过 1000。
     树的节点总不会超过 5000。
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {


    }


    public int maxDepth(Node root) {
        int max = 0;
        if (root == null) {
            return 0;
        }
//        if (root.children == null) {
//            return 1;
//        }
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        return max + 1;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
