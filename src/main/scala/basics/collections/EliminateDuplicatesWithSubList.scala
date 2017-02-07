package basics.collections

object EliminateDuplicatesWithSubList extends App {

  def pack[A](list: List[A]): List[List[A]] = {
    if(list.isEmpty){
      List(List())
    }

    val (before, after) = list.span(_ == list.head)

    if(after == Nil) List(before)
    else before +: pack(after)
  }

  val nonDuplicates = pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

  println(nonDuplicates)
}
