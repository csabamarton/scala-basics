package basics.collections

/*
P14 (*) Duplicate the elements of a list.
Example:
scala> duplicate(List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
 */

object P14 extends App {
  def duplicate(list: List[Symbol]): List[Symbol] = {
    list flatMap(x => List(x, x))
  }

  val duplicatedList = duplicate(List('a, 'b, 'c, 'c, 'd))
  println(duplicatedList)
}
