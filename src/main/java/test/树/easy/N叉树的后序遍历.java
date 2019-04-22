package test.树.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mengyue on 2018/8/29.
 */
public class N叉树的后序遍历 {


    public static void main(String[] args) {

        //////
        List<Node> l56 = new ArrayList<>();
        Node n5 = new Node(5, null);
        Node n6 = new Node(6, null);
        l56.add(n5);
        l56.add(n6);

        //////
        List<Node> l234 = new ArrayList<>();
        Node n2 = new Node(2, null);
        Node n3 = new Node(3, l56);
        Node n4 = new Node(4, null);
        l234.add(n3);
        l234.add(n2);
        l234.add(n4);

        Node n1 = new Node(1, l234);
        System.out.println(Arrays.toString(postorder(n1).toArray()));

    }

    public static List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {

            if (root.children != null) {
                for (Node child : root.children) {
                    list.addAll(postorder(child));
                }
            }
            list.add(root.val);
        }
        return list;
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
