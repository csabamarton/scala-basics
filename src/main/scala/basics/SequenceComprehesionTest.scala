package basics

object SequenceComprehesionTest extends App {
  def loop(list: List[Int]): List[Int] = {
    for (i <- list if (i % 2 == 0)) yield i
  }

  def pairing(n: Int, v: Int) = {
    for(i <- 0 until n; j <- i until n; if i + j == v) yield (i,j)
  }

  println(loop(List(1,2,3,4,5,6,7,8)))

  pairing(20, 32) foreach {
    case (i,j) => println(s"$i $j")
  }
}
