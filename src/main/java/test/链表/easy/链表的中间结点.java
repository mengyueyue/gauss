package test.链表.easy;

import static test.链表.MyNode.*;

/**
 * Created by mengyue on 2018/9/19.
 */
public class 链表的中间结点 {


    public static void main(String[] args) {

    }

    /**
     *
     * 唉
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


//    public ListNode middleNode(ListNode head) {
//        int length = 0;
//        ListNode start = head;
//        while (start != null) {
//            start = start.next;
//            length++;
//
//        }
//        System.out.println(length);
//        int mid = length / 2;
//        start = head;
//        while (mid != 0) {
//            if (start.next != null) {
//                start = start.next;
//                mid--;
//            }
//        }
//        return start;
//    }
}
