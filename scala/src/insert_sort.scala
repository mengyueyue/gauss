

object insert_sort {



  //https://www.thinbug.com/q/29987130
  def main(args: Array[String]): Unit = {

    val arr = List[Int](1, 22, 4, 34, 13, 23, 6, 131, 55)

    println(arr.mkString(", "))

    println(insertionSort(arr).mkString(", "))

  }

  /**
    *
    * * 3 7 4 9 5 2 6 1
    * * 3 4 7 9 5 2 6 1
    * * 3 4 7 9 5 2 6 1
    * * 3 4 5 7 9 2 6 1
    * * 2 3 4 5 7 9 6 1
    * * 2 3 4 5 6 7 9 1
    * * 1 2 3 4 5 6 7 9
    *
    * @param input
    * @return
    */
  def insertionSort(input: List[Int]): List[Int] = {

    input.foldLeft(List[Int]())((acc, element) => {

      val (firstHalf, secondHalf) = acc.span(_ < element)

      //inserting the element at the right place
      firstHalf ::: element :: secondHalf
    })
  }

  /**
    *
    * 如果您不熟悉foldLeft，请了解其工作原理。当我们说l.foldLeft时，这意味着我们要为l的每个成员做一些事情，我们想要排序的列表。我们作为第一个参数传入一个空列表，它表示我们已经排序的列表部分（由于我们尚未完成任何操作而开始为空）。对于foldLeft的每次迭代，我们将按排序顺序添加列表中的另一个元素，并以此方式构建我们的解决方案。
    *
    * 第二个参数是一个带有两个参数的函数。第一个是累积排序列表，第二个是我们尝试添加到排序列表中的当前整数l。我们将排序列表拆分为两个列表，一个小于当前int，另一个大于/等于。然后我们在中间插入我们的int。这个函数的返回值成为下一次迭代中的第一个参数（我们称之为＆＃39; sorted＆＃39;）。
    *
    * 让我们排序l = List（3,1,2）
    *
    * 第一遍：排序=无，i = 3.越来越少都是零。该函数返回Nil + 3 + Nil，即List（3），它将在下一次传递中排序。
    *
    * 第二遍：sorted = List（3），i = 1. less = Nil，greater = List（3）。该函数返回Nil + 1 + List（3），其中= List（1,3）。
    *
    * 第3遍：sorted = List（1,3），i = 2. less = List（1），greater = List（3）。函数返回List（1）+ 2 + List（3）= List（1,2,3）。
    *
    * 在迭代了所有l之后，foldLeft返回最终累积值（最后一次迭代的最后一行的值，在我们的例子中：List（1,2,3））。
    *
    * 希望有所帮助！
    *
    */


}
