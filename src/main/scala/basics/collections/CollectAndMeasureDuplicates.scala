package basics.collections

object CollectAndMeasureDuplicates extends App {
  def encodeModified(list: List[Symbol]): List[Any] = {
    def compressTuple(ls: List[Symbol]): Any = {
      ls match {
        case x if(x.size == 1) => ls(0)
        case _ => (ls.size, ls.head)
      }
    }

    val (before, after) = list.span(_ == list.head)

    if(after == Nil) List(compressTuple(before))
    else compressTuple(before) :: encodeModified(after)
  }

  val encodeModified: List[Any] = encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

  println(encodeModified)
}
