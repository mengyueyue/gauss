


object select_sort {

  def main(args: Array[String]): Unit = {


    val arr = List(2, 4, 12, 1, 55, 22, 14, 6)

    println(select_sort1(arr))

    println(select_sort2(arr))


  }


  def select_sort1[A](list: List[A])(implicit ev$1: A => Ordered[A]): List[A] = {
    def sort(as: List[A], bs: List[A]): List[A] = as match {
      case h :: t => select(h, t, Nil, bs)
      case Nil => bs
    }

    def select(m: A, as: List[A], zs: List[A], bs: List[A]): List[A] =
      as match {
        case h :: t =>
          if (m > h) select(m, t, h :: zs, bs)
          else select(h, t, m :: zs, bs)
        case Nil => sort(zs, m :: bs)
      }

    sort(list, Nil)

  }


  /**
    *
    * 将list里的最大（小）值放到head处
    *
    * @param xs
    * @return
    */
  def minimum(xs: List[Int]): List[Int] =
    xs match {
      case List() => List[Int]()
      case _ => (List(xs.head) /: xs.tail) {
        (ys, x) =>
          if (x > ys.head) (x :: ys)
          else (ys.head :: x :: ys.tail)
      }
    }


  def select_sort2(arr: List[Int]): List[Int] = {

    def select_sort(arr: List[Int], acc: List[Int] = List[Int]()): List[Int] = {

      arr match {
        case List() => acc
        case _ => {
          val v = minimum(arr)
          select_sort(v.tail, v.head :: acc)
        }

      }

    }
    select_sort(arr)

  }

}
