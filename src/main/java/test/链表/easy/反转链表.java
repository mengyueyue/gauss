package test.链表.easy;

import static test.链表.MyNode.*;

/**
 * Created by mengyue on 2018/9/17.
 */
public class 反转链表 {


    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ln1.next = ln2;
        ln2.next = ln3;
        System.out.println(reverseList(ln1));
    }


    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ln = reverseList(head.next);
        // ln.next = head;
        head.next.next = head;
        head.next = null;
        return ln;
    }


    /**
     * 方法一：
     */

//    public static ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode h = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return h;
//    }

    /**
     * 方法二：
     */
//    public static ListNode reverseList(ListNode head) {
//        ListNode next = null;
//        ListNode pre = null;
//        while (head != null) {
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;
//    }


}
