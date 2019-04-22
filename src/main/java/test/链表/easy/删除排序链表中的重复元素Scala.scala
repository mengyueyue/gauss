package test.链表.easy

import test.链表.MyNode.ListNode

/**
  * Created by mengyue on 2018/9/30. 
  */
object 删除排序链表中的重复元素Scala {


  def main(args: Array[String]): Unit = {

  }


  /**
    *
    * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
    * *
    * 示例 1:
    * *
    * 输入: 1->1->2
    * 输出: 1->2
    * 示例 2:
    * *
    * 输入: 1->1->2->3->3
    * 输出: 1->2->3
    *
    * @param head
    * @return
    */
  def deleteDuplicates(head: ListNode): ListNode = {
    //head.next的判断 可以让最后一个元素返回自己本身 而不是null
    //这样下面就不会出现 空指针异常了
    if (head == null || head.next == null) {
      return head
    }
    val next = deleteDuplicates(head.next)
    if (next.`val` == head.`val`) {
      return next
    } else {
      head.next = next
    }
    head
  }
}
