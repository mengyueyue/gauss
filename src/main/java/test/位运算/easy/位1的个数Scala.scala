package test.位运算.easy

/**
  * Created by mengyue on 2018/9/29. 
  */
object 位1的个数Scala {


  def main(args: Array[String]): Unit = {
    println(hammingWeight(Integer.MAX_VALUE))
    println(hammingWeight1(Integer.MAX_VALUE))
  }


  def hammingWeight(n: Int): Int = {
    var sum = 0
    n match {
      case 0 => sum
      case _ =>
        sum += 1
        sum += hammingWeight(n & (n - 1))
        sum
    }
  }


  def hammingWeight1(n: Int): Int = {
    var sum = 0
    n match {
      case 0 => sum
      case _ =>
        sum += (n & 1)
        sum += hammingWeight1(n >>> 1)
        sum
    }
  }
}
