package basics.collections

object EliminateDuplicates extends App {

  def compress[A](list: List[A]) = {
    def innerCompress(origList: List[A], tailList: List[A]): List[A] = {
      if(origList.isEmpty){
        return tailList
      }

      val head = origList.head

      if(tailList.isEmpty || tailList.reverse.head != head) {
        innerCompress(origList.tail, tailList :+ head)
      } else {
      innerCompress(origList.tail, tailList)
      }
    }

    innerCompress(list, List[A]())
  }



  val nonDuplicates = compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

  println(nonDuplicates)
}
