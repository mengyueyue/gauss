package test.贪心算法

/**
  * Created by mengyue on 2018/9/29. 
  */
object 分发饼干Scala {


  def main(args: Array[String]): Unit = {
    val g = Array(10, 9, 8, 7)
    val s = Array(5, 6, 7, 8)
    println(findContentChildren(g, s))
  }

  /**
    * s 是饼干
    *
    * @param g
    * @param s
    * @return
    */
  def findContentChildren(g: Array[Int], s: Array[Int]): Int = {
    val newG = g.sorted
    val newS = s.sorted
    var cnt = 0
    var j = 0
    for (x <- newS.indices) {
      if (newG.length - 1 >= j && newG(j) <= newS(x)) {
        j += 1
        cnt += 1
      }
    }
    cnt
  }
}
