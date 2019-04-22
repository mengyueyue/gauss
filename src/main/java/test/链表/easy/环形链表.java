package test.链表.easy;

import static test.链表.MyNode.*;

/**
 * Created by mengyue on 2018/12/5.
 */
public class 环形链表 {


    public static void main(String[] args) {

    }

//    public static boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null) {
//            return false;
//        }
//        ListNode fast = head;
//        ListNode slow = head;
//        boolean result = false;
//        while (true) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast) {
//                result = true;
//                break;
//            }
//            if (fast == null || fast.next == null) {
//                result = false;
//                break;
//            }
//        }
//        return result;
//    }


    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) return true;
        }
        return false;
    }

}
