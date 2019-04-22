package test.链表.easy

import test.链表.MyNode.ListNode

/**
  * Created by mengyue on 2018/9/30. 
  */
object 删除链表中的节点Scala {


  def main(args: Array[String]): Unit = {

  }

  /**
    *
    * 删除链表中等于给定值 val 的所有节点。
    * *
    * 示例:
    * *
    * 输入: 1->2->6->3->4->5->6, val = 6
    * 输出: 1->2->3->4->5
    */

  def removeElements(head: ListNode, `val`: Int): ListNode = {
    if (head == null || head.next == null) {
      return head
    }
    val next = removeElements(head.next, `val`)
    if (head.`val` == `val`) {
      return next
    } else {
      head.next = next
    }
    head
  }
}
