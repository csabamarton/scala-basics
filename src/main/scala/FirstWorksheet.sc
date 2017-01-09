object FirstWorksheet {
  println("Welcome to the Scala worksheet");

  val a = 5

  var i = 5

  val b = 15

  (4).toString

  (4.5).toInt

  "4.5".toDouble

  null

  true

  ()

  val next = if(a<9) "hi" else ""

  var result = (a*3, b) match {
    case (0,_) => "zero"
    case (i,0) => "one"
    case i => "Something bigger, " + a
  }

  result = a*3 match {
    case 0 => "zero"
    case 1 => "one"
    case `b` => "Same as b"
    case i => "Something bigger, " + a
  }
}