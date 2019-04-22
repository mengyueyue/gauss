package test.链表.easy;

import static test.链表.MyNode.*;

/**
 * Created by mengyue on 2018/9/19.
 */
public class 删除排序链表中的重复元素 {

    /**
     *
     *
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

     示例 1:

     输入: 1->1->2
     输出: 1->2
     示例 2:

     输入: 1->1->2->3->3
     输出: 1->2->3
     *
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {

    }





    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = deleteDuplicates(head.next);
        if (head.val == next.val) {
            return next;
        } else {
            head.next = next;
        }
        return head;
    }
}
