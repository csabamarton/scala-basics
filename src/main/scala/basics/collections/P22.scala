package basics.collections

import scala.annotation.tailrec

/*
P22 (*) Create a list containing all integers within a given range.
Example:
scala> range(4, 9)
res0: List[Int] = List(4, 5, 6, 7, 8, 9)
*/

object P22 extends App {
  def range(start: Int, end: Int): List[Int] = {
    (for (i <- start until (end + 1)) yield i).toList
  }

  def rangeRecursive(start: Int, end: Int): List[Int] = {
    if (start > end) Nil
    else start :: rangeRecursive(start + 1, end)
  }

  def rangeTailRecursive(start: Int, end:Int): List[Int] = {
    @tailrec
    def tailRec(start: Int, result: List[Int]): List[Int] = {
     if(start > end) result
     else tailRec(start + 1, result :+ start)
    }

    tailRec(start, Nil)
  }

  def rangeTailRecursive2(start: Int, end: Int): List[Int] = {
    def rangeR(end: Int, result: List[Int]): List[Int] = {
      if (end < start) result
      else rangeR(end - 1, end :: result)
    }
    rangeR(end, Nil)
  }

  println(range(4, 9))
  println(rangeRecursive(4, 9))
  println(rangeTailRecursive(4, 9))
  println(rangeTailRecursive2(4, 9))
}
