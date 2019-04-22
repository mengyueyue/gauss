package test.位运算.easy

import scala.util.control.Breaks._

/**
  * Created by mengyue on 2018/9/29. 
  */
object 数字的补数Scala {


  def main(args: Array[String]): Unit = {
    val n = 5
    println(findComplement(n))
    println(findComplement1(n))
  }


  /**
    *
    * 使用 ~num & (1 <- i + 1) -1 的方式
    *
    * @param num
    * @return
    */
  def findComplement(num: Int): Int = {
    var rst = 0
    for (x <- 1.to(31).reverse) {
      breakable {
        if ((num & (1 << x)) != 0) {
          rst = ~num & ((1 << (x + 1)) - 1)
          break
        }
      }
    }
    rst
  }


  /**
    *
    * 使用 ^^ 符号
    *
    * 101 ^^ 111 = 010
    *
    * @param num
    * @return
    */
  def findComplement1(num: Int): Int = {
    var rst = 0
    for (x <- 1.to(31).reverse) {
      breakable {
        if ((num & (1 << x)) != 0) {
          rst = num ^ ((1 << (x + 1)) - 1)
          break
        }
      }
    }
    rst
  }

}
