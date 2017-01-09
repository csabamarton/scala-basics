package draft

object MatchTest extends App {
  def matchTest(x: Any): Any = x match
  {
    case 1 => "One"
    case "two" => 2
    case y: Int => "An Integer but not 1"
    case _ => "String"
  }

  println(matchTest("two"))
  println(matchTest(4))
  println(matchTest(1))
  println(matchTest("apple"))


}
