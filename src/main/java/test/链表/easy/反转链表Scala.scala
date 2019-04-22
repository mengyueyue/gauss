package test.链表.easy

import test.链表.MyNode.ListNode

/**
  * Created by mengyue on 2018/9/30. 
  */
object 反转链表Scala {


  def main(args: Array[String]): Unit = {

    val l1 = new ListNode(1)
    val l2 = new ListNode(2)
    val l3 = new ListNode(3)
    l1.next = l2
    l2.next = l3
    println(reverseList(l1).toString)

  }

  /**
    *
    * 1 - 2 - 3- 4 - 5
    *
    * @param head
    * @return
    */
  def reverseList(head: ListNode): ListNode = {
    if (head == null || head.next == null) {
      return head
    }
    var ln = reverseList(head.next)
    //让4的next 5 的next指向 4
    // 1 -> 2 -> 3 -> 4 -> <- 5
    head.next.next = head
    //将4的next原本指向5的 给断开指向null
    //1 -> 2 -> 3 -> 4 <- 5
    head.next = null
    ln
  }


}
