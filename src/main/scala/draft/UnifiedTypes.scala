package draft

import scala.collection.mutable

object UnifiedTypes extends App {
  val set = new mutable.LinkedHashSet[Any]
  set += "This is string"
  set += 3
  set += 3.2
  set += 'x'
  set += true
  set += testFunction(4)

  val iter: Iterator[Any] = set.iterator

  while (iter.hasNext) {
    println(iter.next())
  }

  def testFunction(num: Int): Boolean = {
    num == 1
  }

}
