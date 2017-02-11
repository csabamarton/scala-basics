package basics.collections

/*
P21 (*) Insert an element at a given position into a list.
Example:
scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
 */

object P21 {
  def insertAt[A](newElement: A, addAt: Int, list: List[A]) = {
    val (left, right) = list.splitAt(addAt)
    left ::: newElement :: right
  }
}
