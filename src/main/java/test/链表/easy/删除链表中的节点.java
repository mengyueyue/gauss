package test.链表.easy;

import static test.链表.MyNode.*;

/**
 * Created by mengyue on 2018/8/23.
 */
//todo 203
public class 删除链表中的节点 {


    /**
     * 删除链表中等于给定值 val 的所有节点。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     *
     * @param args
     */
    public static void main(String[] args) {

        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ln1.next = ln2;
        ListNode ln3 = new ListNode(3);
        ln2.next = ln3;
        ListNode ln4 = new ListNode(4);
        ln3.next = ln4;
        ListNode ln5 = new ListNode(3);
        ln4.next = ln5;
        //deleteNode(ln2);

        System.out.println(removeElements(ln1, 3).toString());
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }

//
//
//    public static ListNode removeElements(ListNode head, int val) {
//
//        /**
//         * 解决办法 1
//         */
//        if (head == null) {
//            return null;
//        }
//        head.next = removeElements(head.next, val);
//        if (head.val == val) {
//            return head.next;
//        } else {
//            return head;
//        }

    /**
     * 解决办法 2
     */
//        if (head.val == val) {
//            if (head.next != null) {
//                head = head.next;
//            } else {
//                head = null;
//            }
//        }
//        if (head == null) {
//            return null;
//        }
//        head.next = removeElements(head.next, val);
//        return head;
//}

}


