package basics.patternmatch

object PatternMatching extends App {

  abstract class Exp
  case class Fun(exp: Exp) extends Exp
  case class Number(num: Int) extends Exp
  case class Sum(exp1: Exp, exp2: Exp) extends Exp
  case class Product(exp1: Exp, exp2: Exp) extends Exp

  def print(exp: Exp): String = exp match {
    case Fun(exp) => "Fn [] (" + print(exp) + ")"
    case Product(p1, p2) => "(* " + print(p1) + " " + print(p2) + ")"
    case Number(x) => x.toString
    case Sum(e1, e2) => "(+ " + print(e1) + " + " + print(e2) + ")"
  }

  def calculate(exp: Exp): Int = exp match {
    case Fun(exp) => calculate(exp)
    case Product(p1, p2) => calculate(p1) * calculate(p2)
    case Number(x) => x
    case Sum(e1, e2) => calculate(e1) + calculate(e2)
  }


  val print1 = print(Fun(Product(Sum(Number(4), Number(2)), Number(3))))

  println(print1)
  val calResult = calculate(Fun(Product(Sum(Number(4), Number(2)), Number(3))))

  println(calResult)
}
