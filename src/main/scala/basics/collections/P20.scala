package basics.collections

/*
P20 (*) Remove the Kth element from a list.
Return the list and the removed element in a Tuple. Elements are numbered from 0.
Example:

scala> removeAt(1, List('a, 'b, 'c, 'd))
res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
 */

object P20 extends App {
  def removeAt[A](num: Int, list: List[A]): (List[A], A) = {
    if(num < 0 || num >= list.length) throw new NoSuchElementException
    
    val (left, right) = list.splitAt(num)

    (left ::: right.tail, right.head)
  }

  println(removeAt(1, List('a, 'b, 'c, 'd)))
}
