package basics.collections

import scala.util.Random

/*
P24 (*) Lotto: Draw N different random numbers from the set 1..M.
Example:
scala> lotto(6, 49)
res0: List[Int] = List(23, 1, 17, 33, 21, 37)
 */

object P24 extends App {

  def lotto(num: Int, max: Int): List[Int] = {
    def lottoRec(needMore: Int, r: Random, preList: List[Int]): List[Int] = {
      if(needMore == 0) Nil
      else {
        val next = r.nextInt(max)
        if (preList.contains(next)) lottoRec(needMore, r, preList)
        else next :: lottoRec(needMore - 1, r, next :: preList)
      }
    }

    lottoRec(num, new util.Random(), Nil)
  }

  println(lotto(6, 49))
}
