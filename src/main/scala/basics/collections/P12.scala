package basics.collections
/*
P12 (**) Decode a run-length encoded list.
Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
Example:

scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
 */

object P12 extends App {

  def decode(list: List[(Int, Symbol)]): List[Symbol] = {
    def extractTuple(count: Int, symbol: Symbol): List[Symbol] = {
      val extracted = for(i <- 0 until count) yield symbol
      extracted.toList
    }

    list match {
      case (count, symbol) :: Nil => extractTuple(count, symbol)
      case (count, symbol) :: tail => extractTuple(count, symbol) ++ decode(tail)
      case Nil => Nil
    }
  }

  val decodedList = decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))

  println(decodedList)
}
