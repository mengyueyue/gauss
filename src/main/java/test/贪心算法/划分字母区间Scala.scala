package test.贪心算法


/**
  * Created by mengyue on 2018/9/29. 
  */
object 划分字母区间Scala {


  /**
    *
    * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
    * 返回一个表示每个字符串片段的长度的列表。
    * *
    * 示例 1:
    * *
    * 输入: S = "ababcbacadefegdehijhklij"
    * 输出: [9,7,8]
    * 解释:
    * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
    * 每个字母最多出现在一个片段中。
    * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
    * 注意:
    * *
    * S的长度在[1, 500]之间。
    * S只包含小写字母'a'到'z'。
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {
    val s = "ababcbacadefegdehijhklij"
    partitionLabels(s).foreach(println)
  }

  def partitionLabels(S: String): List[Int] = {
    var list = List[Int]()
    val chars = S.toCharArray
    val last = new Array[Int](26)
    for (x <- chars.indices) {
      last(chars(x) - 'a') = x
    }
    var j = 0
    var anchor = 0
    for (x <- chars.indices) {
      j = Math.max(j, last(chars(x) - 'a'))
      if (j == x) {
        list = list :+ (x + 1 - anchor)
        anchor = x + 1
      }
    }
    list
  }


}
