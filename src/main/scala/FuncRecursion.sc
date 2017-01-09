import scala.annotation.tailrec

object FuncRecursion {
  val a = 5

  def square(x: Double): Double = x * x

  val result = square(5)

  def greet(name: String): Unit = {
    println(s"Hello, $name")
  }

  greet("Csaba")


  def factorial(n: Int): Int = if (n < 2) 1 else n * factorial(n - 1)

  factorial(5)

  def estimatePi(n: Int): Double = {
    @tailrec
    def helper(n: Int,sum: Int): Double = {
      if (n < 1) sum else {
        val x = math.random()
        val y = math.random()
        helper(n-1, sum+(if(x*x+y*y<1) 1 else 0))
      }
    }
    helper(n,0)/n*4
  }

  estimatePi(1000000)
}
