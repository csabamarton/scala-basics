package basics.collections

object FlattenLists extends App {

  def flatten(lists: List[Any]): List[Int] = {
    val flattenList = lists.foldLeft(List[Int]()) { (sum, element) => {
      element match {
        case List(_*) => {
          sum ::: flatten(element.asInstanceOf[List[Any]])
        }
        case element: Int => sum :+ element
      }
    }}

    flattenList
  }

  val list = flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  println(list)



}
