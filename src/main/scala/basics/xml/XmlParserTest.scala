package basics.xml

object XmlParserTest extends App {

  val xmlPath: String = "src/main/resources/movement.xml"

  assert(new java.io.File(xmlPath).exists)

  val names = (xml.XML.loadFile(xmlPath) \ "movement").filter(node => (node \ "@type").text.trim == "capoeira").map(node => {
    val capoMov = CapoeiraMovement(node)

    capoMov.name -> capoMov
  }).toMap

  println(names)
}

trait Movement {
  val name: String
  val description: String
  val movType: String
}


object CapoeiraMovement {
  def apply(node: xml.Node): CapoeiraMovement =
    {
      val name: String = (node \ "name").text.trim
      val description: String = (node \ "description").text.trim

      new CapoeiraMovement(name, description)
    }
}

class CapoeiraMovement(val name: String, val description: String) extends Movement {
  override val movType: String = "capoeira"
}

class SalsaMovement(val name: String, val description: String) extends Movement {
  override val movType: String = "salsa"
}