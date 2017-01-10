package draft

import scala.collection.mutable

object UnifiedTypes extends App {
  val concatFunc = (v1: Int, v2: Double) => "Concat: " + v1 + " and " + v2

  val concatFunc2 = new Function2[Int, Double, String] {
    override def apply(v1: Int, v2: Double) = "Concat: " + v1 + " and " + v2
  }

  val set = new mutable.LinkedHashSet[Any]
  set += "This is string"
  set += 3
  set += 3.2
  set += 'x'
  set += true
  set += testFunction(4)
  set += concatFunc(1, 2.3)
  set += concatFunc2(1, 2.3)

  val iter: Iterator[Any] = set.iterator

  while (iter.hasNext) {
    println(iter.next())
  }

  def testFunction(num: Int): Boolean = {
    num == 1
  }


}
