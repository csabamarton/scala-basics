package draft

class Decorator(left: String, right: String) {
  def layout[T](x: T) = left + x.toString + right
}

object HigherOrderFunc extends App {
  def apply(f: Int => String, v: Int) = f(v)

  val decorator = new Decorator("[", "]")
  println(apply(decorator.layout, 88))

}
