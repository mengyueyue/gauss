object bubble_sort {


  def main(args: Array[String]): Unit = {


    val arr = List(1, 2, 5, 212, 42, 578, 93, 9)

    println(bubble(arr))

  }


  def bubble(arr: List[Int]): List[Int] = {

    @scala.annotation.tailrec
    def bubble_sort(arr: List[Int], acc: List[Int], sorted: List[Int]): List[Int] = {

      arr match {
        case x :: Nil =>
          if (acc.isEmpty)
            //递归到最后arr里什么都没有的时候 x其实就是个空集合
            x :: sorted
          else
          //这里应该是arr里还剩最后一个元素的结果
            bubble_sort(acc, Nil, x :: sorted)

        case a :: b :: xs =>

          if (a > b)
            // 最大的选出来放到arr数组 , 剩下的放到acc数组里 等待arr拿完的时候 再把acc充当arr
            bubble_sort(a :: xs, b :: acc, sorted)
          else
            bubble_sort(b :: xs, a :: acc, sorted)

      }

    }

    bubble_sort(arr, Nil, Nil)

  }

}
