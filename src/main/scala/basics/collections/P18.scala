package basics.collections

import scala.annotation.tailrec

/*
P18 (**) Extract a slice from a list.
Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
Example:

scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('d, 'e, 'f, 'g)
 */


object P18 extends App {
  def slice[A](start: Int, end: Int, list: List[A]):List[A] = {
    list slice(start, end)
  }

  def sliceRecursive[A](start: Int, end: Int, list: List[A]):List[A] = {
      (start, end, list) match {
        case (_, _, Nil) => Nil
        case (s, e, h :: tail) if(e <= 0) => Nil
        case (s, e, h :: tail) if(s > 0) => sliceRecursive(start - 1 , end - 1 , list.tail)
        case (s, e, h :: tail) => list.head :: sliceRecursive(start, end - 1, list.tail)
      }
  }

  println(sliceRecursive(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

  println(slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))


}
