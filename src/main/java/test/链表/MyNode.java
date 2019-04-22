package test.链表;


/**
 * Created by mengyue on 2018/9/17.
 */
public class MyNode {

    public static void main(String[] args) {

    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            String s = (next != null) ? next.toString() : "";
            return val + " " + s;
        }
    }

}




