package draft

object CurryTest extends App {

  def filter(numbers: List[Int], f: Int => Boolean): List[Int] = {
    if (numbers.isEmpty) numbers
    else if (f(numbers.head)) numbers.head :: filter(numbers.tail, f)
    else filter(numbers.tail, f)
  }

  def isDivisible(divider: Int)(number: Int): Boolean = ((number % divider) == 0)

  val list1 = List(1, 2, 3, 4, 5, 6)
  val list2 = List(1, 2, 3, 4, 5, 6)

  println(filter(list1, isDivisible(2)))
  println(filter(list1, isDivisible(3)))

  println(list1.filter(isDivisible(2)))
  println(list1.filter(isDivisible(3)))
}
