package basics.collections

object EliminateDuplicatesInLists extends App {

  def compress(list: List[Symbol]): List[(Int, Symbol)] = {
    def extractList(list: List[Symbol]): (Int, Symbol) = (list.size, list.head)

    if(list.isEmpty) {
      List()
    } else {
      val (before, after) = list.span(_ == list.head)

      if(after == Nil) {
        List((before.size, before.head))
      }

      else extractList(before) :: compress(after)
    }
  }

  val nonDuplicates = compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

  println(nonDuplicates)
}
