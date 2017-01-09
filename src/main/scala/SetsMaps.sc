import scala.collection.mutable

object SetsMaps {
  val s = Set(1,2,3,3)

  val s2 = s + 4

  val mutSet = mutable.Set(1,2,3)

  mutSet += 4

  val m = Map("Texas" -> "Austin", "Colorado" -> "Denver")

  val mutMap = mutable.Map()
}