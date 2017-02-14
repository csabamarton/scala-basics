package basics.collections

/*
P25 (*) Generate a random permutation of the elements of a list.
Hint: Use the solution of problem P23.
Example:

scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)
 */

object P25 extends App {
  def randomPermute[A](list: List[A]): List[A] = {
    P23.randomSelect(list.length, list)
  }

  println(randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)))
}
