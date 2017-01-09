import scala.io.Source

object IteratorSources {

  case class TempData(day:Int,year:Int,precip:Double,aveTemp:Int,maxTemp:Int,minTemp:Int)

  def parseLine(line:String):TempData = {
    val p = line.split(",").map(_.trim)
    TempData(p(1).toInt, p(4).toInt, p(5).toDouble, p(6).toInt, p(7).toInt, p(8).toInt)
  }

  new java.io.File(".").getAbsolutePath()
  val source = Source.fromFile("/Users/csmarton/learn/transferwise/scala-tut1/src/main/resources/TX417945_1263.csv")

  val lines = source.getLines()
  lines.next
  lines.next

  val data = lines.map(parseLine).toArray

  data.map(_.maxTemp).max

  source.close

}