package test.链表.middle;


import java.util.Arrays;

import static test.链表.MyNode.*;

/**
 * Created by mengyue on 2018/9/30.
 */
public class 分隔链表 {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(Arrays.toString(splitListToParts(l1, 2)));

    }


    public static ListNode[] splitListToParts(ListNode root, int k) {
        int cnt = getListSize(root);
        int div = cnt / k;
        int rem = cnt % k;
        ListNode[] rst = new ListNode[k];
        ListNode pre, cur = root;
        //循环遍历
        for (int i = 0; i < k && cur != null; i++) {
            rst[i] = cur;
            for (int j = 0; j < div + (rem > 0 ? 1 : 0) - 1; j++) {
                cur = cur.next;
            }
            pre = cur.next;
            cur.next = null;
            cur = pre;
            rem--;
        }
        return rst;
    }

    public static int getListSize(ListNode root) {
        int cnt = 0;
        if (root == null) {
            return cnt;
        }
        cnt += getListSize(root.next) + 1;
        return cnt;
    }

}


