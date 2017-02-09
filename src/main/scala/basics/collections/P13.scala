package basics.collections

/*
P13 (**) Run-length encoding of a list (direct solution).
Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly.
Example:

scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
 */

object P13 extends App {

  def encodeDirect(list: List[Symbol]): List[(Int, Symbol)] = {
    if(list.isEmpty) Nil
    else {
      val (before, after) = list span {_ == list.head}
      (before.length, before.head) :: encodeDirect(after)
    }
  }

  private val encodeDirect: List[(Int, Symbol)] = encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  println(encodeDirect)
}
