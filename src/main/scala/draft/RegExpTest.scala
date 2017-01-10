package draft


object RegExpTest extends App {
  def isScalaPrefix(input: String, prefix: String): Boolean = {
    val chars: Seq[Char] = input

    val pre: Seq[Char] = prefix.toCharArray.toSeq


    chars match {
      case seq if input.startsWith(prefix) => true
      case Seq(_*) => false
    }
  }

  println(isScalaPrefix("SCALAfd", "SCALA"))
  println(isScalaPrefix("Scaslafd", "SCALA"))
}
