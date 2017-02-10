package basics.collections

/*
P19 (**) Rotate a list N places to the left.
Examples:
scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)

scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
 */

object P19 extends App {
  def rotate[A](num: Int, list: List[A]): List[A] = {

    def rotateInner[A](cNum:Int, leftList: List[A], rightList: List[A]): List[A] = {
      (cNum, rightList) match {
        case (c, head :: tail) if (c > 0) => rotateInner(c-1, leftList :+ head, tail)
        case (c, head :: tail) => head :: rotateInner(c, leftList, tail)
        case (c, Nil) => leftList
      }
    }
    rotateInner(num, List(), list)
  }

  def rotateBuiltIn[A](num: Int, list: List[A]): List[A] = {
    if(num == 0) list
    else if (num < 0) {
      val (left, right) = list.splitAt(list.length + num)
      right ::: left
    } else {
      val (left, right) = list.splitAt(num)
      right ::: left
    }
  }

  println(rotateBuiltIn(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  println(rotateBuiltIn(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

  println(rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
}
