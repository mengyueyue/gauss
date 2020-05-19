object quick_sort {


  def main(args: Array[String]): Unit = {

    val arr = List[Int](1, 22, 4, 34, 13, 23, 6, 131, 55)

    println(arr.mkString(", "))

    //println(quickSort(arr).mkString(", "))
    println(quickSort(arr)((x, y) => x < y))

  }


  def quickSort[T](xs: List[T])(p: (T, T) => Boolean): List[T] = xs match {
    case Nil => Nil
    case _ =>
      val x = xs.head
      val (left, right) = xs.tail.partition(p(_, x))
      val left_sorted = quickSort(left)(p)
      val right_sorted = quickSort(right)(p)
      left_sorted ::: x :: right_sorted
  }

}
