package test.贪心算法

/**
  * Created by mengyue on 2018/9/29. 
  */
object 最佳买卖时机IIScala {


  def main(args: Array[String]): Unit = {

    val prices = Array(7, 1, 5, 3, 6, 4)
    maxProfit(prices)
  }

  def maxProfit(prices: Array[Int]): Int = {
    var cnt = 0
    for (x <- 1 until prices.indices.end ) {
      if (prices(x - 1) < prices(x)) {
        cnt += prices(x) - prices(x - 1)
      }
    }
    cnt
  }


}
