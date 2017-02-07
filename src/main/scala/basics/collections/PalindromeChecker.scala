package basics.collections

object PalindromeChecker extends App {
  def reverse(list: List[Int]): Boolean = list.reverse == list

  println(reverse(List(1, 1, 2, 3, 5, 8)))
  println(reverse(List(1, 1, 2, 3, 5, 8, 5, 3, 2, 1, 1)))
}
