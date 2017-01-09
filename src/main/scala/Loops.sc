object Loops {
  var i = 0

  while (i < 5) {
    println(i)
    i += 1
  }

  for (i <- 0 until 5) {
    println(i)
  }


  val a = Array.fill(5)(math.random)

  for (x <- a) println(x)

  for (x <- a) yield x * x

  a.map(x => x * x)

  for (i <- 1 until 5; j <- 5 until 10) yield (i, j)


  val pf:PartialFunction[Any, String] = {
    case i: Int => "Number"
    case s: String => "The string " + s
  }

  pf(3)

  pf("hello")
 

}