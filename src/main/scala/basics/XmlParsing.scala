package basics

import scala.xml.XML

object XmlParsing extends App {
  (XML.loadFile("src/main/resources/map.xml") \ "room").map(node => {
    val roomName: String = (node \ "@name").text.trim
    println(roomName)
    //roomName -> roomName
  }).toList
}
