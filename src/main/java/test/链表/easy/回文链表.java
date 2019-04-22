package test.链表.easy;


import static test.链表.MyNode.*;

/**
 * Created by mengyue on 2018/9/19.
 */
public class 回文链表 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(isPalindrome(l1));
    }


    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //odd
        if (fast != null) {
            slow = slow.next;
        }
        slow = revest(slow);
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            } else {
                head = head.next;
                slow = slow.next;
            }
        }
        return true;
    }

    public static ListNode revest(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = revest(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
