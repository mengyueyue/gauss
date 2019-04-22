package test.链表.easy;

import static test.链表.MyNode.*;
import static test.链表.easy.合并两个有序链表.*;

/**
 * Created by mengyue on 2018/9/17.
 */
public class 合并K个排序列表 {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode listNode = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode ln = lists[i];
            listNode = mergeTwoLists(listNode, ln);
        }
        return listNode;
    }

}
