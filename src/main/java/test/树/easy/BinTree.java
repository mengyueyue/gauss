package test.树.easy;

/**
 * Created by mengyue on 2018/8/31.
 */
public class BinTree {
    private char date;
    //左孩子
    private BinTree lchild;
    //右孩子
    private BinTree rchild;

    private BinTree(char c) {
        date = c;
    }

    /**
     * 先序遍历 递归实现  节点 - 左孩子 - 右孩子
     */
    public static void preOrder1(BinTree t) {
        if (t != null) {
            System.out.print(t.date);
            preOrder1(t.lchild);
            preOrder1(t.rchild);
        }
    }

    /**
     * 中序遍历 递归实现 左孩子  - 根结点 - 右孩子
     */
    public static void InOrder2(BinTree t) {
        if (t != null) {
            InOrder2(t.lchild);
            System.out.print(t.date);
            InOrder2(t.rchild);
        }
    }

    /**
     * 后序遍历  递归实现  左孩子 - 右孩子 - 根结点
     * @param t
     */
    public static void PostOrder3(BinTree t) {
        if (t != null) {
            PostOrder3(t.lchild);
            PostOrder3(t.rchild);
            System.out.print(t.date);
        }
    }
}
