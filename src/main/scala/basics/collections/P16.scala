package basics.collections

/*
P16 (**) Drop every Nth element from a list.
Example:
scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
 */

object P16 extends App {

  def drop(times: Int, list: List[Symbol]): List[Symbol] = {
    list.zipWithIndex.filter(v => (v._2 + 1) % times != 0) map {_._1}
  }

  val droped = drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

  println(droped)
}
