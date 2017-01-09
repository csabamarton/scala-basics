package draft

trait Similarity {
  def isSimilar(obj: Any): Boolean

  def isNotSimilar(obj: Any): Boolean = !isSimilar(obj)
}

class Point(xc: Int, yc: Int) extends Similarity {
  var x: Int = xc
  var y: Int = yc

  override def isSimilar(obj: Any): Boolean =
    obj.isInstanceOf[Point] &&
      obj.asInstanceOf[Point].x == x &&
      obj.asInstanceOf[Point].y == y
}

object TraitTest extends App {

  val p1 = new Point(2, 3)
  val p2 = new Point(2, 4)
  val p3 = new Point(1, 4)
  val p4 = new Point(2, 3)

  println(p1.isSimilar(p2))
  println(p1.isSimilar(p3))
  println(p1.isSimilar(p4))

}
