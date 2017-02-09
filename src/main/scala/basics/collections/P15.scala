package basics.collections

/*
P15 (**) Duplicate the elements of a list a given number of times.
Example:
scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
 */

object P15 extends App {

  def duplicateN(num: Int, list: List[Symbol]): List[Symbol] = {
    // maybe it is cleaner to extract it
    def getHeadNTimes(times: Int, element: Symbol) = for (i <- 0 until times) yield element

    list flatMap(e => for (i <- 0 until num) yield e)
  }

  val nDuplicates = duplicateN(3, List('a, 'b, 'c, 'c, 'd))

  println(nDuplicates)
}
