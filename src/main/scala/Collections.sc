import scala.collection.mutable

object Collections {
  val arr = Array(1, 2, 3)

  val lst = List(7.2, 4, 9)

  arr(0)


  arr(0) = 99
  arr

  val lst2 = 1 :: lst

  val arr2 = Array.fill(10)(math.random)

  def littleArray(i: Int): Array[Int] = Array(i, i, i)

  littleArray(util.Random.nextInt(10))

  val arr3 = Array.tabulate(10)(i => i * i)

  mutable.Buffer(1, 2, 3)

  1 to 10 by 2

  0.1 to 1.0 by 0.1

  (1).to(10).by(1)
  
}