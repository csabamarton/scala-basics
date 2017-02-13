package basics.collections

/*
P23 (**) Extract a given number of randomly selected elements from a list.
Example:
scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
res0: List[Symbol] = List('e, 'd, 'a)
Hint: Use the solution to problem P20
 */

object P23 extends App {
  def randomSelect[A](num: Int, list: List[A]): List[A] = {
    if (num == 0) Nil
    else {
      val (rest, e) = P20.removeAt(new util.Random().nextInt(list.length - 1), list)
      e :: randomSelect(num - 1, rest)
    }
  }

  println(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
}
