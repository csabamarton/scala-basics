package basics.collections

object ReverseList extends App {

  def reverse(list: List[Int]): List[Int] = {
    list.foldRight(List[Int]()) { (num, newList) => newList :+ num }
  }

  val revList = reverse(List(1, 1, 2, 3, 5, 8))

  println(revList)
}
