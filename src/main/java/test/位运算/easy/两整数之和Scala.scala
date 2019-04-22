package test.位运算.easy

/**
  * Created by mengyue on 2018/9/29. 
  */
object 两整数之和Scala {


  def main(args: Array[String]): Unit = {
    getSum(3, 5)
  }

  def getSum(a: Int, b: Int): Int = {
    a match {
      case 0 => b
      case _ => getSum((a & b) << 1, a ^ b)
    }
  }

}
